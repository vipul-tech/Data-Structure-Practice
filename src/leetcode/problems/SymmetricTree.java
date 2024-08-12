package leetcode.problems;

import java.util.Stack;

public class SymmetricTree {
	
	boolean isSymmetric(TreeNode root) {
		if(root==null)
			return true;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root.right);
		stack.push(root.left);
		
		while(!stack.isEmpty()) {
			TreeNode n1 = stack.pop();
			TreeNode n2 = stack.pop();
			
			if(n1==null && n2==null)
				continue;
			
			if(n1==null || n2==null || n1.data != n2.data)
				return false;
			
			stack.push(n1.left);
			stack.push(n2.right);
			stack.push(n1.right);
			stack.push(n2.left);
		}
		
		return true;
	}
	
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
	
	public TreeNode createBinaryTree(TreeNode root) {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(2);
		TreeNode fourth = new TreeNode(3);
		TreeNode fifth = new TreeNode(4);
		TreeNode sixth = new TreeNode(4);
		TreeNode seventh = new TreeNode(3);
		
		root = first;
		first.left = second;
		first.right = third;
		second.left = fourth;
		second.right = fifth;
		third.left = sixth;
		third.right = seventh;
		
		return root;
	}
	
	public void inOrderTraversal(TreeNode root) {
		if(root == null)
			return;
		
		inOrderTraversal(root.left);
		System.out.print(root.data + " ");
		inOrderTraversal(root.right);
	}

	public static void main(String[] args) {
		SymmetricTree symmetricTree = new SymmetricTree();
		TreeNode root = null;
		TreeNode tree = symmetricTree.createBinaryTree(root);
		symmetricTree.inOrderTraversal(tree);
		boolean isSymmetric = symmetricTree.isSymmetric(tree);
		System.out.println();
		System.out.println(isSymmetric);
	}

}
