//Find n-th node of inorder traversal
package com.binary.tree;

public class InOrderSearch {
	static int count = 0;
	public static void main(String[] args) {
		BinaryTree binaryTree = BinaryTree.getBinaryTree();
		System.out.println("In Order Traversal");
		binaryTree.inOrder(binaryTree.root);
		System.out.println();
		inOrderTraversal(binaryTree.root,4);
	}
	
	public static void inOrderTraversal(TreeNode root, int nNode) {
		if (root == null) {
			return;
		} else {
			if (count <= nNode) {
				inOrderTraversal(root.left, nNode);
				count++;
				if (count == nNode)
					System.out.println(nNode + " Node value is :" + root.data);
				inOrderTraversal(root.right, nNode);
			}
		}
	}
}
/*
         25
       /    \
     20      36
    /  \    /   \
  10   22  30    40
 /  \      /    /   \
5   12   28   38    48

*/
