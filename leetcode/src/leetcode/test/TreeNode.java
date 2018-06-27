package Leetcode;

public class TreeNode {
	int val;
	 TreeNode left;
	 TreeNode right;
	 
	 TreeNode(int x) { val = x; }
	 
	 public static TreeNode createDuplicateTree(){
		 TreeNode t1 = new TreeNode(2);
			TreeNode t2 = new TreeNode(4);
			TreeNode t3 = new TreeNode(1);
			TreeNode t4 = new TreeNode(3);
			TreeNode t5 = new TreeNode(4);
			TreeNode t6 = new TreeNode(1);
			
			t1.left = t2;
			t1.right = t4;
			t2.left = t3;
			t4.left = t5;
			t5.left = t6;
			return t1;
	 }
	 
	 public static String printInOrderTreeNode(TreeNode root) {
		 StringBuilder res = new StringBuilder();
		  inorderTraverseTree(root, res);
		  return res.toString();
	 }

	private static void inorderTraverseTree(TreeNode root, StringBuilder res) {
		if(root == null) res.append("#");
		if(root.left != null) inorderTraverseTree(root.left, res);
		res.append(root.val + "");
		if(root.right != null) inorderTraverseTree(root.right, res);
	}
}
