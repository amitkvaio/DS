package ecom.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

import com.binary.tree.BinaryTree;
import com.binary.tree.TreeNode;

public class OBalancedBST {
	
	public void inOrder(TreeNode root, List<Integer> list){
		if(root==null) {
			return;
		}
		inOrder(root.left, list);
		list.add(root.data);
		inOrder(root.right, list);
	}
	
	private TreeNode construct(List<Integer> list, int startIdx , int endIdx) {
		if(startIdx > endIdx) {
			return null;
		}
		int mid = startIdx + (endIdx - startIdx)/2;
		TreeNode rootNode = new TreeNode(list.get(mid));
		
		rootNode.left = construct(list, startIdx,mid -1);
		rootNode.right = construct(list, mid+1, endIdx);
		return rootNode;
	}
	
	public TreeNode balanceBST(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);
		return construct(list,0, list.size() - 1);
	}
	
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(1);
		binaryTree.insert(2);
		binaryTree.insert(3);
		binaryTree.insert(4);
		binaryTree.levelOrderTraversal(binaryTree.root);
		
		System.out.println("\n\n");
		OBalancedBST bst = new OBalancedBST();
		TreeNode node = bst.balanceBST(binaryTree.root);
		binaryTree.levelOrderTraversal(node);
	}
}
/*
https://leetcode.com/problems/balance-a-binary-search-tree/
LeetCode : 1382
//Simple approach using inordere tree traversal
//T.C : O(n)
//S.C : O(n)
*/
