package searching;

public class InsertSearch {
	// this will return the index of element found & if not found then it will 
	// return expected index when inserted in the array
	public int insertSearch(int[] arr, int x) {
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
		return low;
	}

	public static void main(String[] args) {
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		InsertSearch bs = new InsertSearch();
		System.out.println(bs.insertSearch(arr, 77));
		System.out.println(bs.insertSearch(arr, 52));
		System.out.println(bs.insertSearch(arr, 110));
		System.out.println(bs.insertSearch(arr, 10));
		System.out.println(bs.insertSearch(arr, 12));
	}

}
