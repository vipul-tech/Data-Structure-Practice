package sorting;

public class RearrangeSortedArray {

	public void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		RearrangeSortedArray sortedSquareArray = new RearrangeSortedArray();
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		System.out.print("Original sorted array : ");
		sortedSquareArray.printArray(arr);
		System.out.println();
		System.out.print("Rearranged sorted array : ");
		sortedSquareArray.rearrangeArray(arr);
		sortedSquareArray.printArray(arr);
	}

	private void rearrangeArray(int[] arr) {
		
		int maxIdx = arr.length-1;
		int minIdx = 0;
		int max = arr[maxIdx] + 1;
		
		for(int i=0;i<arr.length;i++) {
			if(i%2==0) {
				arr[i] = arr[i] + (arr[maxIdx] % max) * max;
				maxIdx--;
			} else {
				arr[i] = arr[i] + (arr[minIdx] % max) * max;
				minIdx++;
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = arr[i]/max;
		}
	}

}
