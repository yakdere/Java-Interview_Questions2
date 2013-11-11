
public class PrecedingPalindrome {

	/**
	 * @author yakdere
	 * 
	 * An integer is a palindrome if it has the same digits when read left to right or right to left. 
	 * For instance, 10101 is a palindrome, as is 481184, 
	 * but 1021 is not. Given an integer K, we want to find the biggest palindrome smaller than K.
	 */
	private static boolean isPalindrome(int number) {
		int palindrome = number; 
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }
        return number == reverse;
    }
	public static void biggestPalindromeIterative( int n) {
		int palindrome = 0;
		for ( int i = n-1; i > 0; i--) {
			if (isPalindrome(i)) {
				palindrome = i;
				break;
			}
		}
		System.out.println(palindrome);
	}
	public static void biggestPalindromeRecursive( int n) {
		biggestPalindrome(n-1, n, 0);
	}
	private static void biggestPalindrome(int x, int n, int lastpalindrome) {
		if (x == 0) { //base case
			System.out.println(lastpalindrome);
			return;
		}
		if (isPalindrome(x) && lastpalindrome < x) {
			lastpalindrome = x;
		}
		biggestPalindrome(x-1, n, lastpalindrome);
		return;
	}
	public static void main(String[] args) {
		biggestPalindromeRecursive(22);
		biggestPalindromeIterative(22);
		

	}

}
