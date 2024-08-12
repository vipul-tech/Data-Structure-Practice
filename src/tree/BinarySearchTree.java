package tree;

public class BinarySearchTree {
	
	private TreeNode root;
	
	private class TreeNode {
		private int data;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public void insert(int value) {
		root = insert(root, value);
	}
	
	public TreeNode insert(TreeNode root, int value) {
		if(root == null) {	//base case
			root = new TreeNode(value);
			return root;
		}
		
		if(value<root.data) {
			root.left = insert(root.left, value);
		}else {
			root.right = insert(root.right, value);
		}
		return root;
	}
	
	public void inorder(TreeNode root) {
		if(root == null)
			return;
		
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	
	public void inorder() {
		inorder(root);
	}
	
	public TreeNode search(int key) {
		return search(root, key);
	}
	
	private TreeNode search(TreeNode root, int key) {
		if(root == null || root.data == key) {	//base case
			return root;
		}
		
		if(key < root.data)
			return search(root.left, key);
		else
			return search(root.right, key);
	}
	
	private boolean isValid(TreeNode root, long min, long max) {
		if(root == null)
			return true;
		
		if(root.data <= min || root.data >= max)
			return false;
		
		boolean left = isValid(root.left, min, root.data);
		if(left) {
			boolean right = isValid(root.right, root.data, max);
			return right;
		}
		return false;
	}

	private boolean isValid(long min, long max) {
		return isValid(root, min, max);
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(18);
		bst.insert(19);
		bst.insert(8);
		bst.insert(3);
		bst.insert(11); 
		bst.insert(15);
		
		bst.inorder();
		
		System.out.println();
		if(null != bst.search(50))
			System.out.println("Data found!!");
		else
			System.out.println("Data not found!!");
		
		if(bst.isValid(Long.MIN_VALUE, Long.MAX_VALUE))
			System.out.println("Valid BST!!");
		else
			System.out.println("Invalid BST!!");
	}
	
}
