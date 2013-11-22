import java.util.ArrayList;


public class PrimeNumbers {

	/**
	 * @author yakdere
	 * TODO this code has error
	 * define a number is prime or not
	 * follow up
	 * A number is called lucky if the sum of its digits, 
	 * as well as the sum of the squares of its digits is a prime number. 
	 * How many numbers between A and B are lucky?
	 */

	static int luckyNumbers(int a,int b) {
		int count = 0;
		int sum = 0;
		int s_sum = 0;
		for (int i = a; i < b; i++) { // 120 to 130
			//String s = Integer.toString(i); //"120" , 121
			//char[] a_d = s.toCharArray(); // 1, 2, 0
			//for ( int r = 0; r < a_d.length; r++) {
				//int digit = Character.getNumericValue(a_d[r]); // 1 > 2 > 0
				while (i > 0) {
					int digit = i % 10;
					sum += digit; //1 > 3 > 3
					s_sum += digit * digit; //1 > 5 > 5 
					i = i / 10;
				}
			if (isPrime(sum) && isPrime(s_sum)) { // 3 and 5 are prime
				count++; //count 1
			}
		}
		System.out.println(count);
		return count;
	}
	public static boolean isPrime(int x) {
		if (x == 1) { return true; }
		if (x < 1 | x == 2) { return false; }
		for ( int i = 2; i < x; i++) {
			if (x%i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isPrime(2));
		System.out.println(isPrime(11));
		System.out.println(isPrime(15));
		luckyNumbers(120,122);

	}

}
