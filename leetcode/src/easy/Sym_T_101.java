/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/
package easy;
import java.util.Stack;
public class Sym_T_101{
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
		
		boolean flag = isSymtree_Ite(n4);
		System.out.println(flag);
		
		flag = isSymtree_Rec(n4);
		System.out.println(flag);
	}
	
	public static boolean isSymtree_Rec(TreeNode root){
		if(root == null) return true;
		return true;
	}
	
	public static boolean isSymtree_Ite(TreeNode root){
		if(root == null) return true;
		
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root.left);
		s2.push(root.right);
		
		while(!s1.isEmpty() && !s2.isEmpty()){
			TreeNode t1 = s1.pop();
			TreeNode t2 = s2.pop();
			
			//if(t1 == null && t2 == null) return true;
			if(t1 == null && t2 == null) continue;
			if(t2 == null || t1 == null) return false;
			if(t1.val != t2.val) return false;
			
			s1.push(t1.left);
			s2.push(t2.right);
			s1.push(t1.right);
			s2.push(t2.left);
			
		}
		return true;
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

/*
public boolean isSymmetric(TreeNode root) {
    if(root==null) return true;
    return isMirror(root.left,root.right);
}
public boolean isMirror(TreeNode p, TreeNode q) {
    if(p==null && q==null) return true;
    if(p==null || q==null) return false;
    return (p.val==q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
}

*/