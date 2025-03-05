package ecom.binarySearchTree;

import com.binary.tree.TreeNode;

/*
Find minimum and maximum elements in binary search tree in java.
Minimum element is nothing but leftmost node in binary search tree, so traverse left until you get leftmost element.
Maximum element is nothing but rightmost node in binary search tree, so traverse right until you get rightmost element.
*/
public class DBinarySearchTreeMinMaxMain {
	
	public static void main(String[] args) {

		// Creating a binary search tree
		TreeNode rootNode = createBinarySearchTree();
		System.out.println("Minimum element in binary search tree: " + minimumElement(rootNode).data);
		System.out.println("Maximum element in binary search tree: " + maximumElement(rootNode).data);

	}
	
	// Get minimum element in binary search tree
	public static TreeNode minimumElement(TreeNode root) {
		if (root.left == null)
			return root;
		else {
			return minimumElement(root.left);
		}
	}

	// Get maximum element in binary search tree
	public static TreeNode maximumElement(TreeNode root) {
		if (root.right == null)
			return root;
		else {
			return maximumElement(root.right);
		}
	}

	public static TreeNode insert(TreeNode root, TreeNode newNode) {
		if (root == null) {
			root = newNode;
			return root;
		}

		if (root.data > newNode.data) {
			if (root.left == null)
				root.left = newNode;
			else
				insert(root.left, newNode);
		} else if (root.data < newNode.data)
			if (root.right == null)
				root.right = newNode;
			else
				insert(root.right, newNode);
		return root;
	}

	public static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static TreeNode createBinarySearchTree() {
		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);
		TreeNode node5 = new TreeNode(5);
		TreeNode node55 = new TreeNode(55);

		insert(null, rootNode);
		insert(rootNode, node20);
		insert(rootNode, node10);
		insert(rootNode, node30);
		insert(rootNode, node60);
		insert(rootNode, node50);
		insert(rootNode, node70);
		insert(rootNode, node5);
		insert(rootNode, node55);
		return rootNode;
	}
}
