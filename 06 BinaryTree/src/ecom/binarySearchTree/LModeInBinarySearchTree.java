package ecom.binarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.binary.tree.BinaryTree;
import com.binary.tree.TreeNode;

public class LModeInBinarySearchTree {
	
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	private void dfs (TreeNode root) {
		if(root==null) {
			return;
		}
		dfs(root.left);
		map.put(root.data, map.getOrDefault(root.data, 0) + 1);
		dfs(root.right);
	}
	
	public int[] findMode(TreeNode root) {
		dfs(root);
		List<Integer> resultList = new ArrayList<Integer>();
		int maxFreq = 0;
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			
			if(value > maxFreq) {
				maxFreq = value;
				resultList.clear();
				resultList.add(key);
			}else if(value == maxFreq) {
				resultList.add(key);
			}
		}
		
		int[] result = new int[resultList.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = resultList.get(i);
		}
		return result;
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(1);
		binaryTree.insert(2);
		binaryTree.insert(2);
		binaryTree.levelOrderTraversal(binaryTree.root);
		
		LModeInBinarySearchTree tree = new LModeInBinarySearchTree();
		System.out.println(Arrays.toString(tree.findMode(binaryTree.root)));
	}
}
/*
//Approach-1 (Using O(n) space)
//T.C : O(n)
//S.C : O(n)
*/