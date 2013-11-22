
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    public static String removeDuplicates(String s) {
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
	static String getIntegers(String str) {
		if (str == null | str.length() == 0) {
			return null;
		}
		String result = "";
		for ( int i = 0; i < str.length(); i++) {
			if(Character.isDigit(str.charAt(i))) {
				result += str.charAt(i);
			}
		}
		
		return result;
	}
	static ArrayList<String> nearby_words(String[] words, String s) {
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
	public static int factorial(int a) {
		if (a == 1) return 1; 
	    return(a* factorial(a - 1));
	}
	public static String reverseString(String s) {
		if (s == null) { return null; }
		int l = s.length();
		char[] a = s.toCharArray();
		for (int i = 0; i < l/2; i++) {
			char c = a[i];
			a[i] = a[l-1-i];
			a[l-1-i] = c;
		}
		return new String(a);
	}
	public static int NthFibonacci(int n) {
		int first = 1;
		int second = 1;
		int fibo = 0;
		int count = 1;
		if ( n == 1 | n == 2) { return first; } 
		while ( count <= n - 2) {
			fibo = first + second;
			first = second; 
			second = fibo;
			count++;
		}
		return fibo;
	}
	//find the most used 10 words in a text
	public static void mostUsedWords(String text) {
		String[] words = text.toLowerCase().split(" ");
		Map<String, Integer> map = new HashMap<String,Integer>();
		WordFreqComparator wfc = new WordFreqComparator(map);
		Map<String,Integer> sorted_map = new HashMap<String,Integer>();
		//count the all words using a map
		for (String word:words) {
			if(map.containsKey(word)) {
				int c = map.get(word);
				map.put(word, c++);
			} else {
				map.put(word, 1);
			}
		}
		sorted_map.putAll(map);
		int length = sorted_map.size();
		if (length > 10) { length = 10; }
		for (Map.Entry entry : sorted_map.entrySet()) { 
			if(length==0)break;
			else
			System.out.println("Word====>" + entry.getKey() + "\t\t Times===>" + entry.getValue());
			length--;
		}
		
	}
    	
	public static void main(String[] args) {
	  //String str = "keytr";
	 // System.out.println(isUniq2(str));
	 // String str2 = "kalabalik";
	 // System.out.println(removeDublicates(str2));
	    /*
		String s1 = "waterbottle";
		String s2 = "bottlewater";
		System.out.println(isSubstring(s1, s2));
		
		String ordered = "abcdef";
		System.out.println ( isWordOrdered(ordered));
		
		String[] mywords = { "door", "moot", "boot", "boots" };
		System.out.println (nearby_words(mywords, "moor"));
		System.out.println(factorial(4));
		
		System.out.println(reverseString("Hello Yaprak"));
		System.out.println(NthFibonacci(7));
     */
		//mostUsedWords("Zoosk is a leading online dating company that learns as you click in order to pair you with singles you’re likely to be mutually attracted to. Zoosk’s Behavioral Matchmaking™ technology is constantly learning from the actions of over 25 million searchable members in order to deliver better matches in real time. With the #1 grossing online dating app in the Apple App Store, Zoosk is a market leader in mobile dating. Available in over 70 countries and translated into 25 languages, Zoosk is a truly global online dating platform.");
		
		System.out.println(getIntegers("asd32sjn jd9821"));
	}

}
