package com.binary.tree;

public class LMaximumDepthOfBinaryTree {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		TreeNode root = insert();
		//bt.inOrder(root);
		System.out.println("\n###############");
		System.out.println(maxDepth(root));
	}
	
	
	public static int maxDepth(TreeNode root) {
		return findDepth(root);
	}

	private static int findDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = 1 + findDepth(root.left);
		int right = 1 + findDepth(root.right);
		return Math.max(left, right);
	}


	public static TreeNode insert() {
		// Create nodes
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

		// Set root
		TreeNode root = node1;

		// Link nodes to form the tree
		node1.left = node2;
		node1.right = node3;

		node2.left = node4;
		node2.right = node5;

		node5.left = node6;
		node5.right = node7;
		return root;
	}
}
/*

        1
       / \
      2   3
     / \
    4   5
       / \
      6   7
The longest path is from 1 -> 2 -> 5 -> 6 or 1 -> 2 -> 5 -> 7
Maximum depth of this tree is 4

A binary tree's maximum depth is the longest path from the root (the top node) to the 
	farthest leaf node (the end node without children). 
	It counts how many nodes are on this path, including the root and the leaf.
*/