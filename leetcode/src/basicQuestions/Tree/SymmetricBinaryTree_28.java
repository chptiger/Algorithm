package Algorithm.Tree;

import utilities.TreeNode;

/**
Check if a given binary tree is symmetric.
 
Examples
 		5
      /    \
    3        3
  /   \    /   \
1      4  4      1
is symmetric.

        5
      /    \
    3        3
  /   \    /   \
1      4  1      4
is not symmetric.

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
public class SymmetricBinaryTree_28 {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(1);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		System.out.println(isSymmetricBinaryTree(t1));
	}

	/**
	 * check every node's left child and right child
	 */
	public static boolean isSymmetricBinaryTree(TreeNode root) { 
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}
	
	public static boolean isSymmetric(TreeNode one, TreeNode two) {
		if(one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if (one.key != two.key) {
			return false;
		}
		return isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
	}
}
