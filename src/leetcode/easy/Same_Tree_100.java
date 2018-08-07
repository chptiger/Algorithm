/*
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Subscribe to see which companies asked this question


     4
   /   \
  2     7
 / \   / \
1   3 6   9   

	 4
   /   \
  7     2
 / \   / \
9   6 3   1
*/
package leetcode.easy;
public class Same_Tree_100{
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
		n2.left = n1;
		n2.right = n3;
		print(n4);
		
		TreeNode n11 = new TreeNode(11);
		TreeNode n12 = new TreeNode(12);
		TreeNode n13 = new TreeNode(13);
		TreeNode n14 = new TreeNode(14);
		TreeNode n16 = new TreeNode(16);
		TreeNode n17 = new TreeNode(17);
		TreeNode n19 = new TreeNode(19);
		
		n14.right = n17;
		n17.left = n16;
		n17.right = n19;
		n14.left = n12;
		n12.left = n11;
		n12.right = n13;
		print(n14);
		
		boolean flag = Same_Tree(n4,n14);
		System.out.println("Same Tree is " + flag);
	}
	
	public static boolean Same_Tree(TreeNode n4, TreeNode n14){
			if (n4 == null && n14 == null) return true;
			if(n4 == null || n14 == null) return false;
			
			return ((n4.val != n14.val) && Same_Tree(n4.left, n14.left)&& Same_Tree(n4.right, n14.right));
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