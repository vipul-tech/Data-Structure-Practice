package hashing;

public class HashTable {
	
	private HashNode[] buckets;
	private int numOfBuckets;	//capacity
	private int size;	//number of key-value pairs in hash table
	
	public HashTable() {
		this(10);	//default capacity
	}
	
	public HashTable(int capacity) {
		this.numOfBuckets = capacity;
		this.buckets = new HashNode[numOfBuckets];
		this.size = 0;
	}
	
	private class HashNode{
		private Integer key;	//can be generic type
		private String value;	//can be generic type
		private HashNode next;	//reference to next node
		
		public HashNode(Integer key, String value) {
			this.key = key;
			this.value = value;
		}
		
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void put(Integer key, String value) {
		if(key == null || value == null) {
			throw new IllegalArgumentException("Key or value is null !!!");
		}
		int bucketIndex = getBucketIndex(key);
		HashNode head = buckets[bucketIndex];
		while(head!=null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		size++;
		head = buckets[bucketIndex];
		HashNode node = new HashNode(key, value);
		node.next = head;
		buckets[bucketIndex] = node;
	}
	
	private int getBucketIndex(Integer key) {
		return key % numOfBuckets;
	}
	
	public String get(Integer key) {
		if(key == null) {
			throw new IllegalArgumentException("Key is null !!!");
		}
		int bucketIndex = getBucketIndex(key);
		HashNode head = buckets[bucketIndex];
		while(head!=null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}
	
	public String remove(Integer key) {
		if(key == null) {
			throw new IllegalArgumentException("Key is null !!!");
		}
		int bucketIndex = getBucketIndex(key);
		HashNode head = buckets[bucketIndex];
		HashNode previous = null;
		while(head!=null) {
			if(head.key.equals(key)) {
				break;
			}
			previous = head;
			head = head.next;
		}
		if(head==null)
			return null;
		size--;
		if(previous!=null) {
			previous.next = head.next;
		} else {
			buckets[bucketIndex] = head.next;
		}
		return head.value;
	}

	public static void main(String[] args) {
		HashTable table = new HashTable();
		table.put(105, "Sunny");
		table.put(21, "Saumya");
		table.put(31, "Vipul");
		table.put(99, "Shubham");
		table.put(21, "Smriti");
		System.out.println(table.size());
		System.out.println(table.get(105));
		System.out.println(table.get(21));
		System.out.println(table.get(31));
		System.out.println(table.get(88));
		
		System.out.println(table.remove(88));
		System.out.println(table.size());
		
		System.out.println(table.remove(21));
		System.out.println(table.size());
		
		System.out.println(table.remove(31));
		System.out.println(table.size());
		
		System.out.println(table.remove(99));
		System.out.println(table.size());
	}

}
