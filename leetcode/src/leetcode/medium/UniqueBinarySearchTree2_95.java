package leetcode.medium;

/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
Subscribe to see which companies asked this question

I start by noting that 1..n is the in-order traversal for any BST with nodes 1 to n. 
So if I pick i-th node as my root, the left subtree will contain elements 1 to (i-1), 
and the right subtree will contain elements (i+1) to n. 
I use recursive calls to get back all possible trees for left and right subtrees and 
combine them in all possible ways with the root.

*/
import java.util.ArrayList;
import java.util.List;
public class UniqueBinarySearchTree2_95{
	public static void main(String[] args){
		int n = 5;
		List<TreeNode> res = generateTrees(n);
		System.out.println(res);
	}
	
	public static List<TreeNode> generateTrees(int n) {

        return genTrees(1,n);
    }

    public static List<TreeNode> genTrees (int start, int end)
    {

        List<TreeNode> list = new ArrayList<TreeNode>();

        if(start>end)
        {
            list.add(null);
            return list;
        }

        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left,right;
        for(int i=start;i<=end;i++)
        {

            left = genTrees(start, i-1);
            right = genTrees(i+1,end);

            for(TreeNode lnode: left)
            {
                for(TreeNode rnode: right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }

        }

        return list;
    }
	
	public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
}




   


