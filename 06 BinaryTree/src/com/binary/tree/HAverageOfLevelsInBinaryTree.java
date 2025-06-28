package com.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HAverageOfLevelsInBinaryTree {
	public static void main(String[] args) {
		BinaryTree binaryTree = BinaryTree.getBinaryTree();
		System.out.println("********* Average of Level Order Traversal ****************");
		List<Double> average = averageOfLevels(binaryTree.root);
		System.out.println(average);
	}
	
	//Mostly it is BFS
	public static List<Double> averageOfLevels(TreeNode root) {
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);

			List<Double> result = new ArrayList<Double>();
			Double avg = 0.0;

			while (!queue.isEmpty()) {

				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode treeNode = queue.poll();
					avg = avg + treeNode.data;
					if (treeNode.left != null)
						queue.offer(treeNode.left);
					if (treeNode.right != null)
						queue.offer(treeNode.right);
				}
				result.add(avg / size);
				avg = 0.0;
			}
			return result;
		}
		return null;
	}
}

/*
TC : O(n)
SC : 0(n)

				25
			  /    \
             20      36
            /  \    /   \
          10   22  30    40
         /  \      /    /   \
        5   12   28   38    48

********* Average of Level Order Traversal ****************
[25.0, 28.0, 25.5, 26.2]
*/
