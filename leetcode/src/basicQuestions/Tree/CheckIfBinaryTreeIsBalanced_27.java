package Algorithm.Tree;

import pojo.TreeNode;

/**
Check if a given binary tree is balanced. 
A balanced binary tree is one in which the depths of every node��s left and right subtree differ by at most 1.
 
Examples
        5
      /    \
    3        8
  /   \        \
1      4        11
is balanced binary tree,
        5
      /
    3
  /   \
1      4
is not balanced binary tree.

Corner Cases
What if the binary tree is null? Return true in this case.

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
public class CheckIfBinaryTreeIsBalanced_27 {
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
		System.out.println(binarySearchTreeIsBalanced(t1));
	}

	/**
	 * check every node's left child and right child
	 */
	public static boolean binarySearchTreeIsBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(treeHeight(root.left) - treeHeight(root.right)) > 1) {
			return false;
		} else {
			return binarySearchTreeIsBalanced(root.left)
					&& binarySearchTreeIsBalanced(root.right);
		}
	}

	public static int treeHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
	}
}
