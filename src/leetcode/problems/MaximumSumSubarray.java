package leetcode.problems;

public class MaximumSumSubarray {
	
	public int maximumSum(int[] arr) {
		int maxSoFar = arr[0];
		int currentMax = arr[0];
		
		for(int i=1;i<arr.length;i++) {
			currentMax = currentMax + arr[i];	//Q1 elements becomes part of current subarray
			if(currentMax < arr[i])	//Q2 elements decides to start its own subarray
				currentMax = arr[i];
			
			if(maxSoFar<currentMax)
				maxSoFar = currentMax;
		}
		
		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] arr = {4, 3, -2, 6, -12, 7, -1, 6};
		MaximumSumSubarray maximumSumSubarray = new MaximumSumSubarray();
		System.out.println("Maximum sum of subarray : " + maximumSumSubarray.maximumSum(arr));
	}

}
