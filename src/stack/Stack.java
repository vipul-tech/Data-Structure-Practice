package stack;

import java.util.EmptyStackException;
import java.util.Scanner;

//Implementation of stack using linked list

public class Stack {
	
	private StackNode top;
	private int length;
	
	private class StackNode{
		
		private int data;
		private StackNode next;
		
		public StackNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public Stack() {
		top = null;
		length = 0;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void push(int data) {
		StackNode temp = new StackNode(data);
		temp.next = top;
		top = temp;
		length++;
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			throw new EmptyStackException();
		}
		int result = top.data;
		top = top.next;
		length--;
		return result;
	}
	
	public void peek() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		System.out.println("Top element : " + top.data);
	}
	
	public void display() {
		StackNode temp = top;
		System.out.println("-----Stack element-----");
		if(temp==null)
			System.out.println("Stack is empty");
		while(temp!=null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		int choice = 0;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("1. Push");
				System.out.println("2. Pop");
				System.out.println("3. Peek/Top element");
				System.out.println("4. Print stack elemnt");
				System.out.println("5. Exit");
				System.out.print("Enter choice : ");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					System.out.print("Enter data to push into stack : ");
					int data = sc.nextInt();
					stack.push(data);
					break;
				case 2:
					int poppedValue = stack.pop();
					System.out.println("Popped element : " + poppedValue);
					break;
				case 3:
					stack.peek();
					break;
				case 4:
					stack.display();
					break;
				case 5:
					break;
				default:
					System.out.println("Invalid choice!, Please enter valid choice...");
				}
			}while(choice!=5);
		}
	}
	
}
