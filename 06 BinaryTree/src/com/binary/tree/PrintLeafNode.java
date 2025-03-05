package com.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

//Print all leaf nodes of a Binary Tree from left to right
public class PrintLeafNode {
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
		
		System.out.println("Printing Left node using level order traversal.");
		printingLeafNode(binaryTree.root);
		
		System.out.println("\n\nLeft to right Leaf node");
		printLeafNodeFromL2R(binaryTree.root);
		
		System.out.println("\n\nRight to Left Leaf node");
		printLeafNodeFromR2L(binaryTree.root);
	}

	private static void printLeafNodeFromL2R(TreeNode root) {
		if(root!=null) {
			if(root.left ==null && root.right==null) {
				System.out.print(root.data +" ");
			}
			printLeafNodeFromL2R(root.left);
			printLeafNodeFromL2R(root.right);
		}
	}
	
	private static void printLeafNodeFromR2L(TreeNode root) {
		if(root!=null) {
			if(root.left ==null && root.right==null) {
				System.out.print(root.data +" ");
			}
			printLeafNodeFromR2L(root.right);
			printLeafNodeFromR2L(root.left);
		}
	}
	
	public static void printingLeafNode(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root==null) {
			System.out.println("No tree nodes are available.");
			return;
		}else {
			queue.add(root);
			while(!queue.isEmpty()) {
				TreeNode treeNode = queue.poll();
				
				if(treeNode.left!=null) {
					queue.add(treeNode.left);
				}
				//Can be keep either above if block or below if block
				if(treeNode.left == null && treeNode.right==null) {
					System.out.print(treeNode.data + ", ");
				}
				
				if(treeNode.right!=null) {
					queue.add(treeNode.right);
				}
			}
		}
	}
}
/*
         25
       /    \
     20      36
    /  \    /   \
  10   22  30    40
 /  \      /    /   \
5   12   28   38    48

*/