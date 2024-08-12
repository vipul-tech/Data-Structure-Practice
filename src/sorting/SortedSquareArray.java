package sorting;

public class SortedSquareArray {
	
	public int[] sortedSquaredArray(int[] arr) {
		int n = arr.length;
		int i = 0;
		int j = n-1;
		int[] result = new int[n];
		
		for(int k=n-1;k>=0;k--) {
			if(Math.abs(arr[i])>Math.abs(arr[j])) {
				result[k] = arr[i] * arr[i];
				i++;
			} else {
				result[k] = arr[j] * arr[j];
				j--;
			}
		}
		
		return result;
	}
	
	public void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		SortedSquareArray sortedSquareArray = new SortedSquareArray();
		int[] arr = {-12, -4, -1, 0, 3, 10};
		System.out.print("Original sorted array : ");
		sortedSquareArray.printArray(arr);
		System.out.println();
		System.out.print("Squared sorted array : ");
		int[] result = sortedSquareArray.sortedSquaredArray(arr);
		sortedSquareArray.printArray(result);
	}

}
