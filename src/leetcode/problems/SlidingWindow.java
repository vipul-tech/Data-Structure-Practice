package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SlidingWindow {
	
	public List<Integer> maxSlidingWindow(int[] arr, int k){
		int[] ngeArr = nextGreaterElement(arr);
		List<Integer> result = new ArrayList<>();
		
		for(int i=0;i<=arr.length-k;i++) {
			int j=i;
			while(ngeArr[j]<i+k) {
				j = ngeArr[j];
			}
			result.add(arr[j]);
		}
		
		return result;
	}
	
	public int[] nextGreaterElement(int[] arr) {
		int[] result = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=arr.length-1;i>=0;i--) {
			if(!stack.isEmpty()) {
				while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
					stack.pop();
				}
			}
			if(stack.isEmpty()) {
				result[i] = arr.length;
			} else {
				result[i] = stack.peek();
			}
			stack.push(i);
		}
		return result;
	}

	public static void main(String[] args) {
		SlidingWindow slidingWindow = new SlidingWindow();
		int[] arr = {44, 77, 33, 44, 88, 11};
		int[] result = slidingWindow.nextGreaterElement(arr);
		for(int i:result)
			System.out.print(i+" ");
		
		System.out.println();
		List<Integer> list = new ArrayList<Integer>();
		int k = 3;	//window size
		list = slidingWindow.maxSlidingWindow(arr,k);
		for(int i:list)
			System.out.print(i+" ");
	}

}
