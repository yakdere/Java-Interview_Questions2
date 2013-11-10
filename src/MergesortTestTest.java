import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;


public class MergesortTestTest {
	private int[] list;
	private final static int max = 100; 

	@Before
	public void setUp() throws Exception {
		list = new int[new Random().nextInt(max) + 1];
		Random generator = new Random();
		for (int i= 0; i < list.length; i++) {
			list[i] = generator.nextInt(max);
		}
	}

	@Test
	public void testMergesort() {
		MergeSort sorter = new MergeSort();
		sorter.sort(list);
		for (int j = 0; j < list.length - 1; j++) {
			System.out.println("list[" + j + "] = " + list[j]);
			if (list[j] > list[j + 1]) {
				fail("the array is not sorted..");
			}
		}
		System.out.println("list[" + (list.length-1) + "] = " + list[list.length-1]);

	}
}
