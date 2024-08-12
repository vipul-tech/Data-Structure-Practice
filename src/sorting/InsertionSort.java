package sorting;

public class InsertionSort {
	
	public void sort(int[] arr) {
		int n = arr.length;
		for(int i=1;i<n;i++) { //i take care of unsorted part
			int temp = arr[i];
			int j = i-1; //j take care of sorted part
			while(j>=0 && arr[j]>temp) {
				arr[j+1] = arr[j];
				j=j-1;
			}
			arr[j+1] = temp;
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
		InsertionSort is = new InsertionSort();
		System.out.print("Original array : ");
		is.printArray(arr);
		System.out.println();
		System.out.print("Sorted array : ");
		is.sort(arr);
		is.printArray(arr);
	}

}
