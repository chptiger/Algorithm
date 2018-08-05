package basicQuestions.Recursion.II;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import pojo.TreeNode;
import utilities.TreeUtil;

/*Description

Given two nodes in a binary tree, find their lowest common ancestor.
Assumptions
There is no parent pointer for the nodes in the binary tree
The given two nodes are guaranteed to be in the binary tree

Examples
	 5
   /   \
  9     12
 /  \      \
2    3      14

The lowest common ancestor of 2 and 14 is 5
The lowest common ancestor of 2 and 9 is 9

Medium
Binary Tree
*/

public class LowestCommonAncestorI_5_1 {
	
	@Test
	public void test_lowestCommonAncestor() {
		TreeNode root = TreeUtil.createTree();
		Assert.assertEquals(9, findLowestCommonAncestor(root, root.left.left, root.left.right).key);
	}
	
	/**
	 * 
	 * After we find the lowest common ancestor TreeNode 9, the function still need to run all other nodes.
	 * We do not need to traverse all the nodes, if we find the first ancestor, we should stop and return.
	 * The question is how to stop the recursion function.
	 * TODO Could we stop it in time?
	 * 
	 */
	public static TreeNode findLowestCommonAncestor(TreeNode root, TreeNode left, TreeNode right) {
		
		if(root == null || left == root || right == root) {
			return root;
		}
		
		TreeNode findLeft = findLowestCommonAncestor(root.left, left, right);
		TreeNode findRight = findLowestCommonAncestor(root.right, left, right);
		
		if(findLeft != null && findRight != null) {
			return root;
		}
		
		return findLeft == null? findRight : findLeft;
	}
}
