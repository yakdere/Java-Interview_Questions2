import java.util.Vector;


public class Solution {
	public Vector<BoardLocation> queens;
	
	Solution() { 
	this.queens = new Vector<BoardLocation>();
	}
	public void addQueens(BoardLocation loc) {
		queens.addElement(loc);
	}
	public void printSolution() {
		for (int i = 0; i < queens.size(); i++) {
			System.out.print(queens.elementAt(i).getCol() + "," + queens.elementAt(i).getRow());
		}
		System.out.print('\n');
	}
}
