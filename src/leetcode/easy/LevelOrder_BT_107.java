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
  [15,7],
  [9,20],
  [3]
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

public class LevelOrder_BT_107{
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
				
		bfs(root.left, level+1, l);
		bfs(root.right, level+1, l);
		
		l.get(l.size()-level-1).add(root.val);
	}
	
	/* DFS
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }
	*/
	
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