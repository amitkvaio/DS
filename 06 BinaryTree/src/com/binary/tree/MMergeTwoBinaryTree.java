package com.binary.tree;

public class MMergeTwoBinaryTree {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		
		TreeNode root1 = binaryTreeOne();
		TreeNode root2 = binaryTreeTwo();
		binaryTree.levelOrderTraversal(root1);
		System.out.println("\n****************");
		binaryTree.levelOrderTraversal(root2);
		System.out.println("\n########################");
		
		TreeNode root = mergeTwoBinaryTree(root1, root2);
		
		 
		binaryTree.levelOrderTraversal(root);
	}
	
	
	public static TreeNode mergeTwoBinaryTree(TreeNode root1, TreeNode root2) {
		
		if(root1==null && root2==null) return null;
		if(root1==null && root2!=null) return root2;
		if(root2==null && root1!=null) return root1;
		
		root1.data += root2.data;
		
		// Recursively merge the left and right children
		root1.left = mergeTwoBinaryTree(root1.left, root2.left);
		root1.right = mergeTwoBinaryTree(root1.right, root2.right);
		
		return root1;
	}
	
	
	
	public static TreeNode binaryTreeOne() {
		// Create nodes
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node5 = new TreeNode(5);

		// Set root
		TreeNode root = node1;
		
		// Link nodes to form the tree
		node1.left = node3;
		node1.right = node2;
		node3.left = node5;
		return root;
	}
	
	public static TreeNode binaryTreeTwo() {
		// Create nodes
		TreeNode node2 = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node7 = new TreeNode(7);
		TreeNode node6 = new TreeNode(6);
		TreeNode node8 = new TreeNode(8);
		 
		// Set root
		TreeNode root = node2;

		// Link nodes to form the tree
		node2.left = node1;
		node2.right = node7;
		node1.right = node6;
		node7.right = node8;
		return root;
	}
}

/*
Merging two binary trees is a common problem where we combine two trees into one. 
	In the merged tree, each node is the sum of the corresponding nodes from the two input trees. 
	If one tree has a node and the other doesn't, we take the node from the tree that has it.

Approach:
*********
    Traverse both trees.
    At each node, if both trees have nodes, sum their values.
    If one tree has a node and the other doesn't, use the existing node value from the tree that has it.
    Continue this process recursively.

TreeNode one
        1
       / \
      3   2
     /
    5

TreeNode two
        2
       / \
      1   7
       \    \
        6    8
Merged Tree:
        3
       / \
      4   9
     / \    \
    5   6    8

TC: O(M+N)	
SC: O(Max(M,n))
M=>root1 nodes|N=>root2 nodes
*/