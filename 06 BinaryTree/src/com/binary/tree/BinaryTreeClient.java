package com.binary.tree;

public class BinaryTreeClient {
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
		
		System.out.println("********* Level Order Traversal ****************");
		binaryTree.levelOrderTraversal(binaryTree.root);
		System.out.println("\n\n********** In Order Traversal ***************");
		binaryTree.inOrder(binaryTree.root);
		System.out.println("\n\n******** Post Order Traversal *****************");
		binaryTree.postOrder(binaryTree.root);
		System.out.println("\n\n********** Pre Order Traversal ***************");
		binaryTree.preeOrder(binaryTree.root);
		System.out.println("\n\n********** Find an Elements ***************");
		TreeNode node=binaryTree.find(20);
		if(node!=null)
			System.out.println(node.data + ": is present in the BST. ");
		else
			System.out.println("Search element is not present in the BST.");
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