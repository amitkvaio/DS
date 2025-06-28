package com.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindAllTheLeftAndRightAndInternalTreeNodeOfBinaryTree {
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
		System.out.println("Printing left most Tree Node.");
		inOrderPrintLeftNode(binaryTree.root);
		System.out.println("\n\nPrinting Right most Tree Node.");
		inOrderPrintRightNode(binaryTree.root);
		System.out.println("\n\nPrinting left most Tree Node using Level Oerder Traversal");
		levelOrderTraversal(binaryTree.root);
		System.out.println("\n\nPrinting the Internal nodes.");
		printInternalNodesUsingLevelOrderTraversal(binaryTree.root);
	}
	
	public static void inOrderPrintLeftNode(TreeNode root) {
		if(root!=null) {
			inOrderPrintLeftNode(root.left);
			System.out.print(root.data +"-->");
			//inOrder(root.right);
		}
	}
	
	public static void inOrderPrintRightNode(TreeNode root) {
		if(root!=null) {
			//inOrderPrintLeftNode(root.left);
			inOrderPrintRightNode(root.right);
				System.out.print(root.data +"-->");
		}
	}
	
	public static void levelOrderTraversal(TreeNode root) {
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				TreeNode treeNode = queue.poll();
				System.out.print(treeNode.data + "-->");
				if (treeNode.left != null) {
					queue.offer(treeNode.left);
				}
			}
		}
	}
	
	public static void printInternalNodesUsingLevelOrderTraversal(TreeNode root) {
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				TreeNode treeNode = queue.poll();
				if (treeNode.left != null || treeNode.right!=null ) {
					System.out.print(treeNode.data + "-->");
				}
				if(treeNode.left!=null)
					queue.offer(treeNode.left);
				if(treeNode.right!=null)
					queue.offer(treeNode.right);
			}
		}
	}
}
/*

An internal node in a Binary Search Tree (BST) (or any tree) is a node that has at 
	least one child (either left or right or both).
 		50
       /  \
      30   70
     / \   / \
    20 40 60 80

Internal Nodes: 50, 30, 70 (because they have at least one child).

         25
       /    \
     20      36
    /  \    /   \
  10   22  30    40
 /  \      /    /   \
5   12   28   38    48


*/
