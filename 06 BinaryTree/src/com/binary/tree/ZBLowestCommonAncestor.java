package com.binary.tree;

public class ZBLowestCommonAncestor {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		TreeNode one = new TreeNode(1);
		TreeNode six = new TreeNode(6);
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(7);

		TreeNode root = three;
		
		three.left = five;
		three.right = one;
		
		five.left = six;
		five.right = two;
		
		two.left = seven;
		
		TreeNode p = six; 
		TreeNode q = seven;	
		
		binaryTree.levelOrderTraversal(root);
		System.out.println("\n***************************");
		
		System.out.println(lowestCommonAncestor(root, p, q).data);
	}
	
	// This function returns the LCA of nodes p and q in the binary tree
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		// Base case: If the root is null or we find either p or q, return the root
		if (root == null || root == p || root == q) {
			return root;
		}

		// Recursively search for LCA in the left and right subtrees
		TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
		TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

		// If both leftLCA and rightLCA are non-null, root is the LCA
		if (leftLCA != null && rightLCA != null) {
			return root;
		}

		// Otherwise, return the non-null subtree (either leftLCA or rightLCA)
		return leftLCA != null ? leftLCA : rightLCA;
	}
	
	public static TreeNode getBinaryTree() {
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		TreeNode one = new TreeNode(1);
		TreeNode six = new TreeNode(6);
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(7);

		three.left = five;
		three.right = one;
		
		five.left = six;
		five.right = two;
		
		two.left = seven;
		return three;
	}
}


/*
Given a binary tree, find the lowest common ancestor(LCA) of two given nodes in the tree.

        3
       / \
      5   1
     / \  
    6   2
       /
      7

Node 5 and 7, LCA is 5
*/