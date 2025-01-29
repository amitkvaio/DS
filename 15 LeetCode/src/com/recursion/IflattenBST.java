package com.recursion;

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}


public class IflattenBST {
	public static void main(String[] args) {
		// Example 1
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(8);
        
        TreeNode flattened1 = flattenBST(root1);
        printFlattenedTree(flattened1); // Output: 2 3 4 5 6 7 8
        
        // Example 2
        TreeNode root2 = new TreeNode(5);
        root2.right = new TreeNode(8);
        root2.right.left = new TreeNode(7);
        root2.right.right = new TreeNode(9);

        TreeNode flattened2 = flattenBST(root2);
        printFlattenedTree(flattened2); // Output: 5 7 8 9
	}

	//T.C : O(n)
	//S.C : AUxiliary Space is O(1) and Stack Space due to recursion is O(n)
	public static TreeNode flattenBST(TreeNode root) {
		if (root == null) {
			return null;
		}
		// Getting left head of BST of left side
		TreeNode leftHead = flattenBST(root.left);
		root.left = null;

		// Link this lastnode of the leftHead to the root
		if (leftHead != null) {
			TreeNode temp = leftHead;
			while (temp.right != null) {
				temp = temp.right;
			}
			temp.right = root;
		}else {
			// If left head is null, root becomes the left head
			leftHead = root;
		}
		
		//Getting the right head of BST of right side
		TreeNode rightHead = flattenBST(root.right);
		root.right = rightHead;
		return leftHead;
	}
	
	public static void printFlattenedTree(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
        System.out.println();
    }
}

/*
https://www.geeksforgeeks.org/problems/flatten-bst-to-sorted-list--111950/1


*/