package com.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class JBinaryTreePathsFromRootToLeaf {
	public static void main(String[] args) {
		BinaryTree binaryTree = BinaryTree.getBinaryTree();
		List<String> result = getBinaryTreePath(binaryTree.root);
		result.forEach(x->System.out.println(x));
	}
	
	public static List<String> getBinaryTreePath(TreeNode root) {
		ArrayList<String> res = new ArrayList<String>();
		pathFinder(res, root, "");
		return res;
	}

	private static void pathFinder(ArrayList<String> res, TreeNode root, String path) {
		if (root == null)
			return;

		// If the node is a leaf, add the path to the result list
		if (root.left == null && root.right == null) {
			res.add(path + root.data);
		}

		 // If there's a left child, recurse with an updated path
		if (root.left != null) {
			pathFinder(res, root.left, path + root.data + "-->");
		}

		// If there's a right child, recurse with an updated path
		if (root.right != null) {
			pathFinder(res, root.right, path + root.data + "-->");
		}
	}
}


/*

We start from the root A, and recursively traverse the tree.
We build the path string by appending each node’s data and adding "-->" between nodes.
When a leaf node is reached, the current path is added to the result list res.
The final paths from root to leaf are stored in res.

TC : O(n)
SC : 0(n)

				25
			  /    \
             20      36
            /  \    /   \
          10   22  30    40
         /  \      /    /   \
        5   12   28   38    48

25-->20-->10-->5
25-->20-->10-->12
25-->20-->22
25-->36-->30-->28
25-->36-->40-->38
25-->36-->40-->48
*/