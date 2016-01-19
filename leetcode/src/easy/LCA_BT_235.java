/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: 
“The lowest common ancestor is defined between two nodes v and w as the lowest node in T 
that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
since a node can be a descendant of itself according to the LCA definition.
     4
   /   \
  2     7
 / \   / \
1   3 6   9
*/
package easy;
public class LCA_BT_235{
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
		
		TreeNode n = LCA_BT(n4,n7,n6);
		System.out.println(n.val);
	}
	
	public static TreeNode LCA_BT(TreeNode root,TreeNode n1, TreeNode n2){
		TreeNode n = null;
		if(root == n1) return n = n1;
		if(root == n2) return n = n2;
		
		if(find_Help(root.left, n1)){
			if(find_Help(root.right, n2)) return root;
			else n = LCA_BT(root.left, n1, n2);
		}
		
		if(find_Help(root.right, n1)){
			if(find_Help(root.left, n2)) return root;
			else n = LCA_BT(root.right, n1, n2);
		}
		return n;
	}
	
	public static boolean find_Help(TreeNode root, TreeNode n){
		if(root == null || n == null) return false;
		if(root == n) return true;
		
		boolean found;
		found = find_Help(root.left, n);
		
		if(!found) found = find_Help(root.right, n);
		
		return found;
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