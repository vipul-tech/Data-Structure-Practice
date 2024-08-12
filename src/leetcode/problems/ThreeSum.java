package leetcode.problems;

import java.util.Arrays;

public class ThreeSum {
	
	public void threeSumTarget(int[] nums, int target) {
		Arrays.sort(nums);
		
		for(int i=0;i<=nums.length-3;i++) {
			int j = i+1;
			int k = nums.length-1;
			while(j<k) {
				int sum = nums[i] + nums[j] + nums[k];
				if(sum==target) {
					System.out.println("("+ i + ", " + j + ", " + k + ")");
					j++;
					k--;
				} else if(sum<target) {
					j++;
				} else {
					k--;
				}
			}
		}
	}

	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		int[] nums = {2, 4, 3, 7, 1, 8, 9, 0};
		int target = 6;
		threeSum.threeSumTarget(nums, target);
	}

}
