package com.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
Get level of a node in binary tree in java
Refer Print_Level_Btree
*/
public class SBinaryTreeGetLevelNode {
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
		System.out.println();
		printLevelBtree(binaryTree.root,10);
		printLevelBtree(binaryTree.root,48);
		printLevelBtree(binaryTree.root,12);
	}
	
	public static void printLevelBtree(TreeNode root,int target){
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(new Pair(root, 0));
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			if(pair.treeNode.data==target)
				System.out.println("Level of >>>>>>>>>>>>" + target + " is " + pair.level); 
			if(pair.treeNode.left!=null) {
				queue.offer(new Pair(pair.treeNode.left,pair.level+1));
			}
			if(pair.treeNode.right!=null) {
				queue.offer(new Pair(pair.treeNode.right,pair.level+1));
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