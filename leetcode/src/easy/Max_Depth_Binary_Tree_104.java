/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node
*/
package easy;
import java.util.*;
public class Max_Depth_Binary_Tree_104{
	public static void main(String [] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n4.right = n6;
		n6.left = n5;
		n6.right = n7;
		n4.left = n2;
		n2.left = n1;
		n2.right = n3;
		
		int h = Max_Depth_Binary_Tree_Rec(n4);
		System.out.println("The max depth by Rec  " + h);
		
		int k = Max_Depth_Binary_Tree_Ite(n4);
		System.out.println("The max depth by Ite  " + k);
	}
	
	public static int Max_Depth_Binary_Tree_Rec(TreeNode root){
		if(root == null)		return 0;
		return Math.max(Max_Depth_Binary_Tree_Rec(root.left), Max_Depth_Binary_Tree_Rec(root.right))+1;
	}
	
	public static int Max_Depth_Binary_Tree_Ite(TreeNode root){
		if(root == null) return 0;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int levelNode=1;
		int h = 1;
		int height = 1;
		queue.add(root);
		TreeNode cur;
		while(!queue.isEmpty()){
			cur = queue.poll();
			h--;
			if(cur.left!= null){
				queue.add(cur.left);
				levelNode++;
			}
			if(cur.right != null){
				queue.add(cur.right);
				levelNode++;
			}
			if( h == 0){
				h = levelNode;
				levelNode = 0;
				height++;
			}
			
		}
		
		return height;
	}
	
}

 class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int val){
			this.val = val;
		}
	}

