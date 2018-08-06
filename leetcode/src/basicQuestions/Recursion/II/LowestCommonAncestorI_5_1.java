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
		TreeNode result = new TreeNode(100);
		Assert.assertEquals(9, findLowestCommonAncestor(root, root.left.left, root.left.right, result).key);
	}
	
	/**
	 * 
	 * After we find the lowest common ancestor TreeNode 9, the function still need to run all other nodes.
	 * We do not need to traverse all the nodes, if we find the first ancestor, we should stop and return.
	 * The question is how to stop the current recursive method?
	 * Answer: NO
	 * Every recursion level is a new stack value to save current level variables. We could not pass the current level variable to other levels.
	 * 
	 * Wrong Answer.
	 * 
	 * If we use return method signature in the recursion method, we could get the updated value from return.
	 * 
	 * Question:
	 * How the void recursion method to update the parameter?
	 * 
	 * TODO try to understand the recursion method with void.
	 * To check if is it right.
	 * 
	 * TODO Could we stop it in time?
	 * We could not. We use recursion method to get the bottom of the method, then backtracking from bottom to top level.
	 */
	public static TreeNode findLowestCommonAncestor(TreeNode root, TreeNode left, TreeNode right, TreeNode result) {
		
		if(root == null || left == root || right == root || result.key != 100) {
			return root;
		}
		System.out.println(result.key);
		TreeNode findLeft = findLowestCommonAncestor(root.left, left, right, result);
		TreeNode findRight = findLowestCommonAncestor(root.right, left, right, result);
		
		if(findLeft != null && findRight != null) {
			result = root;
			return root;
		}
		
		return findLeft == null? findRight : findLeft;
	}
}
