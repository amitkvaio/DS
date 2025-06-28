package com.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class KInvertBinaryTree {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(25);
		binaryTree.insert(20);
		binaryTree.insert(36);
		binaryTree.insert(10);
		binaryTree.insert(22);
		binaryTree.insert(30);
		
		binaryTree.levelOrderTraversal(binaryTree.root);
		System.out.println("\n##########################");
		TreeNode inverted = invertTree(binaryTree.root);
		binaryTree.levelOrderTraversal(inverted);
		
		System.out.println("\n########### Using iterative approach ###############");
		//It will looks like original binary tree
		TreeNode invertedBfs = invertTreeUsingIterative(binaryTree.root);
		binaryTree.levelOrderTraversal(invertedBfs);
	}
	
	//TC : O(n) SC: O(H) Where N is the number of nodes in the tree and H is recursive stack space
	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);

		return root;
	}
	
	//BFS
	//TC : O(n) SC: O(H) Where N is the number of nodes in the tree and H is recursive stack space
	public static TreeNode invertTreeUsingIterative(TreeNode root) {
		if(root==null) {
			return root;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			
			// Swap left and right children
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			
			// Add left and right children to the queue
			if(node.left!=null) queue.offer(node.left);
			if(node.right!=null) queue.offer(node.right);
		}
		return root;
	}
}
/*
Invert Binary Tree:
*******************
Inverting a binary tree means swapping the left and right children of all nodes in the tree. 
	After inversion, the left child becomes the right child and vice versa for every node in the tree.

Recursive Approach:
*******************
    If the node is null, return.
    Swap the left and right children of the current node.
    Recursively call the same function for the left and right children.

Input
        25
       / \
      20  36
     / \   \
   10  22   30

Output
        25
       / \
      36   20
     /    /  \
    30    22  10

*/