package com.binary.tree.prob;

import java.util.Stack;

import com.binary.tree.TreeNode;

/*
How can you traverse binary tree?

PreOrder
*********
InOrder
PostOrder.
TC: O(n)
SC: O(n)

Pre-order
40 20 10 30 60 50 70
*/
public class BinaryTree00 {
	public static void main(String[] args) {
		TreeNode rootNode = createBinaryTree();
		System.out.println("********** Using Recursion ***********");
		preorder(rootNode);
		System.out.println("\n********* Using Iterator **********");
		preorderIter(rootNode);
		System.out.println("\nFinished");
	}
	
	public static void preorder(TreeNode root) {
	    if(root !=  null) {
	   //Visit the node by Printing the node data  
	      System.out.printf("%d ",root.data);
	      preorder(root.left);
	      preorder(root.right);
	    }
	  }
	
	// Iterative solution
	public static void preorderIter(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.empty()) {

			TreeNode n = stack.pop();
			System.out.printf("%d ", n.data);

			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
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


/*
Binary Tree PreOrder traversal in java 
*************************************	
Steps for PreOrder traversal are:

Visit the node.
Traverse the left subtree in PreOrder.
Traverse the right subtree in PreOrder

There can be two ways of implementing it
Recursive
Recursive solution is very straight forward.
	See the PreOderTravesalBinaryTree1.png diagram
Iterative


Iterative solution:
*******************
For recursion, we use implicit stack. So here to convert recursive solution to iterative, 
	we will use explicit stack.
Steps for iterative solution:

    Create empty stack and push root node to it.
    Do the following when stack is not empty
        Pop a node from stack and print it
        Push right child of popped node to stack
        Push left child of popped node to stack

*/