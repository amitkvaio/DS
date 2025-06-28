package com.binary.tree;

public class OSumOfLeftLeaves {
	public static void main(String[] args) {
		BinaryTree binaryTree  = new BinaryTree();
		TreeNode root = getBinaryTree();
		binaryTree.levelOrderTraversal(root);
		System.out.println("*********************");
		System.out.println(sumOfLeftLeaves(root));
	}
	
	public static int sumOfLeftLeaves(TreeNode root) {
		return leftTreeNodeSum(root,false);
	}
	
	
	private static int leftTreeNodeSum(TreeNode root, boolean isLeft) {
		if (root == null)
			return 0;

		 // If it's a leaf node
		if (root.left == null && root.right == null) {
			 // If it's a left leaf, return its value
			if (isLeft)
				return root.data;
			else
				return 0;
		}

		int left = leftTreeNodeSum(root.left, true);
		int right = leftTreeNodeSum(root.right, false);

		// Return the sum of left leaves found in both subtrees
		return left + right;
	}

	public static TreeNode getBinaryTree() {
		TreeNode root = new TreeNode(3);
		TreeNode n9 = new TreeNode(9);
		TreeNode n20 = new TreeNode(20);
		TreeNode n15 = new TreeNode(15);
		TreeNode n7 = new TreeNode(7);

		root.left = n9;
		root.right = n20;
		n20.left = n15;
		n20.right = n7;
		return root;
	}
}
/*
Given the root of a binary tee, return the sum of al the left leaves.
A leaf is a node with no children.

TC : O(n)
SC : O(n)

        3
       / \
      9   20
         /  \
        15   7
*/