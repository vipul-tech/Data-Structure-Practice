package array;

import java.util.Scanner;

public class MinimumValueInArray {
	
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
			
			int min = findMinimumValueInArray(array);
			System.out.println("Minimum value : "+min);
		}
	}

	private static int findMinimumValueInArray(int[] array) {
		int min = array[0];
		for(int i=1;i<array.length;i++) {
			if(array[i]<min)
				min = array[i];
		}
		return min;
	}

}
