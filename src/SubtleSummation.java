


public class SubtleSummation {
	/**
	 * @param args
	 * 
	 */
	SubtleSummation() {
	}
	public String isAnySumZero(int[] array) {
		final String ZERO = "zero";
		final String ZERO_non = "nonzero";
		int sum = 0;
		for (int i = 0; i < array.length-1; i++) {
			sum += array[i];
			for (int j = i+1; j < array.length; j++ ) {
				if (sum + array[j] == 0) { 
					return ZERO;}
			}    
		}
		return ZERO_non;
	}
	public static void main(String[] args) {
		int[] somearray = {2, -1, 0, 2, 3, -2, 1};
		SubtleSummation s_s = new SubtleSummation();
		System.out.println(s_s.isAnySumZero(somearray));
	}
}
