package leetcode.problems;

import java.util.Arrays;

public class TwoSumTarget2 {
	
	public static int[] twoSumTarget2(int[] numbers, int target) {
		Arrays.sort(numbers);
		int left = 0;
		int right = numbers.length-1;
		int[] result = new int[2];
		
		while(left<right) {
			int sum = numbers[left] + numbers[right];
			if(sum==target) {
				result[0] = numbers[left];
				result[1] = numbers[right];
				return result;
			} else if(sum<target){
				left++;
			} else {
				right--;
			}
		}
		
		return new int[0];
	}

	public static void main(String[] args) {
		int[] numbers = {3, 11, 5, 10, 6, 8};
		int target = 9;
		int[] result = twoSumTarget2(numbers, target);
		System.out.println("[" + result[0] + ", " + result[1] + "]");
	}

}
