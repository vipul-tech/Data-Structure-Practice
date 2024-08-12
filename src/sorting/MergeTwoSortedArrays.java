package sorting;

public class MergeTwoSortedArrays {
	
	public int[] mergeSortedArray(int[] arr1, int[] arr2, int m, int n) {
		int[] result = new int[m+n];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<m && j<n) {
			if(arr1[i]<arr2[j]) {
				result[k] = arr1[i];
				i++;
			}else {
				result[k] = arr2[j];
				j++;
			}
			k++;
		}
		while(i<m) {
			result[k] = arr1[i];
			k++;
			i++;
		}
		while(j<n) {
			result[k] = arr2[j];
			k++;
			j++;
		}
		return result;
	}

	public void printArray(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr2 = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		int[] arr1 = {5, 25, 29, 69, 70};
		MergeTwoSortedArrays mtsa = new MergeTwoSortedArrays();
		System.out.print("Array 1 : ");
		mtsa.printArray(arr1);
		System.out.println();
		System.out.print("Array 2 : ");
		mtsa.printArray(arr2);
		System.out.println();
		int[] result = mtsa.mergeSortedArray(arr1, arr2, arr1.length, arr2.length);
		System.out.print("Resultant merged sorted array : ");
		mtsa.printArray(result);
	}

}
