package com.binary.tree;
/*
How to count leaf nodes of binary tree.
*/
public class QCountTotalNumberOfLeafNode {
	public static void main(String[] args) {
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
		
		System.out.println("Leaf nodes are::");
		printLeafNode(binaryTree.root);
		System.out.println("\n******************************");
		int count = countprintLeafNode(binaryTree.root);
		System.out.println("Total Number of leaf Nodes are ::"+count);
	}
	
	public static int countprintLeafNode(TreeNode node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		else
			return countprintLeafNode(node.left) + countprintLeafNode(node.right);
	}
	
	private static void printLeafNode(TreeNode root) {
		if(root!=null) {
			if(root.left ==null && root.right==null) {
				System.out.print(root.data +" ");
			}
			printLeafNode(root.left);
			printLeafNode(root.right);
		}
	}

}
