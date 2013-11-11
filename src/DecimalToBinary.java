
public class DecimalToBinary {

	/**
	 * @author yakdere
	 * Convert the given decimal number to binary 
	 */
	
	public static Object getBinary(int n) {
		return Integer.toBinaryString(n);
	}
	
	//implement a complement method of the binary number 
	//and return decimal equivalent of it
	public static int getIntegerComplement(int n) {
		int result = 0;
		String bin = String.valueOf(Integer.toBinaryString(n));
		for (int i = 0; i < bin.length(); i++) {
			if (bin.charAt(bin.length()-i-1) == '0') {
				result += Math.pow(2, i) * 1;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int i = 50;
		//System.out.println(getBinary(i));
		System.out.println(getIntegerComplement(i));
	}

}
