package leetcode.medium;
/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
public class BinaryTreePreorder_144{
	public static void main(String[] args){
		TreeNode t1 = new TreeNode( 1 );
		TreeNode t2 = new TreeNode( 2 );
		TreeNode t3 = new TreeNode( 3 );
		t1.right = t2;
		t2.left = t3;
		List<Integer> res = preorderTraversal_It( t1 );
		System.out.println( res );		
	}
	
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> tmp = new ArrayList<Integer>();
		if( root == null ) return tmp;	
		
		tmp.add( root.val );
		tmp.addAll( preorderTraversal( root.left) );
		tmp.addAll( preorderTraversal( root.right) );
	
		return tmp;
    }
	
	public static List<Integer> preorderTraversal_It(TreeNode root){
		List<Integer> tmp = new ArrayList<Integer>();
		if( root == null ) return tmp;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = null;
		TreeNode head = root;
		s.push(head);
		while( !s.isEmpty()){
			cur = s.pop();
			tmp.add( cur.val );
			if( cur.right != null){
				s.push( cur.right);
			}
			if( cur.left != null ){
				s.push( cur.left );
			}
		}
		return tmp;
	}
	
	static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
	 TreeNode(int x) { val = x; }
    }
}