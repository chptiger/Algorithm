package leetcode.easy;
/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

*/
public class BinaryTrePaths_257{
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n1 = new TreeNode(3);
		TreeNode n1 = new TreeNode(5);
		
		n1.left = n2;
		n1.right = n3;
		n2.right = n5;
		
		List<String> res = binaryTreePaths(n1);
		
		
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
        if( root == null) return null;
		List<String> treeLeft = ArrayList<String>();
		treeLeft.add(root.val);
		List<String> treeRight = ArrayList<String>();
		treeRight.add(root.val);
		if(root.left != null){
			treeLeft.add(root.left.val);
		}
		
		if(root.right != null){
			treeRight.add(root.right.val);
		}
		
		binaryTreePaths(root.left);
		binaryTreePaths(root.right);
    }
	
	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
	}
}