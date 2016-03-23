/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
public class BinaryTreeInorder_94{
	public static void main(String[] args){
		TreeNode t1 = new TreeNode( 1 );
		TreeNode t2 = new TreeNode( 2 );
		TreeNode t3 = new TreeNode( 3 );
		t1.right = t2;
		t2.left = t3;
		List<Integer> res = inorderTraversal_It( t1 );
		System.out.println( res );		
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> tmp = new ArrayList<Integer>();
		if( root == null ) return tmp;	
		tmp.addAll( inorderTraversal( root.left) );
		tmp.add( root.val );
		tmp.addAll( inorderTraversal( root.right) );
		return tmp;
    }
	
	public static List<Integer> inorderTraversal_It(TreeNode root){
		List<Integer> tmp = new ArrayList<Integer>();
		if( root == null ) return tmp;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;
		while( true ){
			while( cur!=null){
				s.push(cur);
				cur = cur.left;
			}
			if( s.isEmpty()){
				break;
			}
			cur = s.pop();
			tmp.add( cur.val );
			cur = cur.right;
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