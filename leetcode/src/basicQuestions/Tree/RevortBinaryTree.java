package tree;

import POJO.TreeNode;

public class RevortBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		root.left = invertTree(root.left);
		root.right = invertTree(root.right);

		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}