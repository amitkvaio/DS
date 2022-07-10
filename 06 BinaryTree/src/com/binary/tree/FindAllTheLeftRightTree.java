package com.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindAllTheLeftRightTree {
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
		System.out.println("In Order Traversal");
		inOrderPrintLeftNode(binaryTree.root);
		//inOrderPrintRightNode(binaryTree.root);
		System.out.println();
		levelOrderTraversal(binaryTree.root);
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
}
