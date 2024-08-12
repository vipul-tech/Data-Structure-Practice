package array;

import java.util.Scanner;

public class MoveZeros {
	
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
			
			moveZerosAtLast(array);
			printArray(array);
		}
	}
	
	private static int moveZerosAtLast(int[] arr) {
		int j = 0; //j focus on zeroth element
		int temp = 0;
		for(int i=0;i<arr.length;i++) { // i focus on non-zeroth element
			if(arr[i]!=0 && arr[j]==0) {
				temp = arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
			if(arr[j]!=0)
				j++;
		}
		return 0;
	}

	public static void printArray(int[] array) {
		int n = array.length;
		for(int i=0; i<n;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
