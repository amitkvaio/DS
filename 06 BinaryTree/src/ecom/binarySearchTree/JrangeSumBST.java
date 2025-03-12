package ecom.binarySearchTree;

import com.binary.tree.BinaryTree;
import com.binary.tree.TreeNode;

public class JrangeSumBST {
	
	public static int rangeSumBST(TreeNode root , int low, int high) {
		if(root==null)
			return 0;
		
		if(root.data >= low && root.data <=high) {
			return root.data + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
		}
		
		if(root.data < low) {
			return rangeSumBST(root.right, low, high);
		} 
			
		return rangeSumBST(root.left, low, high);
	}
	
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(10);
		binaryTree.insert(5);
		binaryTree.insert(15);
		binaryTree.insert(3);
		binaryTree.insert(7);
		binaryTree.insert(18);
		binaryTree.levelOrderTraversal(binaryTree.root);
		System.out.println("Range Sum::" + rangeSumBST(binaryTree.root, 7, 15));
	}
}
/*
https://leetcode.com/problems/range-sum-of-bst/description/
Leetcode : 938
*/