package sorting;

public class QuickSort {
	
	public void sort(int[] arr, int low, int high) {
		if(low<high) {
			int p = partition(arr, low, high);
			sort(arr, low, p-1);
			sort(arr, p+1, high);
		}
	}

	private int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low;
		int j = low;
		while(i<=high) {
			if(arr[i]<=pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
			i++;
		}
		return j-1;
	}
	
	public void printArray(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = {-1, 55, 4, 33, 2, 11};
		QuickSort qs = new QuickSort();
		System.out.print("Original array : ");
		qs.printArray(arr);
		System.out.println();
		System.out.print("Sorted array : ");
		qs.sort(arr, 0, arr.length-1);
		qs.printArray(arr);
	}

}
