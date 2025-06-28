package com.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

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
public class VIsSameBinaryTree {
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
		System.out.println("****************************");
		System.out.println(isSameTreeUsingBfs(bt1.root, bt2.root));
	}
	
	public static boolean isSameTree(TreeNode p , TreeNode q ) {
		// Base Cases
        if (p == null && q == null) return true; // Both trees are empty
        if (p == null || q == null) return false; // One tree is empty
        if (p.data != q.data) return false; // Different values
		
        boolean leftAns = isSameTree(p.left, q.left);
        boolean rightAns = isSameTree(p.right, q.right);
        
        // Recursively check left and right subtrees
        return leftAns && rightAns;
	}
	//TC: O(n) and SC: O(n)
	public static boolean isSameTreeUsingBfs(TreeNode node1 , TreeNode node2 ) {
		if(node1==null && node2==null) return false;
		if(node1==null || node2==null) return false;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(node1);
		queue.offer(node2);
		
		while(!queue.isEmpty()) {
			TreeNode n1 = queue.poll();
			TreeNode n2 = queue.poll();
			
			if(n1.data!=n2.data) return false;
			
			if(n1.left!=null && n2.left!=null) {
				queue.offer(n1.left);
				queue.offer(n2.left);
			}
			
			if(n1.right!=null && n2.right!=null) {
				queue.offer(n1.right);
				queue.offer(n2.right);
			}
		}
		return true;
	}
}

/*
Time & Space Complexity:

Time Complexity: O(n) (Each node is visited once)
Space Complexity: O(n)
*/