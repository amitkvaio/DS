package ecom.binarySearchTree;

import com.binary.tree.BinaryTree;
import com.binary.tree.TreeNode;

public class PtrimBST {
	
	public TreeNode trimBST(TreeNode root, int low, int high) {
		if(root==null) {
			return null;
		}
		root.left 	= trimBST(root.left, low, high);
		root.right 	= trimBST(root.right, low, high);
		
		if(root.data < low ) {
			return root.right;
		}
		if(root.data > high) {
			return root.left;
		}
		return root;
	}
	
	 public TreeNode _trimBST(TreeNode root, int low, int high) {
	        if(root==null){
	            return null;
	        }
	        if(root.data < low) {
	            return trimBST(root.right, low, high);
	        }
	            
	        if(root.data > high){
	            return trimBST(root.left, low, high);
	        }

	        // Recur for left and right subtrees
	        root.left = trimBST(root.left, low, high);
	        root.right = trimBST(root.right, low, high);
	        return root;
	    }
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(3);
		binaryTree.insert(0);
		binaryTree.insert(4);
		binaryTree.insert(2);
		binaryTree.insert(1);
		binaryTree.levelOrderTraversal(binaryTree.root);
		
		System.out.println("\n\n");
		PtrimBST bst = new PtrimBST();
		TreeNode node = bst._trimBST(binaryTree.root,1,2);
		binaryTree.levelOrderTraversal(node);
	}
}
