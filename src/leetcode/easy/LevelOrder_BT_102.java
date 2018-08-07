/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]


	 4
   /   \
  2     7
 / \   / \
1   3 6   9
*/
package leetcode.easy;
import java.util.LinkedList;
import java.util.ArrayList;

public class LevelOrder_BT_102{
	public static void main(String[] args){
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
		
		LevelOrder_BT_Ite(n4);
		
		LevelOrder_BT_Rec(n4);
	}
	public static void LevelOrder_BT_Rec(TreeNode root){
		ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
		bfs(root, 0, l);
		System.out.println(l);
	}
	
	public static void bfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> l){
		if(root == null) return;
		if(level >= l.size()){
			l.add(new ArrayList<Integer>());
		}
		l.get(level).add(root.val);
		
		bfs(root.left, level+1, l);
		bfs(root.right, level+1, l);
	}
	
	public static void LevelOrder_BT_Ite(TreeNode root){
		if(root == null) return ;
		
		LinkedList<TreeNode> s = new LinkedList<TreeNode>();
		s.add(root);
				
		while(!s.isEmpty()){
			TreeNode cur = s.pop();
			System.out.println(cur.val);
			
			if(cur.left!=null){
				s.add(cur.left);
				//System.out.println(cur.left.val);
			}
			
			if(cur.right!=null){
				s.add(cur.right);
				//System.out.println(cur.right.val);
			}
		}
		
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