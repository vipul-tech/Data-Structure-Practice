package array;

import java.util.Scanner;

public class SecondMaximum {
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
			
			int secondMaximum = secondMaximumValueInArray(array);
			System.out.println("Second Maximum value : "+ secondMaximum);
		}
	}

	private static int secondMaximumValueInArray(int[] array) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for(int i=0;i<array.length;i++) {
			if(array[i]>max) {
				secondMax = max;
				max = array[i];
			}else if(array[i]>secondMax && array[i]!=max) {
				secondMax = array[i];
			}
		}
		return secondMax;
	}
}
