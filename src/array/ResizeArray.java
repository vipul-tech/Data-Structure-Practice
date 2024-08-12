package array;

import java.util.Scanner;

public class ResizeArray {
	
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
			
			int[] result = resizearray(array,array.length*2);
			printArray(result);
			System.out.println(result.length);
		}
	}

	private static int[] resizearray(int[] arr, int capacity) {
		int[] temp = new int[capacity];
		for(int i=0;i<arr.length;i++) {
			temp[i]=arr[i];
		}
		return temp;
	}
	
	public static void printArray(int[] array) {
		int n = array.length;
		for(int i=0; i<n;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
