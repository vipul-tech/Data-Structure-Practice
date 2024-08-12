package array;

import java.util.Scanner;

public class FindMissingNumber {
	
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
			
			int result = missingNumber(array);
			System.out.println("Missing number : "+result);
		}

	}

	private static int missingNumber(int[] arr) {
		int n = arr.length+1;
		int sum = n*(n+1)/2;
		for(int i=0;i<n-1;i++) {
			sum-=arr[i];
		}
		return sum;
	}
		
}
