package com.binary.tree;

/*
If you look closely to above diagram, boundary traversals can be divided into three essential parts

Print left edge nodes (Excluding leaf nodes)
Print leaf nodes
Print right edge nodes (From bottom to top)

Check : UBoundaryTraversal.png
*/
public class UBinaryTreeBoundaryTraversal {

	public static void boundaryLevelTraversal(TreeNode root) {
		System.out.print(root.data + " ");
		printLeftBoundary(root.left);
		printLeafNodes(root);
		printRightBottomUp(root.right);

	}

	// Print left boundary excluding leaf nodes
	private static void printLeftBoundary(TreeNode node) {
		while (node != null) {
			if (node.left != null || node.right != null) {
				System.out.print(node.data + " ");
			}
			node = (node.left != null) ? node.left : node.right;
		}
	}

	private static void printLeafNodes(TreeNode root) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
			return;
		}
		printLeafNodes(root.left);
		printLeafNodes(root.right);
	}

	private static void printRightBottomUp(TreeNode root) {
		if (root == null)
			return;

		// if leaf node, ignore while printing edges
		if (root.left == null && root.right == null) {
			return;
		}

		if (root.right != null) {
			printRightBottomUp(root.right);
		} else if (root.left != null) {
			printRightBottomUp(root.left);
		}

		System.out.print(root.data + " ");
	}

	public static void main(String[] args) {
		// Creating a binary tree
		TreeNode rootNode = createBinaryTree();
		System.out.println("Boundary traversal of binary tree will be:");
		boundaryLevelTraversal(rootNode);
	}

	public static TreeNode createBinaryTree() {
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
		return binaryTree.root;
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
