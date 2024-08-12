package array;

import java.util.Scanner;

public class ReverseArray {
	
	public static void main(String[] args) {
		
		System.out.print("Enter number of elements in array : ");
		
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			
			System.out.print("Enter array's Element : ");
			int array[] = new int[n];
			
			for(int i=0;i<n;i++) {
				int k = sc.nextInt();
				array[i] = k;
			}
			
			reverseArray(array);
			printArray(array);
		}
	}
	
	private static void reverseArray(int[] arr) {
		
		int n = arr.length;
		int left = 0;
		int right = n-1;
		int temp = 0;
		
		while(left<right) {
			temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		System.out.print("Reversed Array : ");
	}

	public static void printArray(int[] array) {
		int n = array.length;
		for(int i=0; i<n;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}
