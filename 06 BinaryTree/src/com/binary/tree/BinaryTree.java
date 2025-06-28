package com.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

//BST (Binary Search Tree)
public class BinaryTree {
	public TreeNode root;

	public BinaryTree() {
		root = null;
	}

	// Insert a new node with the given value
	public void insert(int id) {
		TreeNode newNode = new TreeNode(id); // Create a new node with the given value

		// If the tree is empty, set the root to the new node
		if (root == null) {
			root = newNode;
			return;
		}

		// Start from the root and traverse iteratively
		TreeNode current = root;
		TreeNode parent = null;

		while (current != null) {
			parent = current;
			if (id < current.data) {
				current = current.left; // Move to the left subtree if id is smaller
			} else {
				current = current.right; // Move to the right subtree if id is greater or equal
			}
		}

		// Insert the new node at the correct position
		if (id < parent.data) {
			parent.left = newNode; // Insert to the left of parent
		} else {
			parent.right = newNode; // Insert to the right of parent
		}
	}

	// Find a node with the given key
	public TreeNode find(int key) {
		TreeNode current = root;

		// Iteratively search for the node with the given key
		while (current != null) {
			if (key == current.data) {
				return current;
			} else if (key < current.data) {
				current = current.left; // Go left if the key is smaller
			} else {
				current = current.right; // Go right if the key is larger
			}
		}
		return null; // Return null if the node is not found
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

	//Level order traversal is BFS
	public void levelOrderTraversal(TreeNode root) {
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				TreeNode treeNode = queue.poll();
				System.out.print(treeNode.data + "-->");

				// Add the left child to the queue if it exists
				if (treeNode.left != null) {
					queue.offer(treeNode.left);
					// System.out.println(treeNode.data +"-->");
				}

				// Add the right child to the queue if it exists
				if (treeNode.right != null) {
					// System.out.println(treeNode.data +"-->");
					queue.offer(treeNode.right);
				}
			}
		}
	}
	
	public static BinaryTree getBinaryTree() {
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
		return binaryTree;
	}

	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + "-->");
			inOrder(root.right);
		}
	}

	public void preeOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + "-->");
			preeOrder(root.left);
			preeOrder(root.right);
		}
	}

	public void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + "-->");
		}
	}
}
/*
Breadth-First Search (BFS)
**************************
BFS is an algorithm for traversing or searching a tree or graph. 
	It explores all the nodes at the present depth level before moving 
	on to nodes at the next depth 	level. 
	
	In other words, it starts from the root node (or any given node) and explores all 
	its neighbors (or children), then moves to the next level of neighbors, and so on.

Depth-First Search (dfs) in binary tree in java
*************************************************
DFS is a type of traversal that goes deep as much as possible in every 
	child before exploring the next sibling.

3 types of depth first search

Pre Order traversal of Binary tree
	1.	Visit the node.
	2.	Traverse the left subtree.
	3.	Traverse the right subtree

In Order traversal of Binary tree
	1.	Traverse the left subtree.
	2.	Visit the node.
	3.	Traverse the right subtree


Post Order traversal of Binary tree
	1.	traverse left subtree
	2.	traverse the right subtree.
	3.	Visit the node.
	
What is a Binary Search Tree (BST)?
************************************
A Binary Search Tree (BST) is a binary tree in which each node has:
•	Left subtree nodes with values less than the node.
•	Right subtree nodes with values greater than the node.
•	No duplicate values

*/