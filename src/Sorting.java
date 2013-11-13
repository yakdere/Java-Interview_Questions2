


public class Sorting {
	
	
	public static void quickSort(int[] arr) {
		if( arr.length == 0 | arr == null) {
			return;
		}
		quickSort(arr, 0, arr.length-1);
	}
	private static void quickSort(int[] a, int start, int end) {
		int pivot = a[a.length/2];
		int i = start; 
		int j = end;
		while (i <= j) {
			while (a[i] < pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if(i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
			if (start < i) {
				quickSort(a, start, i);
			}
			if (j < end) {
				quickSort(a, j, end);
			}
		}
	}
	
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
	    numbers[i] = numbers[j];
	    numbers[j] = temp;	
	}
	// bubblesort
	static int[] bubbleSort(int[] x) {
		int i, j;
		for(i = x.length - 1; i > 1; i--) {
			for (j=0; j < i; j++) {
				if(x[j+1] < x[j]) {
					swap(x, j, j+1);
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
					//or use swap
					int temp = x[j];
					x[j] = x[i];
					x[i] = temp;
				}
			}
		}
		return x;
	}
	
	public static void main(String[] args) {
		int[] testarray = { 5, 3, -1, 0 };
		//quickSort(testarray);
		for (int i = 0; i < testarray.length; i++) {
			System.out.print(testarray[i]+" ");
		}
	}
}

