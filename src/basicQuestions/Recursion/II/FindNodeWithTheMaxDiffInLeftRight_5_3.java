package basicQuestions.Recursion.II;

import org.junit.Assert;
import org.junit.Test;

import pojo.TreeNode;
import utilities.TreeUtil;

/**
	given a binary tree,
	find the node with the max different in the total num descendants in its left and right subtree
	
			 5
		   /   \
		  9     12
		 /  \      \
		2    3      14
	
	node 12, diff is 1
*/
public class FindNodeWithTheMaxDiffInLeftRight_5_3 {
	
	@Test
	public void test_findNodeWithTheMaxDiffInLeftRight() {
		TreeNode root = TreeUtil.createTree();
		Assert.assertEquals(12, numNodesLeft(root)); // both 12 or 5 is the max diff. 
	}
    public int numNodesLeft(TreeNode root) {
    	TreeNode result = new TreeNode(-1);
    	int[] diff = new int[1];  // use array to keep pass by the value of the max value. if we declare a basic type like int type, it's only working in one recrsion level
    	diff[0] = -1;
        numNodes(root, result, diff);
        return result.key;
    }

    private int numNodes(TreeNode root, TreeNode result, int[] diff) {
    	if(root == null) {
    		return 0;
    	}
    	
    	int left = numNodes(root.left, result, diff);
    	int right = numNodes(root.right, result, diff);
    	if(Math.abs(left - right) > diff[0]) { // change to >= return will be 5
    		diff[0] = Math.abs(left - right);
    		result.key = root.key;
    	}
    	
    	return left + right + 1;
    }
}