package sorting;

public class MergeSort {
	
	public void sort(int[] arr, int[] temp, int low, int high) {
		if(low<high) {
			int mid = low + (high-low)/2;
			sort(arr, temp, low, mid);
			sort(arr, temp, mid+1, high);
			merge(arr, temp, low, mid, high);
		}
	}
	
	private void merge(int[] arr, int[] temp, int low, int mid, int high) {
		
		for(int i=low;i<=high;i++) {
			temp[i] = arr[i];
		}
		
		int i = low;
		int j = mid+1;
		int k = low;
		
		while(i<=mid && j<=high) {
			if(temp[i]<=temp[j]) {
				arr[k] = temp[i];
				i++;
			} else {
				arr[k] = temp[j];
				j++;
			}
			k++;
		}
		
		while(i<=mid) {
			arr[k] = temp[i];
			i++;
			k++;
		}
		
	}

	public void printArray(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {-1, 55, 44, 33, 22, 11};
		MergeSort ms = new MergeSort();
		System.out.print("Original array : ");
		ms.printArray(arr);
		System.out.println();
		System.out.print("Sorted array : ");
		ms.sort(arr, new int[arr.length], 0, arr.length-1);
		ms.printArray(arr);
	}

}
