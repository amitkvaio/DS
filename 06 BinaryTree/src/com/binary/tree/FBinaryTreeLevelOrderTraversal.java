package com.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FBinaryTreeLevelOrderTraversal {
	
	public static void main(String[] args) {
		BinaryTree binaryTree = BinaryTree.getBinaryTree();
		System.out.println("********* Level Order Traversal ****************");
		FBinaryTreeLevelOrderTraversal.levelOrderTraversal(binaryTree.root);
	}
	
	public static void levelOrderTraversal(TreeNode root) {
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
}

/*
Level Order Traversal is BFS
*******************************
1. First Create the empty queue and push the root in queue.
2. Run  while loop until queue is not empty
3. 	Initialze TreeNode  = queue.poll() and store/print the data.
4.	Push left TreeNode if it is not null
5.	Push right TreeNode if it is not null
6.	Do this until queue is become empyt.

TC : O(n)
SC : 0(n)

				25
			  /    \
             20      36
            /  \    /   \
          10   22  30    40
         /  \      /    /   \
        5   12   28   38    48

********* Level Order Traversal ****************
25-->20-->36-->10-->22-->30-->40-->5-->12-->28-->38-->48-->

*/