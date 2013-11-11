

public class EightQueens {
	int board_size;
	int num_solns = 0;
	//constructor	
	EightQueens(int board_size) {
		this.board_size = board_size;
	}

	public boolean isGoodMove(int[][] board, int row, int col) {
		for (int i = 0; i < board_size; i++) {
			// return false if there is already a queen on the given row
			if (board[row][i] == 1) return false;
			// return false if there is already a queen on the given column
			if (board[i][col] == 1) return false;
			// return false if there is a queen on the diagonal of (row,col)
			if (row - i >= 0 && col - i >= 0 && board[row - i][col - i] == 1) return false;
			if (row + i < board_size && col + i < board_size && board[row + i][col + i] == 1) return false;
			if (row + i < board_size && col - i >= 0 && board[row + i][col - i] == 1) return false;
			if (row - i >= 0 && col + i < board_size && board[row - i][col + i] == 1) return false;
		}
		return true;
	}
	
	// Prints the given board
	public void printBoard(int[][] board) {
		System.out.println("Board " + num_solns + ":");
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				System.out.print(board[r][c] +" ");
			}
			System.out.println();
		}
	}

	public void findAllSolutions () {
		int[][] board = new int [board_size][board_size];
		for (int i = 0; i < board_size; ++i) {
			for (int j = 0; j < board_size; ++j)
				board[i][j] = 0;
		}
		findSolutions(board, 0);
	}

	public void findSolutions(int[][] board, int row) {
		// try placing the queen on all columns of this row.
		for (int col = 0; col < board_size; col++) {
			// for each such good placement:
			if (isGoodMove(board, row, col)) {
				board[row][col] = 1;
				//	if this is the last row, it is a completed solution, print it.
				if (row == board_size - 1) {
					num_solns++;
					printBoard(board);					
				} else { // else call findSolutions with row + 1
					findSolutions(board, row + 1);
				}
				board[row][col] = 0;
			}
		}
	}

	public static void main(String[] args) {
		final int BOARD_SIZE = 8;
		EightQueens myboard = new EightQueens(BOARD_SIZE);
		myboard.findAllSolutions();
	}
}
