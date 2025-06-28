package com.binary.tree;

public class ZASumOfRootToLeafBinaryNumbers {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		TreeNode root = getBinaryTree();
		binaryTree.levelOrderTraversal(root);
		System.out.println("\n***************************");
		System.out.println(sumOfLeafBinaryNumbers(root));
	}
	
	public static int sumOfLeafBinaryNumbers(TreeNode root) {
		return dfs(root, 0);
	}

	private static int dfs(TreeNode node, int currentSum) {
		// If the node is null, return 0
		if (node == null) {
			return 0;
		}

		// Update the current sum by shifting left and adding the current node's value
		currentSum = (currentSum << 1) | node.data;

		// If we are at a leaf node (both left and right are null), return the current
		// sum
		if (node.left == null && node.right == null) {
			return currentSum;
		}

		// Recursively sum the left and right subtrees
		return dfs(node.left, currentSum) + dfs(node.right, currentSum);
	}
	
	public static TreeNode getBinaryTree() {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(0);
		TreeNode three = new TreeNode(1);
		TreeNode four = new TreeNode(0);
		TreeNode five = new TreeNode(1);
		TreeNode six = new TreeNode(0);
		TreeNode seven = new TreeNode(1);

		one.left = two;
		one.right = three;

		two.left = four;
		two.right = five;

		three.left = six;
		three.right = seven;
		return one;
	}
}
/*
You are given the root of a binary tree where each node has a value of either 0 or 1. 
	Each path from the root to a leaf node represents a binary number, where the most 
	significant bit (MSB) is at the root, and the least significant bit (LSB) is at the leaf.

Write a function that computes the sum of all the binary numbers formed by the paths from the 
root to each leaf node.

Input:
    A binary tree root where each node contains a value 0 or 1.

Output:
    An integer representing the sum of all the binary numbers formed by the root-to-leaf paths.
    
        1
       / \
      0   1
     / \ / \
    0   1 0   1

Input
root = [1,0,1,0,1,0,1]

Output
22

TC : O(n)
SC : O(H) => H is the height of the tree due to recursion stack.
	In the worst case, the height of the tree could be N, leading to 
	a space complexity of O(N)


Explanation:
The binary numbers formed by the root-to-leaf paths are:

    100 → 4
    101 → 5
    110 → 6
    111 → 7
So, the sum is: 4 + 5 + 6 + 7 = 22.

currentSum = (currentSum << 1) | node.val;
 
       
Start with the root node (value = 1):
    Initially, currentSum = 0 (no binary number yet).
    currentSum = (0 << 1) | 1 → currentSum = 0 | 1 = 1 (now the binary number is 1).

Move to the next node (value = 0):
    currentSum = (1 << 1) | 0 → currentSum = 10 | 0 = 10 (now the binary number is 10 in binary, which is 2 in decimal).

Move to the next node (value = 1):
    currentSum = (2 << 1) | 1 → currentSum = 100 | 1 = 101 (now the binary number is 101, which is 5 in decimal).
       	  
*/