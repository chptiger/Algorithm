/*
Given a binary search tree, write a function kth Smallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 = k = BST's total elements.
*/
public class UniqueBinarySearchTree_96{
	public static void main(String[] args){
		TreeNode t1 = new TreeNode( 1 );
		TreeNode t2 = new TreeNode( 2 );
		TreeNode t3 = new TreeNode( 3 );
		t1.right = t2;
		t2.left = t3;
		int k = 3;
		List<Integer> res = inorderTraversal_It( t1, k );
		System.out.println( res );		
	}
	
	 public static int kthSmallest(TreeNode root, int k) {
        
    }
	
	static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
    }
}