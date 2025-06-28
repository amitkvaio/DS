package com.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZFLeftViewOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = getBinaryTree();
		
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.levelOrderTraversal(root);
		System.out.println("*************************");
		
		ArrayList<Integer> result = leftViewOfBinaryTree(root);
		System.out.println(result);
	}
	
	public static ArrayList<Integer> leftViewOfBinaryTree(TreeNode root) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll(); //Why we can also put the outside of this for loop try to understand this.
				// Adding the first node in the result array list only
				if (i == 0) {
					result.add(node.data);
				}

				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
		return result;
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

1. Left View of Binary Tree
***************************

Definition:
***********
The Left View of a binary tree is the set of nodes visible 
	when the tree is viewed from the left side.

Rule:
*****
From each level, take the first node we encounter from left to right.


        1
       / \
      2   3
     /     \
    4		5
     \ 	   /
      7	  6
      
      
*/