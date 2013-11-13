import java.util.Arrays;
import java.util.Comparator;


public class AnagramComparator implements Comparator<String> {

	/**
	 * @author yakdere
	 *Write a method to sort an array of strings so that all the anagrams are next to each other
	 */
	//first sort each strings > [aka, aak] > [aak, aak]
	public String sortChars(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	@Override
	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(s2);
	}
}
//now we can create a class an use this custom comparator instead of usual one.
// Arrays.sort(array, new AnagramComparator());