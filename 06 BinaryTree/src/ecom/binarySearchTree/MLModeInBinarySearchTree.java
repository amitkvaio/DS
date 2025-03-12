package ecom.binarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.binary.tree.BinaryTree;
import com.binary.tree.TreeNode;

public class MLModeInBinarySearchTree {
	
	 private int currNum = 0;
	    private int currStreak = 0;
	    private int maxStreak = 0;
	    private List<Integer> result = new ArrayList<>();

	    private void dfs(TreeNode root) {
	        if (root == null) {
	            return;
	        }

	        dfs(root.left);

	        if (root.data == currNum) {
	            currStreak++;
	        } else {
	            currNum = root.data;
	            currStreak = 1;
	        }

	        if (currStreak > maxStreak) {
	            result.clear();
	            maxStreak = currStreak;
	        }

	        if (currStreak == maxStreak) {
	            result.add(root.data);
	        }

	        dfs(root.right);
	    }

	    public int[] findMode(TreeNode root) {
	        dfs(root);

	        int[] resultArray = new int[result.size()];
	        for (int i = 0; i < result.size(); i++) {
	            resultArray[i] = result.get(i);
	        }

	        return resultArray;
	    }
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(1);
		binaryTree.insert(2);
		binaryTree.insert(2);
		binaryTree.levelOrderTraversal(binaryTree.root);
		
		MLModeInBinarySearchTree tree = new MLModeInBinarySearchTree();
		System.out.println(Arrays.toString(tree.findMode(binaryTree.root)));
	}
}
//Approach-2 (without Using extra space)
//T.C : O(n)
//S.C : O(1) (stack space is not considered)