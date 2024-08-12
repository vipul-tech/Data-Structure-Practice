package searching;

public class LinearSearch {
	
	public int linearSearch(int[] arr, int n, int x) {
		for(int i=0;i<n;i++) {
			if(arr[i]==x)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {87, 23, 12, 55, 31, 43, 37, 73};
		LinearSearch ls = new LinearSearch();
		System.out.println(ls.linearSearch(arr, arr.length, 31));
		System.out.println(ls.linearSearch(arr, arr.length, 40));
	}

}
