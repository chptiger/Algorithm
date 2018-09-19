/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
*/
package leetcode.medium;

import java.util.*;

public class BinaryTreeRightSideView_199 {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);

		n1.left = n2;
		n1.right = n3;
		n2.right = n5;
		// n3.right = n4;

		List<Integer> res = rightSideView(n1);
		System.out.println(res);
	}

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new LinkedList<Integer>();
		Queue<TreeNode> tmp = new LinkedList<TreeNode>();
		if (root == null)
			return ans;
		tmp.add(root);
		while (tmp.size() != 0) {
			// int size = tmp.size();
			for (int i = 0; i < tmp.size(); i++) {
				TreeNode cur = tmp.poll();
				if (i == 0)
					ans.add(cur.val);
				if (cur.right != null)
					tmp.add(cur.right);
				if (cur.left != null)
					tmp.add(cur.left);
			}
		}
		return ans;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}

/*
 * public class Solution { public List<Integer> rightSideView(TreeNode root) {
 * // reverse level traversal List<Integer> result = new ArrayList();
 * Queue<TreeNode> queue = new LinkedList(); if (root == null) return result;
 * 
 * queue.offer(root); while (queue.size() != 0) { int size = queue.size(); for
 * (int i=0; i<size; i++) { TreeNode cur = queue.poll(); if (i == 0)
 * result.add(cur.val); if (cur.right != null) queue.offer(cur.right); if
 * (cur.left != null) queue.offer(cur.left); }
 * 
 * } return result; } }
 * 
 * The core idea of this algorithm:
 * 
 * 1.Each depth of the tree only select one node. 2. View depth is current size
 * of result list.
 * 
 * Here is the code:
 * 
 * public class Solution { public List<Integer> rightSideView(TreeNode root) {
 * List<Integer> result = new ArrayList<Integer>(); rightView(root, result, 0);
 * return result; }
 * 
 * public void rightView(TreeNode curr, List<Integer> result, int currDepth){
 * if(curr == null){ return; } if(currDepth == result.size()){
 * result.add(curr.val); }
 * 
 * rightView(curr.right, result, currDepth + 1); rightView(curr.left, result,
 * currDepth + 1);
 * 
 * } }
 * 
 */