package leetcode.problems;

public class SlidingWindowSum {
	//2, 7, 3, 5, 8, 1
	public int maxSubArrayWindowSum(int[] arr, int k) {
		int windowSum = 0;
		int maxSum = 0;
		int start = 0;
		for(int end=0;end<arr.length;end++) {
			windowSum = windowSum + arr[end];
			if(end>=k-1) {
				maxSum = Math.max(windowSum, maxSum);
				windowSum = windowSum - arr[start];
				start++;
			}
		}
		return maxSum;
	}

	public static void main(String[] args) {
		SlidingWindowSum slidingWindowSum = new SlidingWindowSum();
		int[] arr = {2, 7, 3, 5, 8, 1};
		int k = 3;
		int maxSum = slidingWindowSum.maxSubArrayWindowSum(arr, k);
		System.out.println(maxSum);
	}

}
