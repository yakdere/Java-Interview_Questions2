
public class QuickSort {
	int list[];
	int arr_size;
	
	
	
	public void quickSort(int[] values) {
		this.list = values;
		arr_size = values.length;
		//checking of array size
		if (arr_size == 1 || values == null) {
			return;
		}
		recQuickSort(0, arr_size -1);		
	}



	private void recQuickSort(int i, int j) {
		// creating pivot item and comparing left and right subarray's elements with pivot element
		int low = i, high = j;
		int pivot = list[ (i+j) / 2];
		
		while(i <= j) {
			while(list[i] < pivot) {
				i++;
			}
			while(list[j] > pivot) {
				j--;
			}
			if(i <= j) {
				swap(i, j);
				i++;
				j--;
			}
			//burayi anlamadim ??? Recursion
			if(low < j) {
				recQuickSort(low, j);
			}
			if(i < high) {
				recQuickSort(i, high);
			}
		}	
	}



	private void swap(int i, int j) {
		// changing the locations of elements
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;		
	}

}
