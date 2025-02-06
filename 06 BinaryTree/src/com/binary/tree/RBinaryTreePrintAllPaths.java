package com.binary.tree;
/*
print all paths from root to leaf in a binary tree in java
Steps for print all paths from root to leaf are:

If node is null then return 0
put node.data in array and increment len by 1.
If encounterd leaf node(i.e. node.left is null and node.right is null) then print array.
Recursively visit left subtree and right subtree

*/

public class RBinaryTreePrintAllPaths {
	
	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode rootNode = createBinaryTree();
		System.out.println("Printing all paths from root to leaf :");
		printAllPathsToLeaf(rootNode, new int[1000], 0);
	}

	public static void printAllPathsToLeaf(TreeNode node, int[] path, int len) {
		if (node == null)
			return;
		// storing data in array
		path[len] = node.data;
		len++;

		if (node.left == null && node.right == null) {
			// leaf node is reached
			printArray(path, len);
			return;
		}
		printAllPathsToLeaf(node.left, path, len);
		printAllPathsToLeaf(node.right, path, len);
	}

	
	public static void printArray(int[] path, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(" " + path[i]);
		}
		System.out.println();
	}

	public static TreeNode createBinaryTree() {

		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(25);
		binaryTree.insert(20);
		binaryTree.insert(36);
		binaryTree.insert(10);
		binaryTree.insert(22);
		binaryTree.insert(30);
		binaryTree.insert(40);
		binaryTree.insert(5);
		binaryTree.insert(12);
		binaryTree.insert(28);
		binaryTree.insert(38);
		binaryTree.insert(48);
		System.out.println();

		return binaryTree.root;
	}
}
