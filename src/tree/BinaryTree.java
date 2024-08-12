package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	private TreeNode root;
	
	private class TreeNode{
		
		private int data;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
	
	public BinaryTree() {
		this.root = null;
	}
	
	public void createBinaryTree() {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);
		TreeNode sixth = new TreeNode(6);
		TreeNode seventh = new TreeNode(7);
		
		root = first;
		first.left = second;
		first.right = third;
		second.left = fourth;
		second.right = fifth;
		third.left = sixth;
		third.right = seventh;
	}
	
	public void preOrderTraversal(TreeNode root) {
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	public void inOrderTraversal(TreeNode root) {
		if(root == null)
			return;
		
		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}
	
	public void postOrderTraversal(TreeNode root) {
		if(root == null)
			return;
		
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + " ");
	}
	
	public void iterativePreOrderTraversal(TreeNode root) {
		if(root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.empty()) {
			
			TreeNode temp = stack.pop();
			System.out.print(temp.data + " ");
			
			if(temp.right != null)
				stack.push(temp.right);
			
			if(temp.left != null)
				stack.push(temp.left);
		}
	}
	
	public void iterativeInOrderTraversal(TreeNode root) {
		if(root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = root;
		
		while(!stack.empty() || temp != null) {
			
			if(temp != null) {
				stack.push(temp);
				temp = temp.left;
			}else {
				temp = stack.pop();
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
			
		}
	}
	
	public void iterativePostOrderTraversal(TreeNode root) {
		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<>();
		
		while(current!=null || !stack.empty()) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			}else {
				TreeNode temp = stack.peek().right;
				if(temp == null) {
					temp = stack.pop();
					System.out.print(temp.data + " ");
					while(!stack.empty() && stack.peek().right == temp) {
						temp = stack.pop();
						System.out.print(temp.data + " ");
					}
				}else {
					current = temp;
				}
			}
		}
		
	}
	
	public void levelOrderTraversal(TreeNode root) {
		if(root == null) {
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.data + " ");
			if(temp.left != null)
				queue.offer(temp.left);
			if(temp.right != null)
				queue.offer(temp.right);
		}
	}
	
	public int findMax(TreeNode root) {
		if(root == null)
			return Integer.MIN_VALUE;
		
		int result = root.data;
		int left = findMax(root.left);
		int right = findMax(root.right);
		
		if(left > result)
			result = left;
		
		if(right > result)
			result = right;
		
		return result;
	}
	
	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree();
		
		System.out.print("Recursive Preorder Traversal : ");
		bt.preOrderTraversal(bt.root);
		System.out.println();
		
		System.out.print("Iterative Preorder Traversal : ");
		bt.iterativePreOrderTraversal(bt.root);
		System.out.println();
		
		System.out.print("Recursive Inorder Traversal : ");
		bt.inOrderTraversal(bt.root);
		System.out.println();
		
		System.out.print("Iterative Inorder Traversal : ");
		bt.iterativeInOrderTraversal(bt.root);
		System.out.println();
		
		System.out.print("Recursive Postorder Traversal : ");
		bt.postOrderTraversal(bt.root);
		System.out.println();
		
		System.out.print("Iterative Postorder Traversal : ");
		bt.iterativePostOrderTraversal(bt.root);
		System.out.println();
		
		System.out.print("Levelorder Traversal : ");
		bt.levelOrderTraversal(bt.root);
		System.out.println();
		
		int max = bt.findMax(bt.root);
		System.out.print("Maximum value in binary tree : " + max);

	}

}
