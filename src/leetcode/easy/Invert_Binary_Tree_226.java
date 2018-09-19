/*
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

*/
package leetcode.easy;

import java.util.*;

public class Invert_Binary_Tree_226 {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n9 = new TreeNode(9);

		n4.right = n7;
		n7.left = n6;
		n7.right = n9;
		n4.left = n2;
		n2.left = n1;
		n2.right = n3;
		print(n4);

		Invert_Binary_Tree_Rec(n4);
		System.out.println("Invert binary tree by Rec  ");
		print(n4);

		Invert_Binary_Tree_Ite(n4);
		System.out.println("Invert binary tree by Ite  ");
		print(n4);
	}

	public static void print(TreeNode root) {
		if (root == null)
			return;

		print(root.left);
		System.out.println(root.val);
		print(root.right);
	}

	public static void Invert_Binary_Tree_Rec(TreeNode root) {
		if (root == null)
			return;

		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;

		Invert_Binary_Tree_Rec(root.left);
		Invert_Binary_Tree_Rec(root.right);

	}

	public static void Invert_Binary_Tree_Ite(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode cur;

		while (!stack.isEmpty()) {
			cur = stack.pop();
			TreeNode tmp = cur.left;
			cur.left = cur.right;
			cur.right = tmp;

			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}

		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}