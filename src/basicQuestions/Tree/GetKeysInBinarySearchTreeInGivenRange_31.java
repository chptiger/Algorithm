package Algorithm.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pojo.TreeNode;

/**
Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, 
both min and max are inclusive.
Examples
        5
      /    \
    3        8
  /   \        \
 1     4        11
 
get the keys in [2, 5] in ascending order, result is  [3, 4, 5]

Corner Cases
What if there are no keys in the given range? Return an empty list in this case.

How is the binary tree represented?
We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:
The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
    1
  /   \
 2     3
      /
    4
 *
 */
public class GetKeysInBinarySearchTreeInGivenRange_31 {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(11);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;
		
		List<Integer> result = getRange(t1, 2 , 5);
		System.out.println(result.toString());
	}

	public static List<Integer> getRange(TreeNode root, int min, int max) {
		List<Integer> result = new ArrayList();
		if (root == null) {
			return result;
		}
		return getKeysInBinarySearchTree(root, min, max, result);
	}
	
	/**
	 * check every node's left child and right child
	 * 
	 * in-order the tree to get ascending order
	 */
	public static List<Integer> getKeysInBinarySearchTree(TreeNode root,
			int min, int max, List<Integer> result) {
		if (root == null) {
			return null;
		}
		if (root.key > min) {
			getKeysInBinarySearchTree(root.left, min, max, result);
		}
		if (root.key >= min && root.key <= max) {
			result.add(root.key);
		}
		if (root.key < max) {
			getKeysInBinarySearchTree(root.right, min, max, result);
		}
		return result;
	}
}
