
public class CachedCalculations {

	/**
	 * @author yakdere
	 * Given a number N (1 <= N <= 50), 
	 * print the number of distinct ways to write N as the sum of 1, 2, and 4.
	 * The order of the terms DOES matter, 
	 * so for N=7, 1+2+4 and 4+2+1 would count as different solutions.
	 */
	
	public static int waysOfSum(int n) {
		if( n == 1) {
			return waysOfSum(n, 1);
		} if (n < 4) { 
			return waysOfSum(n, 2); 
		} else { 
			return waysOfSum(n, 2) + waysOfSum(n, 4);
		}
	}
	private static int waysOfSum(int n, int d) {
		int next = 0;
		switch(d) {
		case 4:
			next = 2;
			break;
		case 2:
			next = 1;
			break;
		case 1: 
			return 1;
		}
		int ways = 0;
		for (int i = 0; i*next < n; i++) {
			ways += waysOfSum(n - i*next, next);
		}
		return ways;
	}
	public static void main(String[] args) {
		System.out.println(waysOfSum(6));
		System.out.println(waysOfSum(1));
		System.out.println(waysOfSum(2));
		System.out.println(waysOfSum(5));

	}

}
