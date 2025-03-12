package ecom.binarySearchTree;

import com.binary.tree.BinaryTree;
import com.binary.tree.TreeNode;

public class NBSTtoGreaterSumTree {
	
	
	public void dfs(TreeNode root, int[] sum){
        if(root == null) {
            return;
        }
        dfs(root.right,sum);
        sum[0] = sum[0] + root.data;
        root.data = sum[0];
        dfs(root.left, sum);
    }


    public TreeNode bstToGst(TreeNode root) {
       int [] sum = new int[1];
       dfs(root,sum);
       return root; 
    }
	
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(4);
		binaryTree.insert(1);
		binaryTree.insert(6);
		binaryTree.insert(0);
		binaryTree.insert(2);
		binaryTree.insert(5);
		binaryTree.insert(7);
		binaryTree.insert(3);
		binaryTree.insert(8);
		binaryTree.levelOrderTraversal(binaryTree.root);
		System.out.println("\n\n");
		NBSTtoGreaterSumTree sumTree = new NBSTtoGreaterSumTree();
		TreeNode root = sumTree.bstToGst(binaryTree.root);
		binaryTree.levelOrderTraversal(root);
	}
}
/*
https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
LeetCode : 1038
//Simple recursive approach
//T.C : O(n)
//S.C : O(1)
*/
