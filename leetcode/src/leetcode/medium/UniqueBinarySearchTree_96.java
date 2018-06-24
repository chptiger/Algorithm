package leetcode.medium;
/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/
//   inorder: 132 321 312 213 123  --231    
//  preorder: 123 123 123 123 123  --321 231
// postorder: 231 123 213 132 321  		--312
public class UniqueBinarySearchTree_96{
	public static void main(String[] args){
		TreeNode t1 = new TreeNode( 1 );
		TreeNode t2 = new TreeNode( 2 );
		TreeNode t3 = new TreeNode( 3 );
		t1.right = t2;
		t2.left = t3;
		List<Integer> res = inorderTraversal_It( t1 );
		System.out.println( res );		
	}
	
	public static int numTrees(int n) {
        if( n <= 0) return 0;
		if( n == 1 || n == 2) return n;
			
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