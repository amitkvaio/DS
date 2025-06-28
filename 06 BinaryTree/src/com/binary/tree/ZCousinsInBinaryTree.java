package com.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ZCousinsInBinaryTree {
	public static void main(String[] args) {
		TreeNode root = getBinaryTree();
		System.out.println(isCousins(root, 4, 5));  // Output: true
		System.out.println(isCousins(root, 2, 3));  // Output: false
		System.out.println(isCousins(root, 2, 5));  // Output: false
		System.out.println(isCousins(root, 4, 5));
		System.out.println(isCousins(root, 4, 6));
		System.out.println(isCousins(root, 7, 6));
	}

	public static boolean isCousins(TreeNode root, int x, int y) {
		if (root == null)
			return false;

		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));

		TreeNode xParent = null, yParent = null;
		int xLevel = -1, yLevel = -1;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Pair current = queue.poll();
				TreeNode node = current.treeNode;
				int level = current.level;

				// Check left and right children for x and y, and store their parent and level
				if (node.left != null) {
					if (node.left.data == x) {
						xParent = node;
						xLevel = level + 1;
					} else if (node.left.data == y) {
						yParent = node;
						yLevel = level + 1;
					}
					queue.add(new Pair(node.left, level + 1));
				}

				if (node.right != null) {
					if (node.right.data == y) {
						yParent = node;
						yLevel = level + 1;
					} else if (node.right.data == x) {
						xParent = node;
						xLevel = level + 1;
					}
					queue.add(new Pair(node.right, level + 1));
				}
			}
		}

		// Check if x and y are at the same level but have different parents
	    // Only check after one level is processed
		return xLevel == yLevel && xParent != yParent;
	}
	

	public static TreeNode getBinaryTree() {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);

		root.left = two;
		root.right = three;

		two.left = four;
		three.right = five;
		
		five.left = six;
		four.right = seven;

		return root;
	}
}

/*
Cousins in Binary Tree
***********************
Given the root of a binary tree with unique values and the values
of two different nodes of the tree x and y, return true if the nodes
corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes are cousins if they have the same depth with different parents.


        1
       / \
      2   3
     /     \
    4		5
     \ 	   /
      7	  6


Node 1 is the root.
Node 2 is the left child of 1.
Node 3 is the right child of 1.
Node 4 is the left child of 2.
Node 5 is the right child of 3.

System.out.println(isCousins(root, 4, 5));  // Output: true

TC : O(n) Visit each node once
SC : O(n)
*/
