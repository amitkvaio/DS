package com.binary.tree;
/*
Given the roots of two binary trees p and q, write a function to check if they are 
	the same or not.

Two binary trees are considered the same if they are structurally identical, 
	and the nodes have the same value.
Input: p = [1,2,3], q = [1,2,3]
Output: true

Input: p = [1,2], q = [1,null,2]
Output: false
*/
public class VSameTree {
	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree();
		bt1.insert(50);
		bt1.insert(17);
		bt1.insert(12);
		bt1.insert(23);
		bt1.insert(9);
		bt1.insert(14);
		bt1.inOrder(bt1.root);
		System.out.println();
		
		BinaryTree bt2 = new BinaryTree();
		bt2.insert(50);
		bt2.insert(17);
		bt2.insert(12);
		bt2.insert(23);
		bt2.insert(9);
		bt2.insert(14);
		
		bt1.inOrder(bt2.root);
		System.out.println("\n" + isSameTree(bt1.root, bt2.root));
	}
	
	public static boolean isSameTree(TreeNode root1 , TreeNode root2 ) {
		if(root1==null || root1==null)
			return true;
		else if(root1==null && root2!=null)
			return false;
		else if(root1!=null && root2==null)
			return false;
		
		if(root1.data==root2.data && isSameTree(root1.left, root2.left) &&
				isSameTree(root1.right, root2.right)) {
			return true;
		}
		return false;
	}
}
