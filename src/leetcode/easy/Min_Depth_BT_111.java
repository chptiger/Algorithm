/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

*/
package leetcode.easy;
public class Min_Depth_BT_111{
	public static void main(String [] args){
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
		//n2.left = n1;
		//n2.right = n3;
		print(n4);
		
		int n = Min_Depth_BT(n4);
		System.out.println(n);
	}
	
	public static int Min_Depth_BT(TreeNode n){
		if(n == null) return 0;
		return Math.min(Min_Depth_BT(n.left), Min_Depth_BT(n.right))+1;
	}
	public static void print(TreeNode root){
		if(root == null) return;
		
		print(root.left);
		System.out.println(root.val);
		print(root.right);
	}
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val){
			this.val = val;
		}
	}
}