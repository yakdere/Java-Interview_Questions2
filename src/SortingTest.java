import static org.junit.Assert.*;

import org.junit.Test;


public class SortingTest {

	public void setUp() {
	}

	@Test
	public void test() {
		
		int[] arr = {1, 5, 12, 10, 3, -2, 15, 10};
		int[] sorted = {-2, 1, 3, 5, 10, 10, 12, 15};
		
		arr = Sorting.bubbleSort(arr);
		for (int i = 0; i < arr.length; ++i) {
			assertEquals(arr[i], sorted[i]);
		}

	}
}