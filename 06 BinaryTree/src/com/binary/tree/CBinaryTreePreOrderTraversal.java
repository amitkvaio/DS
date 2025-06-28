package com.binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CBinaryTreePreOrderTraversal {
	public static void main(String[] args) {
		List<Integer> list = preOrderTraversal(BinaryTree.getBinaryTree().root);
		System.out.println(list);
		System.out.println("########## Using Stack ##############");
		List<Integer> lst = inOrderTraversalUsingStack(BinaryTree.getBinaryTree().root);
		System.out.println(lst);
	}
	
	public static List<Integer> preOrderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		preOrder(list, root);
		return list;
	}

	public static void preOrder(List<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		list.add(root.data);
		preOrder(list, root.left);
		preOrder(list, root.right);
	}
	/*
	TC : O(n)
	SC : O(1)+ O(H) where N nodes and H height and O(H) recursive stack space
	*/
	
	
	// We can also sove this problem using stack
	public static List<Integer> inOrderTraversalUsingStack(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root==null) return list;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while(!stack.isEmpty()) {
			root = stack.pop();
			list.add(root.data);
			
			// This is because stack is LIFO, meaning after inserting right Node in stack, it will be at the bottom.
			if(root.right!=null) stack.push(root.right); 
			
			//After inserting left node in the stack,it will be on top, so once we pop it this left subtree will gets processed.
			if(root.left!=null) stack.push(root.left); 
		}
		return list;
	}
}


/*

Note : In-order traversal is inherently depth-first, which is best suited to use a stack or recursion, not a queue.


PreOrder
	--Firstr visit the root treenode
	--Then, visit the left subtree
	--At last, visit the right subtree

			  25
			/    \
		   20      36
          /  \    /   \
        10   22  30    40
       /  \      /    /   \
      5   12   28   38    48

********** Pre Order Traversal ***************
25-->20-->10-->5-->12-->22-->36-->30-->28-->40-->38-->48-->
*/