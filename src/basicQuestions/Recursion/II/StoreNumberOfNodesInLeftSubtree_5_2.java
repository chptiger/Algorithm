package basicQuestions.Recursion.II;

// Store number of nodes in left subtree
public class StoreNumberOfNodesInLeftSubtree_5_2 {
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
		if (root == null) {
			return 0;
		}
		// left num is the num of nodes in subtree of root.left
		int left = numNodes(root.left);
		// right num is the num of nodes in subtree of root.right
		int right = numNodes(root.right);

		root.numNodesLeft = left + right;

		// return the total num of nodes in the subrree of root
		return left + right + 1; // at the last level, left and right are null nodes, parent node is left node,
									// number is 1.
	}
}