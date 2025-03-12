package ecom.binarySearchTree;

import com.binary.tree.BinaryTree;
import com.binary.tree.TreeNode;

public class KGetMinAbsDiffBST {
	
	int minDiff = Integer.MAX_VALUE;
	TreeNode pre = null;
	
	
	public int getMinimumDifference(TreeNode root) {
		inOrder(root);
		return minDiff;
    }
	
	private void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		if(pre !=null) {
			minDiff = Math.abs(Math.min(minDiff, root.data - pre.data));
		}	
		pre = root;
		inOrder(root.right);
	}

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(4);
		binaryTree.insert(2);
		binaryTree.insert(6);
		binaryTree.insert(1);
		binaryTree.insert(3);
		binaryTree.levelOrderTraversal(binaryTree.root);
		
		KGetMinAbsDiffBST bst= new KGetMinAbsDiffBST();
		System.out.println("\nMinimum Absolute diff ::" + bst.getMinimumDifference(binaryTree.root));
	}
}

/*
https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
LeetCode : 530

*/