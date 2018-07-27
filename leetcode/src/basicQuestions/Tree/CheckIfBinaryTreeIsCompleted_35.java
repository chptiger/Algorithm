package Algorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import POJO.TreeNode;

/**
Check if a given binary tree is completed. 
A complete binary tree is one in which every level of the binary tree is completely filled except possibly the last level. 
Furthermore, all nodes are as far left as possible.
Examples
        5
      /    \
    3        8
  /   \
1      4
is completed.
        5
      /    \
    3        8
  /   \        \
1      4        11
is not completed.
Corner Cases
What if the binary tree is null? Return true in this case.
How is the binary tree represented?
We use the level order traversal sequence with a special symbol "#" denoting the null node.
For Example:
The sequence [1, 2, 3, #, #, 4] represents the following binary tree:
    1
  /   \
 2     3
      /
    4

 *
 */
public class CheckIfBinaryTreeIsCompleted_35 {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(11);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
//		t3.right = t6;
		
		System.out.println(IfBinaryTreeIsCompleted(t1));
	}

	public static boolean IfBinaryTreeIsCompleted(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		boolean flag = false;
		Queue<TreeNode> cur = new LinkedList<TreeNode>();
		cur.offer(root);
		while(!cur.isEmpty()) {
			TreeNode tmp = cur.poll();
			if(tmp.left == null) {
				flag = true;
			} else if (flag) {
				return false;
			} else {
				cur.offer(tmp.left);
			}
			
			if(tmp.right == null) {
				flag = true;
			} else if (flag) {
				return false;
			} else {
				cur.offer(tmp.right);
			}
		}
		
		return true;
	}
	
	
}
