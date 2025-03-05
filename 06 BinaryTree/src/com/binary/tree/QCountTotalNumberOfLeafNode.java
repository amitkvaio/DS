package com.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

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
		
		System.out.println("Printing Leaf nodes");
		printLeafNode(binaryTree.root);
		
		System.out.println("\n\nTotal Number of leaf Nodes are ::"+countprintLeafNode(binaryTree.root));
		System.out.println("Total number of leaf nodes are using LOT is ::" + totalNumberOfLeafNodeUsingLevelOrderTraversal(binaryTree.root));
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
	
	private static int totalNumberOfLeafNodeUsingLevelOrderTraversal(TreeNode root) {
		int count =0;
		if(root==null) {
			return 0;
		}else {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while(!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if(node.left ==null && node.right ==null) {
					count++;
				}
				
				if(node.left!=null) {
					queue.offer(node.left);
				}
				
				if(node.right!=null) {
					queue.offer(node.right);
				}
			}
		}
		return count;
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