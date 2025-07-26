package amit.kumar.bimnarytree;

import java.util.LinkedList;
import java.util.Queue;

//BST (Binary Search Tree)
public class BinaryTree {
	public TreeNode root;

	// Insert a new node with the given value
	public void insert(int id) {
		TreeNode newNode = new TreeNode(id); // Create a new node with the given value

		// If the tree is empty, set the root to the new node
		if (root == null) {
			root = newNode;
			return;
		}

		// Start from the root and traverse iteratively
		TreeNode current = root;
		TreeNode parent = null;

		while (current != null) {
			parent = current;
			if (id < current.data) {
				current = current.left; // Move to the left subtree if id is smaller
			} else {
				current = current.right; // Move to the right subtree if id is greater or equal
			}
		}

		// Insert the new node at the correct position
		if (id < parent.data) {
			parent.left = newNode; // Insert to the left of parent
		} else {
			parent.right = newNode; // Insert to the right of parent
		}
	}

	public void createBinaryTree() {
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);
		TreeNode sixth = new TreeNode(6);
		TreeNode seventh = new TreeNode(7);
		root = first;
		first.left = second;
		first.right = third;

		second.left = fourth;
		second.right = fifth;

		third.left = sixth;
		third.right = seventh;
	}

	// Level order traversal is BFS
	public void levelOrderTraversal(TreeNode root) {
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				TreeNode treeNode = queue.poll();
				System.out.print(treeNode.data + "-->");

				// Add the left child to the queue if it exists
				if (treeNode.left != null) {
					queue.offer(treeNode.left);
					// System.out.println(treeNode.data +"-->");
				}

				// Add the right child to the queue if it exists
				if (treeNode.right != null) {
					// System.out.println(treeNode.data +"-->");
					queue.offer(treeNode.right);
				}
			}
		}
	}

	public static BinaryTree getBinaryTree() {
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
		return binaryTree;
	}

	public static void printEvenNodeUsingInOrder(TreeNode root) {
		if (root != null) {
			printEvenNodeUsingInOrder(root.left);
			if (root.data % 2 == 0)
				System.out.print(root.data + " ");
			printEvenNodeUsingInOrder(root.right);
		}
	}
}