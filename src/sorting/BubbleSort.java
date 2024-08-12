package sorting;

public class BubbleSort {
	
	public void sort(int[] arr) {
		int n = arr.length;
		boolean isSwapped;
		for(int i=0;i<n-1;i++) {
			isSwapped = false;
			for(int j=0;j<n-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					isSwapped = true;
				}
			}
			if(isSwapped == false)
				break;
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
		BubbleSort bs = new BubbleSort();
		System.out.print("Original array : ");
		bs.printArray(arr);
		System.out.println();
		System.out.print("Sorted array : ");
		bs.sort(arr);
		bs.printArray(arr);
	}

}
