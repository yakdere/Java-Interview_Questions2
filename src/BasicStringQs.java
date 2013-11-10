import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
/**
 * 
 * @author yakdere
 * Check if a string's all characters are uniq
 * Implement a method to remove all duplicates from a given string
 *
 */

public class BasicStringQs {

	public static boolean isUniq(String s) {
    	char[] a = s.toCharArray();
    	Arrays.sort(a);
    	for ( int i = 0; i < a.length -1; i++) {
    		if (a[i] == a [i+1]) { return false; }
    	}
        return true;
    }
    public static boolean isUniq2(String s) {
    	HashSet<Character> hs = new HashSet<Character>();
    	char[] a = s.toCharArray();
    	hs.add(a[0]);
    	for ( int i = 1; i < a.length; i++) {
    		if(hs.contains(a[i])) { return false; }
    		hs.add(a[i]);
    	}
    	return true;
    }
    public static String removeDublicates(String s) {
    	for ( int i = 0; i < s.length()-1; i++) {
    		char tmp = s.charAt(i);
    		for ( int j = i+1; j < s.length(); j++) {
    			if ( tmp == s.charAt(j) && (j != s.length()-1)) {
    				s = s.substring(0, j) + s.substring(j+1);
    			} else if ( tmp == s.charAt(j) && (j == s.length()-1)) {
    				s = s.substring(0, j);
 				
    			}
    		}
    	}
    	return s;
    }
    static boolean isRotated(String str1, String str2) {
		if ( str1.length() != str2.length()) { return false; }
		String words= (str1+str1);
		return isSubstring(words, str2);
	}
	
	
	private static boolean isSubstring(String words, String str2) {
		return words.toLowerCase().contains(str2.toLowerCase());
	}

	static boolean isWordOrdered (String s) {
		char[] word = s.toCharArray();
		
		for (int i = 0; i < word.length - 1; i++) {
			if ( word[i] > word[i+1] ) { return false; }
		}
		return true;	
	}
	
	static ArrayList<String> nearby_words (String[] words, String s) {
		ArrayList<String> result = new ArrayList<String>();
		for ( int i = 0; i < words.length; i ++) {
			int diff = 0;
			for ( int j = 0; j < s.length(); j++) {
				if (words[i].charAt(j) != s.charAt(j) ) {
					diff ++;
				}
				if (diff > 2) { break; }
			}
			if ( diff <= 1) { result.add(words[i]); }
		}
		return result;
	}
	public  static int foobar(int a) {
		if (a == 1) return 1; 
	    return(a* foobar(a - 1));
	}

    	
	public static void main(String[] args) {
	  //String str = "keytr";
	 // System.out.println(isUniq2(str));
	 // String str2 = "kalabalik";
	 // System.out.println(removeDublicates(str2));
		String s1 = "waterbottle";
		String s2 = "bottlewater";
		System.out.println(isSubstring(s1, s2));
		
		String ordered = "abcdef";
		System.out.println ( isWordOrdered(ordered));
		
		String[] mywords = { "door", "moot", "boot", "boots" };
		System.out.println (nearby_words(mywords, "moor"));
		System.out.println(foobar(4));
     

	}

}
