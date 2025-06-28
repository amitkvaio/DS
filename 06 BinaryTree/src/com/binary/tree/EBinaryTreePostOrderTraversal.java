package com.binary.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class EBinaryTreePostOrderTraversal {
	public static void main(String[] args) {
		List<Integer> list = postOrderTraversal(BinaryTree.getBinaryTree().root);
		System.out.println(list);
		System.out.println("########## Using Stack ##############");
		List<Integer> lst = postOrderTraversalUsingStack(BinaryTree.getBinaryTree().root);
		System.out.println(lst);
	}
	
	public static List<Integer> postOrderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		postOrder(list, root);
		return list;
	}

	public static void postOrder(List<Integer> list, TreeNode root) {
		if (root == null) {
			return;
		}
		postOrder(list, root.left);
		postOrder(list, root.right);
		list.add(root.data);
	}
	/*
	TC : O(n)
	SC : O(1)+ O(H) where N nodes and H height and O(H) recursive stack space
	*/
	
	
	// We can also sove this problem using stack
	public static List<Integer> postOrderTraversalUsingStack(TreeNode root) {

		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		if(root==null) return list;
		stack.push(root);

		while (!stack.isEmpty()) {
			
			TreeNode current = stack.pop();
			list.add(current.data);
			
			if(current.left!=null) stack.push(current.left);
			if(current.right!=null) stack.push(current.right);
		}
		Collections.reverse(list);
		return list;
	}
}



/*
PostOrder
	--Firstr visit the left subtree
	--Then, visit the right subtree
	--At last, visit the root node
				25
			  /    \
             20      36
            /  \    /   \
          10   22  30    40
         /  \      /    /   \
        5   12   28   38    48

******** Post Order Traversal *****************
5-->12-->10-->22-->20-->28-->30-->38-->48-->40-->36-->25-->

*/
