package Algorithm.Tree;

/**
Determine if a given binary tree is binary search tree.

Assumptions
There are no duplicate keys in binary search tree.

You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.

Corner Cases
What if the binary tree is null? Return true in this case.
	  5
	/   \
   3     8
  / \
 1   4
 *
 */
public class IsBinarySearchTreeOrNot_30 {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;

		System.out.println(isBinarySearchTree(t1, Integer.MAX_VALUE, Integer.MIN_VALUE));
	}

	/**
	 * check every node's left child and right child
	 */
	public static boolean isBinarySearchTree(TreeNode root, int max, int min) {
		if (root == null) {
			return true;
		}

		if (root.key < min || root.key > max) {
			return false;
		}
		return isBinarySearchTree(root.left, root.key, min)
				&& isBinarySearchTree(root.right, max, root.key);
	}
}
