package com.binary.tree;

import java.util.LinkedList;
import java.util.Queue;
//Print all nodes between two given levels in Binary Tree
//https://www.geeksforgeeks.org/print-all-nodes-between-two-given-levels-in-binary-tree/
public class GetNodeBetweenTwoLevel {
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
		printNodesBetweenGivenLevels(binaryTree.root,2,3);
	}

	
	//Based on level order traversal
	private static void printNodesBetweenGivenLevels(TreeNode root, int startLevel, int endLevel) {
		if (root == null) {
			return;
		}

		// create an empty queue and enqueue root node
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		// pointer to store current node used for traversal of tree
		TreeNode temp = null;

		// maintains level of current node
		int level = 0;

		// run till queue is not empty
		while (!queue.isEmpty()) {
			// increment level by 1
			level++;

			// calculate number of nodes in current level
			int size = queue.size();

			// process every node of current level and add their non-empty left and right child to queue
			while (size != 0) {
				temp = queue.poll();

				// print the node if its level is between given levels
				if (level >= startLevel && level <= endLevel) {
					System.out.print(temp.data + " ");
				}
				if (temp.left != null) {
					queue.add(temp.left);
				}

				if (temp.right != null) {
					queue.add(temp.right);
				}
				size--;
			}
			System.out.println("");
		}
	}
}
