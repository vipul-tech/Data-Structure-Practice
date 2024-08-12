package stack;

import java.util.Scanner;

//Implementation of stack using array

public class StackUsingArray {
	
	private int top;
	private int[] arr;
	
	public StackUsingArray(int capacity) {
		top = -1;
		arr = new int [capacity];
	}
	
	public StackUsingArray() {
		this(10);
	}
	
	public boolean isFull() {
		if(arr.length == size())
			return true;
		else
			return false;
	}
	
	public boolean isEmpty() {
		if(top == -1)
			return true;
		else
			return false;
	}

	public int size() {
		return top+1;
	}
	
	public void push(int data) {
		if(isFull()) {
			System.out.println("Stack is full!");
			return;
		}
		top++;
		arr[top] = data;
	}
	
	public void pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			return;
		}
		int poppedValue = arr[top];
		top--;
		System.out.println("Popped value : " + poppedValue);
	}
	
	public void peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			return;
		}
		System.out.println("Top element : " + arr[top]);
	}
	
	public int capacity() {
		return arr.length;
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			return;
		}
		for(int i=size()-1;i>=0;i--) 
			System.out.println(arr[i]);
	}
	
	public static void main(String[] args) {
		StackUsingArray stack = new StackUsingArray();
		int choice = 0;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("1. Push");
				System.out.println("2. Pop");
				System.out.println("3. Peek/Top element");
				System.out.println("4. Print stack elemnt");
				System.out.println("5. Capacity of stack");
				System.out.println("6. Exit");
				System.out.print("Enter choice : ");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					System.out.print("Enter data to push into stack : ");
					int data = sc.nextInt();
					stack.push(data);
					break;
				case 2:
					stack.pop();
					break;
				case 3:
					stack.peek();
					break;
				case 4:
					stack.display();
					break;
				case 5:
					System.out.println("Capacity of stack is : " + stack.capacity());
					break;
				case 6:
					break;
				default:
					System.out.println("Invalid choice!, Please enter valid choice...");
				}
			}while(choice!=6);
		}
	}
	
}
