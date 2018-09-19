package leetcode.medium;

/*

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/
import java.util.List;
import java.util.ArrayList;

public class PathSum2_113 {
	public static int target = 0;

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(11);
		TreeNode t5 = new TreeNode(7);
		TreeNode t6 = new TreeNode(2);
		TreeNode t7 = new TreeNode(13);
		TreeNode t8 = new TreeNode(4);
		TreeNode t9 = new TreeNode(5);
		TreeNode t10 = new TreeNode(1);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t4.left = t5;
		t4.right = t6;
		t3.left = t7;
		t3.right = t8;
		t8.left = t9;
		t8.right = t10;

		int sum = 22;

		List<List<Integer>> res = pathSum(t1, sum);
		;

		System.out.println(res);
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> resu = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		pathSum_help(root, sum, tmp, resu);
		return resu;
	}

	public static void pathSum_help(TreeNode root, int sum, List<Integer> tmp, List<List<Integer>> resu) {
		if (root == null)
			return;
		tmp.add(root.val);
		if (root.left == null && root.right == null && root.val == sum)
			resu.add(new ArrayList<Integer>(tmp));
		else {
			pathSum_help(root.left, sum - root.val, tmp, resu);
			pathSum_help(root.right, sum - root.val, tmp, resu);
		}
		tmp.remove(tmp.size() - 1);
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