package amit.kumar.recursion;

import amit.kumar.bimnarytree.BinaryTree;
import amit.kumar.bimnarytree.TreeNode;

public class OHeightOfBinaryTree {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(25);
		binaryTree.insert(20);
		binaryTree.insert(36);
		binaryTree.insert(10);
		binaryTree.insert(22);
		binaryTree.insert(30);
		binaryTree.insert(40);
		binaryTree.insert(5);
		binaryTree.insert(12);
		binaryTree.insert(28);
		binaryTree.insert(38);
		binaryTree.insert(48);
		binaryTree.levelOrderTraversal(binaryTree.root);
		System.out.println("\n############### Find the height of the binary tree ######################");
		System.out.println(getHeightOfTheTree(binaryTree.root));
	}
	
	public static int getHeightOfTheTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftCount = getHeightOfTheTree(root.left);
		int rightCount = getHeightOfTheTree(root.right);
		return 1 + Math.max(leftCount, rightCount);
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