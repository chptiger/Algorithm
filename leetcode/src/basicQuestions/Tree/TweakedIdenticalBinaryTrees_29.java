package Algorithm.Tree;

import POJO.TreeNode;

/**
Determine whether two given binary trees are identical assuming any number of ��tweak��s are allowed. 
A tweak is defined as a swap of the children of one node in the tree.
Examples
        5
      /    \
    3        8
  /   \
1      4
and
        5
      /    \
    8        3
           /   \
          1     4
the two binary trees are tweaked identical.
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
public class TweakedIdenticalBinaryTrees_29 {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		
		TreeNode t11 = new TreeNode(5);
		TreeNode t22 = new TreeNode(3);
		TreeNode t33 = new TreeNode(8);
		TreeNode t44 = new TreeNode(1);
		TreeNode t55 = new TreeNode(4);
		t11.left = t33;
		t11.right = t22;
		t22.left = t44;
		t22.right = t55;
		System.out.println(tweakedIdenticalBinaryTrees(t1, t11));
	}

	/**
	 * check every node's left child and right child
	 */
	public static boolean tweakedIdenticalBinaryTrees(TreeNode one, TreeNode two) { 
		if(one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if (one.key != two.key) {
			return false;
		}
		
		return (tweakedIdenticalBinaryTrees(one.left, two.left) && tweakedIdenticalBinaryTrees(one.right, two.right)) 
				|| 
				(tweakedIdenticalBinaryTrees(one.left, two.right) && tweakedIdenticalBinaryTrees(one.right, two.left));
	}
}
