package linkedlist;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class DoublyLinkedList {

	private ListNode head;
	private ListNode tail;
	int length;

	private class ListNode{
		private int data;
		private ListNode next;
		private ListNode previous;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
			this.previous = null;
		}

	}

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public int length() {
		return length;
	}

	public void printlListForward() {
		System.out.print("ForWord Traversal : ");

		if(head==null) {
			System.out.println(head);
			return;
		}

		ListNode temp = head;
		while(temp!=null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println(temp);
	}

	public void printlListBackward() {
		System.out.print("BackWord Traversal : ");
		if(tail==null) {
			System.out.println(tail);
			return;
		}

		ListNode temp = tail;
		while(temp!=null) {
			System.out.print(temp.data + "-->");
			temp = temp.previous;
		}
		System.out.println(temp);
	}

	public void createList() {
		head = new ListNode(23);
		ListNode second = new ListNode(18);
		ListNode third = new ListNode(29);
		ListNode fourth = new ListNode(11);
		tail = new ListNode(83);

		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = tail;

		tail.previous = fourth;
		fourth.previous = third;
		third.previous = second;
		second.previous = head;
		length+=5;
	}

	public void insertAtBegining(int value) {
		ListNode newNode = new ListNode(value);

		if(isEmpty()) {
			tail = newNode;
		}else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;
	}

	public void insertAtEnd(int value) {
		ListNode newNode = new ListNode(value);

		if(isEmpty()) {
			head = newNode;
		}else {
			tail.next = newNode;
			newNode.previous = tail;
		}
		tail = newNode;
		length++;
	}
	
	public ListNode deleteFirst() {
		if(isEmpty())
			throw new NoSuchElementException();
		
		ListNode temp = head;
		if(head==tail)
			tail = null;
		else
			head.next.previous = null;
		head = head.next;
		temp.next = null;
		length--;
		return temp;
	}
	
	public ListNode deleteLast() {
		if(isEmpty())
			throw new NoSuchElementException();
		
		ListNode temp = tail;
		if(head==tail)
			head = null;
		else
			tail.previous.next = null;
		tail = tail.previous;
		temp.previous = null;
		length--;
		return temp;
	}

	public static void main(String[] args) {
		int choice = 0;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("1. Create List with predefined value "
						+ "and display in forward and reverse order");
				System.out.println("2. Insert at begining");
				System.out.println("3. Insert at end");
				System.out.println("4. Delete first node");
				System.out.println("5. Delete last node");
				System.out.println("6. Exit");
				System.out.print("Enter your choice : ");

				choice = sc.nextInt();
				switch(choice) {
				case 1:
					DoublyLinkedList dll = new DoublyLinkedList();
					dll.createList();
					dll.printlListForward();
					dll.printlListBackward();
					break;
				case 2:
					DoublyLinkedList dll2 = new DoublyLinkedList();
					
					System.out.println("Number of node in list : " + dll2.length);
					
					dll2.insertAtBegining(10);
					dll2.printlListForward();
					System.out.println("Number of node in list : " + dll2.length);

					dll2.insertAtBegining(20);
					dll2.printlListForward();
					System.out.println("Number of node in list : " + dll2.length);

					dll2.insertAtBegining(30);
					dll2.printlListForward();
					System.out.println("Number of node in list : " + dll2.length);

					dll2.insertAtBegining(40);
					dll2.printlListForward();
					System.out.println("Number of node in list : " + dll2.length);

					dll2.insertAtBegining(50);
					dll2.printlListForward();
					System.out.println("Number of node in list : " + dll2.length);
					break;
				case 3:
					DoublyLinkedList dll3 = new DoublyLinkedList();
					
					System.out.println("Number of node in list : " + dll3.length);
					
					dll3.insertAtEnd(15);
					dll3.printlListForward();
					System.out.println("Number of node in list : " + dll3.length);
					
					dll3.insertAtEnd(25);
					dll3.printlListForward();
					System.out.println("Number of node in list : " + dll3.length);

					dll3.insertAtEnd(35);
					dll3.printlListForward();
					System.out.println("Number of node in list : " + dll3.length);

					dll3.insertAtEnd(45);
					dll3.printlListForward();
					System.out.println("Number of node in list : " + dll3.length);

					dll3.insertAtEnd(55);
					dll3.printlListForward();
					System.out.println("Number of node in list : " + dll3.length);
					break;
				case 4:
					DoublyLinkedList dll4 = new DoublyLinkedList();
					dll4.createList();
					
					dll4.printlListForward();
					System.out.println("Number of node in list : " + dll4.length);
					dll4.deleteFirst();
					
					dll4.printlListForward();
					System.out.println("Number of node in list : " + dll4.length);
					dll4.deleteFirst();
					
					dll4.printlListForward();
					System.out.println("Number of node in list : " + dll4.length);
					dll4.deleteFirst();
					
					dll4.printlListForward();
					System.out.println("Number of node in list : " + dll4.length);
					dll4.deleteFirst();
					
					dll4.printlListForward();
					System.out.println("Number of node in list : " + dll4.length);
					dll4.deleteFirst();
					
					dll4.printlListForward();
					System.out.println("Number of node in list : " + dll4.length);
					break;
				case 5:
					
					DoublyLinkedList dll5 = new DoublyLinkedList();
					dll5.createList();
					
					dll5.printlListForward();
					System.out.println("Number of node in list : " + dll5.length);
					dll5.deleteLast();
					
					dll5.printlListForward();
					System.out.println("Number of node in list : " + dll5.length);
					dll5.deleteLast();
					
					dll5.printlListForward();
					System.out.println("Number of node in list : " + dll5.length);
					dll5.deleteLast();
					
					dll5.printlListForward();
					System.out.println("Number of node in list : " + dll5.length);
					dll5.deleteLast();
					
					dll5.printlListForward();
					System.out.println("Number of node in list : " + dll5.length);
					dll5.deleteLast();
					
					dll5.printlListForward();
					System.out.println("Number of node in list : " + dll5.length);
					break;
				case 6:
					break;
				default:
					System.out.println("Invalid Input!, "
							+ "Please enter from above choice only!");
				}

			}while(choice!=6);
		}
	}
}
