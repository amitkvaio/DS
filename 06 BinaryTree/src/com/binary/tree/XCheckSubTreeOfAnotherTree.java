package com.binary.tree;

public class XCheckSubTreeOfAnotherTree {
	public static void main(String[] args) {
		// Example tree creation
		TreeNode root = parentBinaryTree();

		// Subtree that is a part of the main tree
		TreeNode subroot = subBinaryTree();

		// Test if subroot is a subtree of root
		boolean result = isSubtree(root, subroot);
		System.out.println("Is subroot a subtree of root? " + result);
	}
	
	public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null)
			return false;
		if (isSameBinaryTree(root, subRoot))
			return true;

		 // Recursively check left and right subtrees
		return isSameBinaryTree(root.left, subRoot) 
				|| isSameBinaryTree(root.right, subRoot);
	}
	
	// Helper method to compare two trees for symmetry
    public static boolean isSameBinaryTree(TreeNode root1, TreeNode root2) {
        // Base Cases
        if (root1 == null && root2 == null) return true; // Both trees are empty
        if (root1 == null || root2 == null) return false; // One tree is empty
        if (root1.data != root2.data) return false; // Different values
        
        // Recursively check left and right subtrees
        boolean leftAns = isSameBinaryTree(root1.left, root2.left);
        boolean rightAns = isSameBinaryTree(root1.right, root2.right);
        
        return leftAns && rightAns;
    }

	public static TreeNode subBinaryTree() {
		TreeNode subroot = new TreeNode(2);
		TreeNode subnode4 = new TreeNode(4);
		TreeNode subnode5 = new TreeNode(5);
		subroot.left = subnode4;
		subroot.right = subnode5;
		return subroot;
	}

	public static TreeNode parentBinaryTree() {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);

		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		return root;
	}
}

/*
Given the roots of two binary trees, root and subroot,
	Return true if there is a subtree of root with the same structure and node
	values of subroot and false otherwise.

        1
       / \
      2   3
     / \
    4   5

Subroot:
      2
     / \
    4   5
Time Complexity:
    isSameTree(): The time complexity is O(N) where N is the number of nodes in the trees being compared.
    isSubtree(): The worst case is traversing all nodes in root, 
    	so the time complexity is O(M * N), where M is the number of nodes in root and N 
    	is the number of nodes in subroot.

*/
