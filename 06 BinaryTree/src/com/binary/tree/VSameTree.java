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
	
	public static boolean isSameTree(TreeNode p , TreeNode q ) {
		// Base Cases
        if (p == null && q == null) return true; // Both trees are empty
        if (p == null || q == null) return false; // One tree is empty
        if (p.data != q.data) return false; // Different values
		
        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}

/*
Time & Space Complexity:

Time Complexity: O(N) (Each node is visited once)
Space Complexity: O(H) (Recursive stack, H = tree height, O(log N) for balanced, O(N) for skewed trees)
*/