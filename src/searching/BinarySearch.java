package searching;

public class BinarySearch {
	
	public int binarySearch(int[] arr, int x) {
		int low = 0;
		int high = arr.length-1;
		
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(arr[mid] == x)
				return mid;
			
			if(arr[mid]<x)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.binarySearch(arr, 77));
		System.out.println(bs.binarySearch(arr, 22));
		System.out.println(bs.binarySearch(arr, 110));
	}

}
