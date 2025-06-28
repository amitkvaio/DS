package com.binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DBinaryTreeInOrderTraversal {
	public static void main(String[] args) {
		List<Integer> list = inOrderTraversal(BinaryTree.getBinaryTree().root);
		System.out.println(list);
		System.out.println("########## Using Stack ##############");
		List<Integer> lst = inOrderTraversalUsingStack(BinaryTree.getBinaryTree().root);
		System.out.println(lst);
	}
	
	public static List<Integer> inOrderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inOrder(list, root);
		return list;
	}

	public static void inOrder(List<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		inOrder(list, root.left);
		list.add(root.data);
		inOrder(list, root.right);
	}
	/*
	TC : O(n)
	SC : O(1)+ O(H) where N nodes and H height and O(H) recursive stack space
	*/
	
	
	// We can also sove this problem using stack
	public static List<Integer> inOrderTraversalUsingStack(TreeNode root) {

		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;

		while (current != null || !stack.isEmpty()) {
			// Reach the left most node of the curren treeNode
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			// Pop the treeNode from the stack and process it.
			current = stack.pop();
			list.add(current.data);
			// Process the righ subtree
			current = current.right;
		}
		return list;
	}
}

/*

InOrder
	--Firstr visit the left subtree
	--Then, visit the root node
	--At last, visit the right subtree
	    25
	  /    \
     20      36
   /  \    /   \
  10   22  30    40
 /  \      /    /   \
5   12   28   38    48

********** In Order Traversal ***************
5-->10-->12-->20-->22-->25-->28-->30-->36-->38-->40-->48-->
*/
