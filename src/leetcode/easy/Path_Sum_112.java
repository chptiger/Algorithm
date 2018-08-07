package leetcode.easy;
/*
Given a binary tree and a sum, 
determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            6   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/

public class Path_Sum_112{
	public static void main(String[] args){
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n8 = new TreeNode(8);
		TreeNode n11 = new TreeNode(11);
		TreeNode n13 = new TreeNode(13);
		TreeNode n4 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		
		n5.right = n8;
		n8.left = n13;
		n8.right = n4;
		n4.right = n1;
		n5.left = n6;
		n6.left = n11;
		n11.left = n7;
		n11.right = n2;
		print(n5);
		
		boolean flag = Path_Sum(n5, 18);
		
		System.out.println(flag);
	}
	
	public static boolean Path_Sum(TreeNode root, int n){
		int sum = 0;
		return Path_Sum_Help(root, n, sum);
	}
	
	public static boolean Path_Sum_Help(TreeNode root, int n, int sum){
		if(root == null) return false;
		
		sum =sum + root.val;
		
		// equal && leaf node
		if(sum == n && root.left == null && root.right == null) return true;
		// not equal && leaf node
		if(sum != n && root.left == null && root.right == null) return false;
		// equal && non leaf node

		return (Path_Sum_Help(root.left, n , sum) || Path_Sum_Help(root.right, n ,sum));
	
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