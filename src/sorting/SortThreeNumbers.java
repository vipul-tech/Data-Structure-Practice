package sorting;

public class SortThreeNumbers {
	
	public void sort(int[] arr) {
		//0s should be start, 1s should be in middle & 2s should be in end
		int i = 0;	// main iterator which iterate through element & also take care of 1
		int j = 0;	// keep track of 0s
		int k = arr.length-1;	// keep track of 2s
		
		// sorting the array in O(n) time & O(1) space
		while(i<=k) {	// traverse till i value crosses the k value
			if(arr[i] == 0) {	// when encounter 0 swap it with j th element
				swap(arr, i, j);
				j++;	//we increase because after swapping j th element contain 0s is at correct position
				i++;	//we increase i because there is 1 after swapping
			} else if(arr[i] == 1) {	// simply increase the i iterator because 1 is already in middle when we put 0s in start & 2s in last
				i++;
			} else {	// when encounter 0 swap it with k th element
				swap(arr, i, k);
				k--;	//we decrease because after swapping k th element contain 2s is at correct position
			}
		}
	}

	private void swap(int[] arr, int i, int k) {
		int temp = arr[i];
		arr[i] = arr[k];
		arr[k] = temp;
	}
	
	public void printArray(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = {2, 1, 0, 1, 2, 0, 2, 0, 1};
		SortThreeNumbers stn = new SortThreeNumbers();
		stn.printArray(arr);
		System.out.println();
		stn.sort(arr);
		stn.printArray(arr);
	}

}
