package queue;

import java.util.Scanner;

public class Queue {
	private QueueNode front;
	private QueueNode rear;
	private int length;
	
	public Queue() {
		this.front = null;
		this.rear = null;
		this.length = 0;
	}
	
	private class QueueNode{
		private int data;
		private QueueNode next;
		
		public QueueNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public int length() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void enQueue(int data) {
		QueueNode newNode = new QueueNode(data);
		if(isEmpty())
			front = newNode;
		else
			rear.next = newNode;
		rear = newNode;
		length++;
	}
	
	public void deQueue() {
		if(isEmpty()) {
			System.out.println("Can not be dequeued because Queue is empty!");
			return;
		}
		
		int result = front.data;
		System.out.println("Dqueued element : " + result);
		
		front = front.next;
		if(front == null)
			rear = null;
		
		length--;
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		QueueNode current = front;
		while(current!=null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.println(current);
	}
	
	public void first() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Front element : " + front.data);
	}
	
	public void last() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Rear element : " + rear.data);
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		int choice = 0;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("1. Enqueue");
				System.out.println("2. Dequeue");
				System.out.println("3. Front element");
				System.out.println("4. Rear element");
				System.out.println("5. Print queue element");
				System.out.println("6. Exit");
				
				System.out.print("Enter choice : ");
				choice = sc.nextInt();
				switch(choice) {
				case 1:
					System.out.print("Enter data to enqueue into queue : ");
					int data = sc.nextInt();
					queue.enQueue(data);
					break;
				case 2:
					queue.deQueue();
					break;
				case 3:
					queue.first();
					break;
				case 4:
					queue.last();
					break;
				case 5:
					queue.display();
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
