
public class StudentScheduling {

	/**
	 * @yakdere
	 * In a certain dorm, there is only one computer, which students must use when doing homework.
	 *  Every student in the dorm has one assignment, which is due at a given time and takes
	 *   a given number of hours to finish. Given the assignments, we want to know whether 
	 *   it’s possible to schedule computer time in a way that allows all students to finish 
	 *   on time. The first line of the input will be an integer N (1 <= N <= 1000).
	 *   Each of the following N test cases consists of an integer X (1 <= X <= 10000),
	 *   followed by X lines, each of which contains two integers A (1 <= A <= 10000)
	 *    and B (1 <= B <= 10000). A is how many hours the assignment takes, and B is 
	 *    the number of hours in which it's due. For each test case, 
	 *    print 'possible' if all students can complete their assignments, 
	 *    and 'impossible' if not. No blank line between test cases.
	 *    Sample input 
	 *    3
	 *    2 10
	 *    3 5
	 *    4 7
	 *    output: possible
	 */
	// y is student count, in matrix is their assigment infos
	public static String isPossible(int[][] in, int y) {
		int[] a_t = new int[y];
		int[] a_due_t = new int[y];
		int max = 0;
		int loc= 0;
		for (int i = 0; i< y; i++) {
			a_t[i] = in[i][0];
			a_due_t[i] = in[i][1];
		}
		for (int i = 0; i< y; i++) {
			int diff = a_due_t[i] - a_t[i];
			if (diff > max) {
				max = diff;
				loc = i;
			}
		}
		for (int i = 0; i< y; i++) {
			if (i == loc) {
				continue;
			}
			max = max - a_t[i];
			if (max <= 0) {
				return "impossible";
			}
		}
		return "possible";
	}


	public static void main(String[] args) {
		int[][] input = { {2, 10} , {3, 5} , {4, 7} };
		System.out.println(isPossible(input, 3));

	}

}
