package linkedlist;

import java.util.Scanner;

public class SinglyLinkedList {

	private static ListNode start;

	private static class ListNode{ 
		private int data;
		private ListNode next;

		public ListNode(int data) {
			super();
			this.data = data;
			this.next = null;
		}
	}

	private static ListNode createList(ListNode head) {

		head = new ListNode(10);
		ListNode second = new ListNode(20);
		ListNode third = new ListNode(30);
		ListNode fourth = new ListNode(40);
		head.next = second;
		second.next = third;
		third.next = fourth;
		return head;
	}

	private void printList(ListNode head){
		ListNode current = head;
		System.out.print("List : ");
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println(current);
	}

	private ListNode insertAtBeginning(ListNode head, int data) {
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		head = newNode;
		return head;
	}

	private static ListNode insertAtEnd(ListNode head, int data) {
		ListNode newNode = new ListNode(data);
		if(head==null) {
			head = newNode;
			return head;
		}
		ListNode current = head;
		while(current.next!=null) {
			current = current.next;
		}
		current.next= newNode;
		return head;
	}

	private ListNode insertAfterNode(ListNode head, int data, int afterData) {
		ListNode newNode = new ListNode(data);
		ListNode current = head;
		while(current.data != afterData && current.next != null) {
			current = current.next;
		}
		if(current.data==afterData) {
			newNode.next = current.next;
			current.next = newNode;
		}
		return head;
	}

	private ListNode insertAtPosition(ListNode head, int value, int position) {
		ListNode newNode = new ListNode(value);
		if(position==1) {
			newNode.next = head;
			head = newNode;
		}else {
			ListNode previous = head;
			int count = 1;
			while(count < position-1) {
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			previous.next = newNode;
			newNode.next = current;
		}
		return head;
	}

	private static ListNode deleteFirst(ListNode head) {
		if(head==null)
			return null;

		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return head;
	}

	private ListNode deleteLast(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode current = head;
		ListNode previous = null;
		while(current.next!=null) {
			previous = current;
			current = current.next;
		}
		previous.next = null;
		return head;
	}

	private ListNode deleteByPosition(ListNode head, int position) {
		if(position==1) {
			head = head.next;
		}else {
			ListNode previous = head;
			int count = 1;
			while(count<position-1) {
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			previous.next = current.next;
		}
		return head;
	}

	private boolean search(ListNode head, int data) {
		if(head==null)
			return false;

		ListNode current = head;

		while(current!=null) {
			if(current.data==data)
				return true;
			current = current.next;
		}

		return false;
	}

	private int length(ListNode head) {
		if(head==null)
			return 0;

		int count = 0;
		ListNode current = head;
		while(current!=null) {
			count++;
			current = current.next;
		}
		return count;
	}

	private ListNode findMiddleNode(ListNode head) {
		if(head==null)
			return null;

		ListNode slowPointer = head;
		ListNode fastPointer = head;
		while(fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		return slowPointer;
	}

	private static ListNode reverseList(ListNode head) {
		if(head==null)
			return head;

		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	private static ListNode getNthNodeFromEnd(ListNode head, int n) {
		if(head ==  null)
			return null;

		if(n <= 0)
			throw new IllegalArgumentException("Invalid value n : "+n);

		ListNode mainPtr = head;
		ListNode refPtr = head;
		int count = 0;

		while(count < n) {
			if(refPtr == null)
				throw new IllegalArgumentException(n+" is greater than the number of nodes in the list");

			refPtr = refPtr.next;
			count++;
		}

		while(refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}

		return mainPtr;
	}

	public static ListNode removeDuplicateNode(ListNode head) {
		if(head == null)
			return head;

		ListNode current = head;

		while(current != null && current.next != null) {
			if(current.data == current.next.data)
				current.next = current.next.next;
			else
				current = current.next;
		}

		return head;
	}
	
	public static ListNode insertionInSortedLinkedList(ListNode head, int value) {
		ListNode newNode = new ListNode(value);
		
		if(head==null)
			return newNode;
		
		ListNode current = head;
		ListNode temp = null;
		
		while(current != null && current.data < newNode.data) {
			temp = current;
			current = current.next;
		}
		if(temp==null) {
			newNode.next = head;
			head = newNode;
			return head;
		}
		temp.next = newNode;
		newNode.next = current;
		return head;
	}
	
	public static ListNode deleteNode(ListNode head, int key) {
		ListNode current = head;
		ListNode temp = null;
		
		while(current!=null && current.data!=key) {
			temp = current;
			current = current.next;
		}
		if(current == null)
			return head;
		if(temp == null) {
			head = current.next;
			current = null;
			return head;
		}
		temp.next = current.next;
		return head;
	}
	
	public static boolean containsLoop(ListNode head) {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if(fastPtr == slowPtr)
				return true;
		}
		return false;
	}
	
	public static ListNode startNodeInALoop(ListNode head) {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if(fastPtr == slowPtr)
				return getStartingNode(slowPtr, head);
		}
		return null;
	}
	
	private static ListNode getStartingNode(ListNode slowPtr, ListNode head) {
		ListNode temp = head;
		while(temp != slowPtr) {
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		return temp;
	}
	
	public static ListNode removeLoop(ListNode head) {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if(fastPtr == slowPtr)
				return getLoopRemoved(slowPtr, head);
		}
		return null;
	}

	private static ListNode getLoopRemoved(ListNode slowPtr, ListNode head) {
		ListNode temp = head;
		while(temp.next != slowPtr.next) {
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		slowPtr.next = null;
		return head;
	}
	
	private static ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		
		while(a != null && b != null) {
			if(a.data <= b.data) {
				tail.next = a;
				a = a.next;
			}else {
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;
		}
		
		if(a==null)
			tail.next = b;
		else
			tail.next = a;
		
		return dummy.next;
	}
	
	private static ListNode addList(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int carry = 0;
		
		while(a != null || b != null) {
			int x = a!=null ? a.data : 0;
			int y = b!=null ? b.data : 0;
			int sum = carry + x + y;
			carry = sum/10;
			tail.next = new ListNode(sum%10);
			tail = tail.next;
			if(a!=null)
				a = a.next;
			if(b!=null)
				b = b.next;
		}
		if(carry>0)
			tail.next = new ListNode(carry);
		return dummy.next;
	}

	public static ListNode createLoopInLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = third;
		
		return first;
	}

	public static void main(String[] args) {

		SinglyLinkedList sll = new SinglyLinkedList();
		int choice = 0;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("------MAIN MENU------");
				System.out.println("1. Create list");
				System.out.println("2. Insert at beginning");
				System.out.println("3. Insert at end");
				System.out.println("4. Insert at given position");
				System.out.println("5. Insert after node");
				System.out.println("6. Delete first node");
				System.out.println("7. Delete last node");
				System.out.println("8. Delete node at given position");
				System.out.println("9. Serach data in linked list");
				System.out.println("10. Print list and display its length");
				System.out.println("11. Reverse the linked list");
				System.out.println("12. Find middle node of the linked list");
				System.out.println("13. Find nth node from end");
				System.out.println("14. Remove duplicate from sorted list");
				System.out.println("15. Insert in sorted linked List");
				System.out.println("16. Delete node by key");
				System.out.println("17. Loop in list");
				System.out.println("18. Find starting node in a loop");
				System.out.println("19. Remove loop from the linked list");
				System.out.println("20. Merge two sorted linked list");
				System.out.println("21. Add two linked list");
				System.out.println("22. Exit");
				System.out.println("-------------------------");

				System.out.print("Enter choice : ");

				choice = sc.nextInt();

				System.out.println("--------------------------");

				switch(choice) {
				case 1 :
					System.out.println("<1> Create predefined list (10-->20-->30-->40-->null)");
					System.out.println("<2> Create userdefined list");
					System.out.print("Enter 1 or 2 : ");
					int input = sc.nextInt();
					if(input==1) {
						start = createList(start);
					}else if(input==2) {
						System.out.println("Enter number of node u want to create in list : ");
						int num = sc.nextInt();
						for(int i=0;i<num;i++) {
							System.out.print("Enter value of node : ");
							int val = sc.nextInt();
							start = insertAtEnd(start,val);
						}
					}else {
						System.out.println("Invalid Input!");
					}
					break;
				case 2:
					System.out.print("Enter value to insert at beginning : ");
					int data = sc.nextInt();
					start = sll.insertAtBeginning(start,data);
					break;
				case 3:
					System.out.print("Enter value to insert at end : ");
					int data1 = sc.nextInt();
					start = insertAtEnd(start,data1);
					break;
				case 4:
					System.out.print("Enter position where you want to insert the element : ");
					int position = sc.nextInt();
					System.out.print("Enter value of element : ");
					int data3 = sc.nextInt();
					start = sll.insertAtPosition(start, data3, position);
					break;
				case 5:
					System.out.print("Enter value to insert at position other than start and end : ");
					int data6 = sc.nextInt();
					System.out.print("Enter data after which you want to insert : ");
					int afterData = sc.nextInt();
					start = sll.insertAfterNode(start, data6, afterData);
					break;
				case 6:
					start = deleteFirst(start);
					sll.printList(start);
					break;
				case 7:
					start = sll.deleteLast(start);
					sll.printList(start);
					break;
				case 8:
					System.out.print("Enter position of element you want to delete : ");
					int position1 = sc.nextInt();
					start = sll.deleteByPosition(start, position1);
					break;
				case 9:
					System.out.println("Enter element to search : ");
					int data4 = sc.nextInt();

					if(sll.search(start, data4))
						System.out.println(data4 + " is present in list");
					else
						System.out.println(data4 + " is not present in list");
					break;
				case 10:
					sll.printList(start);
					System.out.println("Number of nodes in the list : "+sll.length(start));
					break;
				case 11:
					start = reverseList(start);
					System.out.print("Reversed List : ");
					sll.printList(start);
					break;
				case 12:
					ListNode middleNode = sll.findMiddleNode(start);
					System.out.println("Middle node is : "+middleNode.data);
					break;
				case 13:
					System.out.print("Enter n for nth node from end : ");
					int n = sc.nextInt();
					ListNode nthNode = getNthNodeFromEnd(start,n);
					System.out.println(n + "th node from end is : "+ nthNode.data);
					break;
				case 14:
					start = removeDuplicateNode(start);
					System.out.print("List after duplicate nodes are removed : ");
					sll.printList(start);
					break;
				case 15:
					ListNode list = new ListNode(5);
					insertAtEnd(list, 10);
					insertAtEnd(list, 15);
					insertAtEnd(list, 20);
					insertAtEnd(list, 25);
					insertAtEnd(list, 30);
					sll.printList(list);
					System.out.print("Enter value to insert in sorted linked list : ");
					int val = sc.nextInt();
					list = insertionInSortedLinkedList(list, val);
					sll.printList(list);
					break;
				case 16 :
					ListNode list2 = new ListNode(5);
					insertAtEnd(list2, 10);
					insertAtEnd(list2, 6);
					insertAtEnd(list2, 25);
					insertAtEnd(list2, 18);
					insertAtEnd(list2, 21);
					sll.printList(list2);
					System.out.print("Enter key to delete from list :");
					int val2 = sc.nextInt();
					deleteNode(list2, val2);
					sll.printList(list2);
					break;
				case 17 :
					ListNode list3 = createLoopInLinkedList();
					boolean isLoop = containsLoop(list3);
					System.out.println("Is the above list contain loop ? " + isLoop);
					break;
				case 18:
					ListNode list4 = createLoopInLinkedList();
					boolean isLoop1 = containsLoop(list4);
					System.out.println("Is the above list contain loop ? " + isLoop1);
					ListNode result = startNodeInALoop(list4);
					if(result!=null)
						System.out.println("Starting Node : " + result.data);
					else
						System.out.println("Does not have a loop");
					break;
				case 19:
					ListNode list5 = createLoopInLinkedList();
					boolean isLoop2 = containsLoop(list5);
					System.out.println("Is the above list contain loop ? " + isLoop2);
					ListNode result1 = startNodeInALoop(list5);
					if(result1!=null)
						System.out.println("Starting Node : " + result1.data);
					else
						System.out.println("Does not have a loop");
					removeLoop(list5);
					sll.printList(list5);
					break;
				case 20:
					System.out.print("Enter number of elements in list1 : ");
					int n1 = sc.nextInt();
					System.out.println("Enter elements in sorted order");
					ListNode l1 = null;
					for(int i=0;i<n1;i++) {
						int val1 = sc.nextInt();
						l1 = insertAtEnd(l1, val1);
					}
					
					System.out.print("Enter number of elements in list2 : ");
					int n2 = sc.nextInt();
					System.out.println("Enter elements in sorted order");
					ListNode l2 = null;
					for(int i=0;i<n2;i++) {
						int val3 = sc.nextInt();
						l2 = insertAtEnd(l2, val3);
					}
					sll.printList(l1);
					sll.printList(l2);
					System.out.println("After merging above two list");
					sll.printList(merge(l1, l2));
					break;
				case 21:
					System.out.print("Enter number of elements in list1 : ");
					int n3 = sc.nextInt();
					System.out.println("Enter elements in sorted order");
					ListNode l3 = null;
					for(int i=0;i<n3;i++) {
						int value1 = sc.nextInt();
						l3 = insertAtEnd(l3, value1);
					}
					
					System.out.print("Enter number of elements in list2 : ");
					int n4 = sc.nextInt();
					System.out.println("Enter elements in sorted order");
					ListNode l4 = null;
					for(int i=0;i<n4;i++) {
						int value3 = sc.nextInt();
						l4 = insertAtEnd(l4, value3);
					}
					sll.printList(l3);
					sll.printList(l4);
					System.out.println("After adding above two list");
					sll.printList(addList(l3, l4));
					break;
				case 22 :
					break;
				default:
					System.out.println("Invalid choice!, Please enter valid choice from above main menu!");
				}
			}while(choice!=22);
		}
	}
}
