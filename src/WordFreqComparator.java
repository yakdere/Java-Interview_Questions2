import java.util.Comparator;
import java.util.Map;

//This custom comparator used by a method at Basic String Q. class

public class WordFreqComparator implements Comparator<String> {
	Map<String, Integer> countedWordsMap;
	WordFreqComparator(Map<String, Integer> countedWordsMap) {
		this.countedWordsMap = countedWordsMap;
	}
	
	@Override
	public int compare(String o1, String o2) {
		if(countedWordsMap.get(o1) >= countedWordsMap.get(o1)){
			return -1;
		} else {
			return 1;
		}
	}

}
