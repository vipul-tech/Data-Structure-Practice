package stack;

import java.util.Stack;

public class GreaterElement {
	
	public int[] greaterElementArray(int[] arr) {
		int[] result = new int[arr.length];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=arr.length-1;i>=0;i--) {
			if(!stack.isEmpty()) {
				while(!stack.isEmpty() && stack.peek() <= arr[i]) {
					stack.pop();
				}
			}
			if(stack.isEmpty())
				result[i] = -1;
			else
				result[i] = stack.peek();
			stack.push(arr[i]);
		}
		
		return result;
	}
	
	public void display(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		GreaterElement greaterElement = new GreaterElement();
		
		int[] arr = {4,7,3,4,8,1};
		System.out.print("Original array : ");
		greaterElement.display(arr);
		
		int[] result = greaterElement.greaterElementArray(arr);
		System.out.print("Updated array  : ");
		greaterElement.display(result);
	}
	
}
