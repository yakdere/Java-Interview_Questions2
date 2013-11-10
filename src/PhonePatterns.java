import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class PhonePatterns {

	/**
	 * @author yakdere
	 * telephone numbers can be coded with the letters using of phone pattern
	 * For several phone inputs of different test cases implement a method to write which numbers
	 * entered more than once the output should be "phone number" and "count of same entry"
	 * Detail is output should be sorted by phone numbers
	 */
	 public static void run(Scanner scanner) {
		    int inputs = Integer.parseInt(scanner.nextLine());
		    ArrayList<String> input = new ArrayList<String>(inputs);
		    for ( int i = 0; i < inputs; i++) {
		       input.add(scanner.next());
		    }
		    showSameCodedNumbers(input);
		  }
		  public static void showSameCodedNumbers(ArrayList<String> inputs) {
		    HashMap<Character, Character> map = new HashMap<Character, Character>();
		    HashMap<String, Integer> result_map = new HashMap<String, Integer>();
		    List<String> ordered_result = new ArrayList<String>();
		    //first create map for phone numbers
		    int digit = 2; 
		    int count = 0;
		    for ( char c = 'A'; c < 'Z'; c++) {
		      if (c == 'Q') { 
		          continue;
		      }
		      count++;
		      map.put(c, (char)('0'+digit));
		      if (count%3 == 0) { 
		          digit++;
		      }

		    }
		    for (int i = 0; i < inputs.size(); i++) {
		      //create input string without space and hyphes
		       String input = inputs.get(i).replace(" ", "");
		      input = input.replace("-","");
		      for ( int j = 0; j < input.length(); j++) {
		          if ( map.containsKey(input.charAt(j))) { 
		            //change the letters with numbers
		            input = input.replace(input.charAt(j), map.get(input.charAt(j))); 
		          }
		      }
		      //input = input.substring(0,3)+'-'+input.substring(3);
		      if (!result_map.containsKey(input)) { 
		        //add that input string to result hash map as a first time
		        result_map.put(input, 1); }
		      else { 
		           Integer t = result_map.get(input); //get the number of repeated number
		           result_map.put(input, t+1); 
		           //the result should be ordered print out
		           //System.out.println(input+ " "+result_map.get(input));
		           ordered_result.add(input+String.valueOf(result_map.get(input)));
		    }
		   }
		    Collections.sort(ordered_result);
		    for(int i = 0; i < ordered_result.size(); i++) {
		      String str = ordered_result.get(i);
		      System.out.println(str.substring(0, 3)+"-"+str.substring(3, 7)+" "+str.substring(7));
		    }
		  }
		  public static void main(String[] args) {
		    Scanner scanner = new Scanner(System.in);
		    int cases = Integer.parseInt(scanner.nextLine());
		    for(int i = 0; i < cases; i++) {
		      run(scanner);
		    }
		  }
		}
