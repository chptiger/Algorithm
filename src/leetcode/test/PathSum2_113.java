
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
import java.util.ArrayList;
import java.util.List;

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
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
		pathSum(root, sum, cur, ret);
		return ret;
	}

	public static void pathSum(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> ret) {
		if (root == null) {
			return;
		}
		cur.add(root.val);
		if (root.left == null && root.right == null && root.val == sum) {
			ret.add(new ArrayList(cur));
		} else {
			pathSum(root.left, sum - root.val, cur, ret);
			pathSum(root.right, sum - root.val, cur, ret);
		}
		cur.remove(cur.size() - 1);
	}

	/*
	 * public static List<List<Integer>> pathSum(TreeNode root, int sum) {
	 * 
	 * List<List<Integer>> result = new LinkedList<List<Integer>>(); List<Integer>
	 * tmp = new LinkedList<Integer>(); result.add(pathSum_help(root, sum,tmp);
	 * return result; }
	 * 
	 * public static List<Integer> pathSum_help(TreeNode root, int sum,List<Integer>
	 * tmp){
	 * 
	 * if( root == null && target == sum) return tmp;
	 * 
	 * if( root == null && target != sum) return null;
	 * 
	 * return pathSum_help(root.left,sum,tmp); tmp.add(root.val); target +=root.val;
	 * return pathSum_help(root.left,sum,tmp);
	 * 
	 * }
	 */
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}