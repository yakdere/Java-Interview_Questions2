
public class Sorting {
	
	
	static int[] insertionSort(int[] arr) {
		// TODO(yaprak): implement here.
		int i, j;
		
		return arr;
	}
	
	// bubblesort
	static int[] bubbleSort(int[] x) {
		int i, j;
		for(i = x.length - 1; i > 1; i--) {
			for (j=0; j < i; j++) {
				if(x[j+1] < x[j]) {
					int temp = x[j];
					x[j] = x[j+1];
					x[j+1] = temp;
				}
			}
		}
		return x;
	}
	
	// selection sort
	static int[] selectSort(int x[]) {
		int i, j;
		for(i = 0; i < x.length-1; i++) {
			int min = i;
			for(j=i+1; j<x.length; j++) {
				if(x[j] < x[min]) {
					min = j;
					int temp = x[j];
					x[j] = x[i];
					x[i] = temp;
				}
			}
		}
		return x;
	}
	
}

