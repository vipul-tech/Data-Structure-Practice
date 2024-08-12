package sorting;

public class SelectionSort {

	public void sort(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n-1;i++) {
			int min = i;
			for(int j=i+1;j<n;j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	public void printArray(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {55, 44, 33, 22, 11};
		SelectionSort ss = new SelectionSort();
		System.out.print("Original array : ");
		ss.printArray(arr);
		System.out.println();
		System.out.print("Sorted array : ");
		ss.sort(arr);
		ss.printArray(arr);
	}

}
