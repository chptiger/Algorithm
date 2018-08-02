package unitTest;

// Store number of nodes in left subtree
public class StoreNumberOfNodesInLeftSubtree {
    static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        // stores the num of node in left subtree
        int numNodesLeft;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public void numNodesLeft(TreeNode root) {
        numNodes(root);
    }

    private int numNodes(TreeNode root) {
    	if(root == null) {
    		return 1;
    	}
    	int left = numNodes(root.left);
    	int right = numNodes(root.right);
    	
    	root.numNodesLeft = left + right;
    	
    	return left + right + 1; // at the last level, left and right are null nodes, parent node is left node, number is 1.
    }
}