package com.binary.tree;

public class NPathSum {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		TreeNode root1 = binaryTreeOne();
		binaryTree.levelOrderTraversal(root1);
		System.out.println("\n****************");
		int targetSum = 52;
		boolean hasPathSum = hasPathSum(root1,targetSum);
		System.out.println(hasPathSum);
		System.out.println("*******************");
		System.out.println(hasPathSum(binaryTreeOne(), 0, targetSum));
	}
	
	public static TreeNode binaryTreeOne() {
		// Create nodes
		TreeNode node20 = new TreeNode(20);
		TreeNode node15 = new TreeNode(15);
		TreeNode node12 = new TreeNode(12);
		TreeNode node16 = new TreeNode(16);
		TreeNode node13 = new TreeNode(13);
		TreeNode node4 = new TreeNode(4);

		// Set root
		TreeNode root = node20;

		// Link nodes to form the tree
		root.left = node15;
		root.right = node12;
		node15.left = node16;
		node15.right = node13;
		node13.left = node4;
		
		return root;
	}
	
	public static boolean hasPathSum(TreeNode root, int targetSum) {
		// If the root is null, there is no path, so return false
		if (root == null) {
			return false;
		}

		// Subtract the current node's value from targetSum
		targetSum -= root.data;

		// If it's a leaf node, check if the remaining targetSum is 0
		if (root.left == null && root.right == null) {
			return targetSum == 0;
		}

		// Recursively check the left and right subtrees
		return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
	}
	
	public static boolean hasPathSum(TreeNode root, int current, int targetSum) {
		// If the root is null, there is no path, so return false
		if (root == null) {
			return false;
		}

		// Add the current node's value to the running sum
		current += root.data;

		// If it's a leaf node, check if the remaining targetSum is 0
		if (root.left == null && root.right == null) {
			return current == targetSum; // Check if we reached the target sum at leaf
		}

		// Recursively check the left and right subtrees
		boolean left = hasPathSum(root.left, current, targetSum);
		boolean right = hasPathSum(root.right, current, targetSum);

		// Return true if any of the left or right paths is valid
		return left || right;
	}

}
/*
Given the root of a binary tree and an integer targetsum, return true if the tree has
a root to leaf path such that adding up all the values along the path equals target sum.

Merged Tree:
        20
       / \
      15   12
     / \    
    16  13
        /
	   4 	
	   
TC : O(n)
SC : O(n)

*/