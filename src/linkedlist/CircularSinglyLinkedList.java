package linkedlist;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CircularSinglyLinkedList {
	
	private ListNode last;
	private int length;
	
	private class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public CircularSinglyLinkedList(){
		last = null;
		length =0;
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public ListNode getLastNode() {
		return last;
	}
	
	public void createList() {
		ListNode first = new ListNode(11);
		ListNode second = new ListNode(21);
		ListNode third = new ListNode(31);
		ListNode fourth = new ListNode(41);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = first;
		
		last = fourth;
		
		length+=4;
	}
	
	public void printList() {
		if(last==null){
			System.out.println(last);
			return;
		}
		
		ListNode temp = last.next;
		while(temp!=last) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println(temp.data + "-->" + temp.next.data);
	}
	
	public void insertAtBegining(int value) {
		ListNode newNode = new ListNode(value);
		if(last==null) {
			last = newNode;
		}else {
			newNode.next = last.next; 
		}
		last.next = newNode;
		length++;
	}
	
	public void insertAtEnd(int value) {
		ListNode newNode = new ListNode(value);
		if(last==null) {
			last = newNode;
			last.next = last;
		}else {
			newNode.next = last.next;
			last.next = newNode;
			last = newNode;
		}
		length++;
	}
	
	public int deleteFirst() {
		if(isEmpty())
			throw new NoSuchElementException();
		
		ListNode first = last.next;
		int result = first.data;
		if(last.next==last) 
			last = null;
		else 
			last.next = first.next;

		//first.next = null;
		length--;
		return result;
	}
	
	public static void main(String[] args) {
		int choice = 0;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("1. Create List with predefined value");
				System.out.println("2. Insert at begining");
				System.out.println("3. Insert at end");
				System.out.println("4. Delete first node");
				System.out.println("5. Exit");
				System.out.print("Enter your choice : ");

				choice = sc.nextInt();
				switch(choice) {
					case 1:
						CircularSinglyLinkedList csll1 = new CircularSinglyLinkedList();
						csll1.createList();
						csll1.printList();
						System.out.println("Number of Node : " + csll1.length() + 
								"; Last Node : " + csll1.getLastNode().data);
						break;
					case 2:
						CircularSinglyLinkedList csll2 = new CircularSinglyLinkedList();
						csll2.printList();
						
						csll2.insertAtBegining(10);
						csll2.printList();
						System.out.println("Number of Node : " + csll2.length() + 
								"; Last Node : " + csll2.getLastNode().data);
						
						csll2.insertAtBegining(20);
						csll2.printList();
						System.out.println("Number of Node : " + csll2.length() + 
								"; Last Node : " + csll2.getLastNode().data);
						
						csll2.insertAtBegining(30);
						csll2.printList();
						System.out.println("Number of Node : " + csll2.length() + 
								"; Last Node : " + csll2.getLastNode().data);
						
						csll2.insertAtBegining(40);
						csll2.printList();
						System.out.println("Number of Node : " + csll2.length() + 
								"; Last Node : " + csll2.getLastNode().data);
						
						csll2.insertAtBegining(50);
						csll2.printList();
						System.out.println("Number of Node : " + csll2.length() + 
								"; Last Node : " + csll2.getLastNode().data);
						break;
					case 3:
						CircularSinglyLinkedList csll3 = new CircularSinglyLinkedList();
						csll3.printList();
						
						csll3.insertAtEnd(10);
						csll3.printList();
						System.out.println("Number of Node : " + csll3.length() + 
								"; Last Node : " + csll3.getLastNode().data);
						
						csll3.insertAtEnd(20);
						csll3.printList();
						System.out.println("Number of Node : " + csll3.length() + 
								"; Last Node : " + csll3.getLastNode().data);
						
						csll3.insertAtEnd(30);
						csll3.printList();
						System.out.println("Number of Node : " + csll3.length() + 
								"; Last Node : " + csll3.getLastNode().data);
						
						csll3.insertAtEnd(40);
						csll3.printList();
						System.out.println("Number of Node : " + csll3.length() + 
								"; Last Node : " + csll3.getLastNode().data);
						
						csll3.insertAtEnd(50);
						csll3.printList();
						System.out.println("Number of Node : " + csll3.length() + 
								"; Last Node : " + csll3.getLastNode().data);
						break;
					case 4:
						CircularSinglyLinkedList csll4 = new CircularSinglyLinkedList();
						csll4.createList();
						csll4.printList();
						System.out.println("Number of Node : " + csll4.length() + 
								"; Last Node : " + csll4.getLastNode().data);
						
						System.out.println("Deleted node : " + csll4.deleteFirst());
						csll4.printList();
						System.out.println("Number of Node : " + csll4.length() + 
								"; Last Node : " + csll4.getLastNode().data);
						System.out.println("Deleted node : " + csll4.deleteFirst());
						csll4.printList();
						System.out.println("Number of Node : " + csll4.length() + 
								"; Last Node : " + csll4.getLastNode().data);
						System.out.println("Deleted node : " + csll4.deleteFirst());
						csll4.printList();
						System.out.println("Number of Node : " + csll4.length() + 
								"; Last Node : " + csll4.getLastNode().data);
						System.out.println("Deleted node : " + csll4.deleteFirst());
						csll4.printList();
						System.out.println("Number of Node : " + csll4.length());
						break;
					case 5:
						break;
					default:
						System.out.println("Invalid Input!, "
								+ "Please enter from above choice only!");
				}
			}while(choice!=5);
		}
		
	}

}
