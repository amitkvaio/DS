package com.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
Find maximum element in binary tree in java
Steps for getting maximum element in binary tree:

Recursive solution:
Find maximum element in left subtree
Find maximum element in right subtree
Compare maximum of above subtrees to current node
We will find maximum element with above steps

Iterative solution:
Iterative solution will be similar to level order traversal. 
When we are popping element from queue, we will check max.

*/
public class TBinaryTreeGetMaxElement {
	
	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode rootNode = createBinaryTree();
		System.out.println("Max node using recursion :" + getMaximumRec(rootNode));
		System.out.println("Max node using iteration :" + getMaximumItr(rootNode));
	}
	
	public static int getMaximumRec(TreeNode root) {
		int max = Integer.MIN_VALUE;
		int value = 0;
		int left, right;
		if (root != null) {
			value = root.data;
			left = getMaximumRec(root.left);
			right = getMaximumRec(root.right);

			if (left > right) {
				max = left;
			} else {
				max = right;
			}

			if (max < value) {
				max = value;
			}
		}
		return max;
	}

	// Iterative Solution
	/* To get max node in a binary tree */
	public static int getMaximumItr(TreeNode startNode) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(startNode);
		int max = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.poll();
			if (max < tempNode.data)
				max = tempNode.data;
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
		return max;
	}

	public static TreeNode createBinaryTree() {

		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);

		rootNode.left = node20;
		rootNode.right = node60;

		node20.left = node10;
		node20.right = node30;

		node60.left = node50;
		node60.right = node70;

		return rootNode;
	}
}
