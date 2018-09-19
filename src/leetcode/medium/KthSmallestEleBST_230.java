package leetcode.medium;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 = k = BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
How would you optimize the kthSmallest routine?

Given binary search tree {1,3,4},
   3
  /  \
 1    4
  \	   \
   2    5
 
*/

public class KthSmallestEleBST_230 {
	static int count = 0;
	static int result = Integer.MIN_VALUE;

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(2);
		TreeNode t5 = new TreeNode(5);
		t1.right = t3;
		t1.left = t2;
		t2.right = t4;
		t3.right = t5;
		int k = 2;
		int res = kthSmallest(t1, k);
		System.out.println(res);
	}

	// in order traverse BST
	public static int kthSmallest(TreeNode root, int k) {

		result = traverse(root, k);
		return result;
	}

	public static int traverse(TreeNode root, int k) {
		if (root == null)
			return;
		traverse(root.left, k);
		count++;

		if (count == k)
			return root.val;

		traverse(root.right, k);
	}

	// directly solution: do not need return string, focus on K is better.
	public static int kthSmallest_directly(TreeNode root, int k) {
		String tmp = BST2Array(root).toString();
		String fina = String.valueOf(tmp.charAt(k - 1));
		System.out.println(fina);
		int result = Integer.parseInt(fina);
		return result;
	}

	public static StringBuffer BST2Array(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		if (root == null)
			return sb;

		sb.append(BST2Array(root.left));
		sb.append(root.val);
		sb.append(BST2Array(root.right));
		return sb;
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