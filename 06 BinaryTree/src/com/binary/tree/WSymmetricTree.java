package com.binary.tree;

public class WSymmetricTree {
	public static void main(String[] args) {
		TreeNode root = binaryTreeOne();
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.levelOrderTraversal(root);
		System.out.println("***********************");
		System.out.println(isSymmetric(root));
	}
	
	
	public static TreeNode binaryTreeOne() {
		// Create nodes
		TreeNode root = new TreeNode(1);
		TreeNode left2 = new TreeNode(2);
		TreeNode right2 = new TreeNode(2);
		TreeNode left3 = new TreeNode(3);
		TreeNode left4 = new TreeNode(4);
		TreeNode right4 = new TreeNode(4);
		TreeNode right3 = new TreeNode(3);

		// Set root's left and right children
		root.left = left2;
		root.right = right2;

		// Set left subtree
		left2.left = left3;
		left2.right = left4;

		// Set right subtree
		right2.left = right4;
		right2.right = right3;

		// Return the root of the tree
		return root;
	}

	// Method to check if the tree is symmetric
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return solve(root.left, root.right);
    }

    // Helper method to compare two trees for symmetry
    public static boolean solve(TreeNode root1, TreeNode root2) {
        // Base Cases
        if (root1 == null && root2 == null) return true; // Both trees are empty
        if (root1 == null || root2 == null) return false; // One tree is empty
        if (root1.data != root2.data) return false; // Different values
        
        // Recursively check left and right subtrees
        boolean leftAns = solve(root1.left, root2.right);
        boolean rightAns = solve(root1.right, root2.left);
        
        return leftAns && rightAns; // Both sides must be symmetric
    }
}

/*

Input
        1
       / \
      2    2
     / \  / \
   3   4  4  3
  
level order traversal
**********************
1-->2-->2-->3-->4-->4-->3-->

Given the root of a binary tree, check whether it is mirror of itself.
	Symmetric is arount its center.

Key Differences Between Identical Trees and Symmetric Trees:
***********************************************************
Structure:
***********
    Identical Trees: The trees must have the exact same structure, and the corresponding nodes must have the same values.
    Symmetric Trees: The structure must be a mirror image, i.e., the left and right subtrees at every level must be swapped.

Node Value Matching:
********************
    Identical Trees: Node values at corresponding positions must be equal.
    Symmetric Trees: At each level, the values of corresponding nodes must match, 
    	but the nodes are swapped between the left and right subtrees.

TC : O(n)
SC : O(n)

*/