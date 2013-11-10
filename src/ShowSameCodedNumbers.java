import java.util.ArrayList;
import java.util.HashMap;


public class ShowSameCodedNumbers {

	public void showSameCodedNumbers(ArrayList<String> inputs) {
		HashMap<Character,Character> map = new HashMap<Character, Character>();
		HashMap<String,Integer> result_map = new HashMap<String, Integer>();
		int digit = 2;
		int count = 0;
		for (char char_ = 'A'; char_ < 'Z'; char_++) {
			if (char_ == 'Q' ) {
				continue;
			}
			count++;
			map.put(char_, (char) ('0' + digit));
			if (count % 3 == 0) { 
				digit++;
			}
		}
		for (int i = 0; i < inputs.size(); i++) {
			String input = inputs.get(i).replace("-", "");
			for (int j = 0; j < input.length(); j++) {
				//if a letter shows up, change it with number
				if (map.containsKey(input.charAt(j))) {
					input = input.replace(input.charAt(j), map.get(input.charAt(j)));
				}
			}
			//input string became like 8884567, now have to be formatted like 888-4567
			input = input.substring(0, 3) + '-' + input.substring(3);
			//now put them in a map while count them
			if (!result_map.containsKey(input)) {
				result_map.put(input, 1);
			}
			else { 
				Integer timesOfSameNumber = result_map.get(input); 
				result_map.put(input, timesOfSameNumber+1);
				System.out.println(input +" "+ result_map.get(input));
			}	
		}
	}
	public static void main(String[] args) {
		ArrayList<String> numbers = new ArrayList<String>();
		numbers.add("888-GLOP");
		numbers.add("TUT-GLOP");
		numbers.add("3-10-10-10");
	    numbers.add("F101010");
		numbers.add("310-GINO");
		ShowSameCodedNumbers test_one = new ShowSameCodedNumbers();
		test_one.showSameCodedNumbers(numbers);
	}
}
