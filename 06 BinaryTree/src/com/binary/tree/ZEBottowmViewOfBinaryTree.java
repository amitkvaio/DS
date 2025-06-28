package com.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class ZEBottowmViewOfBinaryTree {
	
	public static void main(String[] args) {
		TreeNode root = getBinaryTree();
		List<Integer> topView = bottomView(root);
		System.out.println(topView);
	}
	
	public static TreeNode getBinaryTree() {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);

		root.left = two;
		root.right = three;

		two.left = four;
		three.right = five;

		five.left = six;
		four.right = seven;

		return root;
	}
	
	public static List<Integer> bottomView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;

		// Map to store first node at each horizontal distance
		Map<Integer, Integer> hdMap = new TreeMap<>();

		// Queue for level order traversal
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));

		while (!queue.isEmpty()) {
			Pair current = queue.poll();
			TreeNode node = current.node;
			int hd = current.hd;

			// Overwrite for bottom view
			hdMap.put(hd, node.data);

			// Add left and right child nodes with updated HD
			if (node.left != null) {
				queue.add(new Pair(node.left, hd - 1));
			}

			if (node.right != null) {
				queue.add(new Pair(node.right, hd + 1));
			}
		}

		result.addAll(hdMap.values());
		return result;
	}
	
	static class Pair {
		TreeNode node;
		int hd; // horizontal distance

		Pair(TreeNode node, int hd) {
			this.node = node;
			this.hd = hd;
		}
	}
}

/*
        1
       / \
      2   3
     /     \
    4		5
     \ 	   /
      7	  6
      
output:
[4, 7, 1, 6, 5]
     
The Bottom View is the set of nodes visible when the tree is viewed from the bottom.   
For each horizontal distance (HD), take the last node encountered during level-order traversal.

TC : O(n)
SC : O(n)


Summary Table
*****************
View		Traversal 	Type	Condition								Key Data Structure
Left View	BFS/DFS		First 	node at each level						Queue + Level count
Right View	BFS/DFS		Last 	node at each level						Queue + Level count
Bottom View	BFS			Last 	node at each horizontal distance (HD)	Queue + TreeMap
Top View	BFS			First 	node at each horizontal distance (HD)	Queue + TreeMap

*/