package tree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNode_Test {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(5);
		TreeNode node7 = new TreeNode(7);
		/*
		 * 4 / \ 2 6 / \ / \ 1 3 5 7
		 */
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;

		System.out.println("getNodeNum by Recursion: " + getNodeNumRe(node1));
		getNodeNum(node1);

		System.out.println("getTreeLevelRe by Recursion: " + getTreeLevelRe(node1));
		getTreeLevel(node1);

		System.out.println("preorder traverse recursion: ");
		preOrderRe(node1);
		System.out.println("preorder traverse iteration: ");
		preOrderIt(node1);

		System.out.println("inorder traverse recursion: ");
		inOrderIt(node1);
		System.out.println("idorder traverse iteration: ");
		inOrderRe(node1);

		System.out.println("posorder traverse recursion: ");
		posOrderIt(node1);
		System.out.println("posorder traverse iteration: ");
		posOrderRe(node1);

		System.out.println("level traverse recursion: ");
		levelTravelRe(node1);
		System.out.println("level traverse iteration: ");
		levelTravelIt(node1);

		// System.out.println("BST2DLLRec: ");
		// convertBST2DLLRec(node1);
		System.out.println("BST2DLLIt: ");
		System.out.println(convertBST2DLLIt(node1).val);
		;
	}

	// recursion to caculate node number
	public static int getNodeNumRe(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return (getNodeNumRe(root.left) + getNodeNumRe(root.right)) + 1;
	}

	public static void getNodeNum(TreeNode root) {
		int count = 1;
		if (root == null) {
			System.out.println("getNodeNum by Iteration: " + 0);
		}

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.removeFirst();
			if (cur.left != null) {
				queue.add(cur.left);
				count++;
			}
			if (cur.right != null) {
				queue.add(cur.right);
				count++;
			}
		}
		System.out.println("getNodeNum by Iteration: " + count);
	}

	public static int getTreeLevelRe(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getTreeLevelRe(root.left), getTreeLevelRe(root.right)) + 1;
	}

	public static void getTreeLevel(TreeNode root) {
		if (root == null) {
			System.out.println("getTreeLevel is: " + 0);
		}

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		int nextNode = 0;
		int level = 0;
		int currentNode = 1;

		while (!queue.isEmpty()) {
			TreeNode cur = queue.removeFirst();
			currentNode--;

			if (cur.left != null) {
				queue.add(cur.left);
				nextNode++;
			}

			if (cur.right != null) {
				queue.add(cur.right);
				nextNode++;
			}

			if (currentNode == 0) {
				currentNode = nextNode;
				nextNode = 0;
				level++;
			}
		}

		System.out.println("getTreeLevel by Iteration: " + level);
	}

	public static int getTreeLevel_Stack(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode cur = null;
		int level = 0;
		int NextNode = 0;
		int CurrentNode = 1;
		while (!stack.isEmpty()) {
			cur = stack.pop();
			CurrentNode--;
			if (cur.right != null) {
				stack.push(cur.right);
				NextNode++;
			}
			if (cur.left != null) {
				stack.push(cur.left);
				NextNode++;
			}

			if (CurrentNode == 0) {
				CurrentNode = NextNode;
				NextNode = 0;
				level++;
			}

		}
		return level;

	}

	public static void preOrderRe(TreeNode root) {
		if (root == null) {
			return;
		}

		System.out.println(root.val);
		preOrderRe(root.left);
		preOrderRe(root.right);
	}

	public static void preOrderIt(TreeNode root) {
		if (root == null) {
			System.out.println("The root of tree is null");
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);

		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			System.out.println(cur.val);

			if (cur.right != null) {
				stack.add(cur.right);
			}
			if (cur.left != null) {
				stack.add(cur.left);
			}
		}
	}

	public static void inOrderRe(TreeNode root) {
		if (root == null) {
			return;
		}

		inOrderRe(root.left);
		System.out.println(root.val);
		inOrderRe(root.right);
	}

	private static void inOrderIt(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;

		while (true) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			if (stack.isEmpty()) {
				break;
			}
			cur = stack.pop();
			System.out.println(cur.val + " ");
			cur = cur.right;
		}
	}

	public static void posOrderRe(TreeNode root) {
		if (root == null) {
			return;
		}

		posOrderRe(root.left);
		posOrderRe(root.right);
		System.out.println(root.val);
	}

	public static void posOrderIt(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> swith = new Stack<TreeNode>();
		Stack<TreeNode> print = new Stack<TreeNode>();
		swith.push(root);

		while (!swith.isEmpty()) {
			TreeNode cur = swith.pop();
			print.push(cur);

			if (cur.left != null) {
				swith.push(cur.left);
			}
			if (cur.right != null) {
				swith.push(cur.right);
			}

		}

		while (!print.isEmpty()) {
			System.out.println(print.pop().val + " ");
		}
	}

	public static void levelTravelRe(TreeNode root) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		dfs(root, 0, ret);
		System.out.println(ret);
	}

	public static void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> ret) {
		if (root == null) {
			return;
		}
		if (level >= ret.size()) {
			ret.add(new ArrayList<Integer>());
		}
		ret.get(level).add(root.val);
		dfs(root.left, level + 1, ret);
		dfs(root.right, level + 1, ret);
	}

	public static void levelTravelIt(TreeNode root) {
		if (root == null) {
			return;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode cur = queue.pop();
			System.out.println(cur.val + " ");
			if (cur.left != null) {
				queue.add(cur.left);
			}
			if (cur.right != null) {
				queue.add(cur.right);
			}
		}

	}

	private static TreeNode convertBST2DLLRec(TreeNode root) {
		return convertBST2RecHelp(root)[0];
	}

	private static TreeNode[] convertBST2RecHelp(TreeNode root) {
		TreeNode[] ret = new TreeNode[2];
		ret[0] = null;
		ret[1] = null;

		if (root == null) {
			return null;
		}

		if (root.left != null) {
			TreeNode left[] = convertBST2RecHelp(root.left);
			left[1].right = root;// 将左子树的尾节点连接到根
			root.left = left[1];

			ret[0] = left[0];// 将左子树的尾节点连接到left
		} else {
			ret[0] = root;// 将左子树的尾节点连接到根
		}

		if (root.right != null) {
			TreeNode right[] = convertBST2RecHelp(root.right);
			right[0].left = root;
			root.right = right[0];

			ret[1] = right[1];
		} else {
			ret[1] = root;
		}
		return ret;
	}

	private static TreeNode convertBST2DLLIt(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode head = null;
		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode pre = null;

		while (true) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			if (stack.isEmpty()) {
				break;
			}

			cur = stack.pop();

			if (head == null) {
				head = cur;
			}

			pre = cur.left;
			if (pre != null) {
				pre.right = cur;
			}
			System.out.println(cur.val);
			cur = cur.right;
			// pre = cur;//?
		}
		return root;
	}

	private static int getNodeNumKthLevelRec(TreeNode root, int k) {
		if (root == null || k < 1) {
			return 0;
		}
		if (k == 1) {
			return 1;
		}

		return getNodeNumKthLevelRec(root.left, k - 1) + getNodeNumKthLevelRec(root.right, k - 1);
	}

	private static int getNodeNumKthLevelIt(TreeNode root, int k) {
		if (root == null || k < 1) {
			return 0;
		}

		if (k == 1) {
			return 1;
		}

		int level = 1;
		int count = 1;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode cur = null;
		queue.push(root);

		while (!queue.isEmpty() && level <= k) {
			cur = queue.pop();
			if (cur.left != null) {
				queue.push(cur.left);
				count++;
			}
			if (cur.right != null) {
				queue.push(cur.right);
				count++;
			}
			level++;
		}
		return level;
	}

	private static int getNodeNumLeafRe(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}
		return getNodeNumLeafRe(root.left) + getNodeNumLeafRe(root.right);
	}

	private static int getNodeNumLeafIt(TreeNode root) {
		int count = 0;
		if (root == null) {
			return 0;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode cur = null;

		while (!stack.isEmpty()) {
			cur = stack.pop();
			if (cur.left == null || cur.right == null) {
				count++;
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
			if (cur.right != null) {
				stack.push(cur.right);
			}

		}
		return count;
	}

	private static boolean isSameRe(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}
		return ((root1.val == root2.val) && isSameRe(root1.left, root2.left) && isSameRe(root1.right, root2.right));
	}

	private static boolean isSameIt(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		if (root1.val != root2.val) {
			return false;
		}

		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root1);
		stack2.push(root2);
		TreeNode cur1, cur2;

		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			cur1 = stack1.pop();
			cur2 = stack2.pop();

			if (cur1.left != cur2.left || cur1.right != cur2.right) {
				return false;
			}

			if (cur1.left != null && cur2.left != null) {
				stack1.push(cur1.left);
				stack2.push(cur2.left);
			}
			if (cur1.right != null && cur2.right != null) {
				stack1.push(cur1.right);
				stack2.push(cur2.right);
			}

		}
		return true;
	}

	private static boolean isAVLRec(TreeNode root) {
		if (root == null) {
			return false;
		}

		if (!isAVLRec(root.left) || !isAVLRec(root.right)) {
			return false;
		}

		int Diff = Math.abs(getTreeLevelRe(root.left) - getTreeLevelRe(root.right));

		if (Diff > 1) {
			return false;
		}
		return true;
	}

	private static boolean isAVLIt(TreeNode root) {
		if (root == null) {
			return false;
		}

		return true;
	}

	// 10. 求二叉树的镜像（破坏和不破坏原来的树两种情况）：mirrorRec, mirrorCopyRec
	// a. destroy the original binary tree
	private static TreeNode mirrorRec_Destroy(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode temp = root.left;
		root.left = mirrorRec(root.right);
		root.right = mirrorRec(temp);

		return root;
	}

	// a. destroy the original binary tree
	private static TreeNode mirrorIt_Destroy(TreeNode root) {
		if (root == null) {
			return null;
		}

		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = null;
		TreeNode tmp = null;
		s.push(root);
		while (!s.isEmpty()) {
			cur = s.pop();
			tmp = cur.left;
			cur.left = cur.right;
			cur.right = tmp;

			if (cur.right != null) {
				s.push(cur.right);
			}

			if (cur.left != null) {
				s.push(cur.left);
			}
		}
		return root;
	}

	// b. not destroy the original binary tree
	private static TreeNode mirrorRec(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode rootCopy = new TreeNode(root.val);
		rootCopy.left = mirrorRec(root.right);
		rootCopy.right = mirrorRec(root.left);
		return rootCopy;
	}

	// b. not destroy the original binary tree
	private static TreeNode mirrorIt(TreeNode root) {
		if (root == null) {
			return null;
		}

		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<TreeNode> s_copy = new Stack<TreeNode>();
		s.push(root);

		TreeNode root_copy = new TreeNode(root.val);
		s_copy.push(root_copy);

		while (!s.isEmpty()) {
			TreeNode cur = s.pop();
			TreeNode cur_copy = s_copy.pop();

			if (cur.right != null) {
				s.push(cur.right);
				TreeNode copyleft = new TreeNode(cur.right.val);
				cur_copy.left = copyleft;
				s_copy.push(cur_copy.left);
			}
			if (cur.left != null) {
				s.push(cur.left);
				TreeNode copyright = new TreeNode(cur.left.val);
				cur_copy.right = copyright;
				s_copy.push(cur_copy.right);
			}
		}
		return root_copy;
	}

	private static boolean isMirrorRec(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}
		return (root1.val == root2.val && isMirrorRec(root1.left, root2.right) && isMirrorRec(root1.right, root2.left));
	}

	private static boolean isMirrorIt(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
		s1.push(root1);
		s2.push(root2);

		while (!s1.isEmpty() && !s2.isEmpty()) {
			TreeNode cur1 = s1.pop();
			TreeNode cur2 = s2.pop();

			if (cur1.val != cur2.val) {
				return false;
			}

			// tree1的左节点，tree2的右节点，可以同时不为空，也可以同时为空，否则返回false.
			TreeNode left1 = cur1.left;
			TreeNode right1 = cur1.right;
			TreeNode left2 = cur2.left;
			TreeNode right2 = cur2.right;

			if (left1 != null && right2 != null) {
				s1.push(left1);
				s2.push(right1);
			} else if (!(left1 == null && right2 == null)) {
				return false;
			}

			if (right1 != null && left2 != null) {
				s1.push(right1);
				s2.push(left2);
			} else if (!(right1 == null && left2 == null)) {
				return false;
			}

		}
		return true;
	}

	/**
	 * 求二叉树中两个节点的最低公共祖先节点 递归解法： （1）如果两个节点分别在根节点的左子树和右子树，则返回根节点
	 * （2）如果两个节点都在左子树，则递归处理左子树；如果两个节点都在右子树，则递归处理右子树
	 */
	private static TreeNode LACRe(TreeNode root, TreeNode n1, TreeNode n2) {
		TreeNode n = null;
		if (findNodeHelp(root.left, n1)) {
			if (findNodeHelp(root.right, n2)) {
				return root;
			} else {
				n = LACRe(root.left, n1, n2);
			}
		}

		if (findNodeHelp(root.right, n1)) {
			if (findNodeHelp(root.left, n2)) {
				return root;
			} else {
				n = LACRe(root.right, n1, n2);
			}
		}

		return n;
	}

	private static boolean findNodeHelp(TreeNode root, TreeNode n) {
		if (root == null || n == null) {
			return false;
		}
		if (root == n) {
			return true;
		}
		Boolean found = false;
		found = findNodeHelp(root.left, n);

		if (!found) {
			found = findNodeHelp(root.right, n);
		}
		return found;
	}

	private static TreeNode LACRec(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null) {
			return null;
		}

		if (root == n1 || root == n2) {
			return root;
		}

		TreeNode left = LACRec(root.left, n1, n2);
		TreeNode right = LACRec(root.right, n1, n2);

		// if(left == null && right == null){// this case is not necessary.
		// return null;
		// }else if(left == null){
		// return right;
		// }else if(right ==null){
		// return left;
		// }
		// return root;
		//
		if (left == null) {// if (left == null && right == null) return null;
							// this case was included.
			return right;
		} else if (right == null) {// if (left == null && right == null) return
									// null; this case was included.
			return left;
		}

		return root;
	}

	/**
	 * 非递归解法： 先求从根节点到两个节点的路径，然后再比较对应路径的节点就行，最后一个相同的节点也就是他们在二叉树中的最低公共祖先节点
	 */
	private static TreeNode LACIt(TreeNode root, TreeNode n1, TreeNode n2) {
		if (root == null && n1 == null && n2 == null) {
			return null;
		}

		ArrayList<TreeNode> path1 = new ArrayList<TreeNode>();
		boolean res1 = findNodePath(root, n1, path1);
		ArrayList<TreeNode> path2 = new ArrayList<TreeNode>();
		boolean res2 = findNodePath(root, n2, path2);

		TreeNode com = null;

		if (!res1 || !res2) {
			return null;
		}

		Iterator<TreeNode> it1 = path1.iterator();
		Iterator<TreeNode> it2 = path2.iterator();

		while (it1.hasNext() && it2.hasNext()) {
			if (it1.next() == it2.next()) {
				com = it1.next();
			} else {
				break;
			}
		}
		return com;
	}

	private static boolean findNodePath(TreeNode root, TreeNode n, ArrayList<TreeNode> path) {
		if (root == null || n == null) {
			return false;
		}
		path.add(root);

		boolean found = false;
		found = findNodePath(root.left, n, path);

		if (!found) {
			found = findNodePath(root.right, n, path);
		}

		if (found == false) {
			path.remove(root);
		}
		return found;
	}

	private static result getMaxDistanceRec(TreeNode root) {
		result ret = new result(-1, -1);
		if (root == null) {
			return ret;
		}

		result left = getMaxDistanceRec(root.left);
		result right = getMaxDistanceRec(root.right);

		ret.depth = Math.max(left.depth, right.depth) + 1;

		int crolen = left.depth + right.depth + 2;

		ret.maxDistance = Math.max(left.maxDistance, right.maxDistance);
		ret.maxDistance = Math.max(ret.maxDistance, crolen);
		return ret;
	}

	private static class result {
		int depth;
		int maxDistance;

		result() {
		}

		result(int depth, int maxDistance) {
			this.depth = depth;
			this.maxDistance = maxDistance;
		}
	}

	private static TreeNode rebuildBinaryTreeRec(List<Integer> preOrder, List<Integer> inOrder) {
		if (preOrder == null || inOrder == null) {
			return null;
		}

		if (preOrder.size() == 0 || inOrder.size() == 0) {
			return null;
		}
		TreeNode tree = new TreeNode(preOrder.get(0));

		List<Integer> preOrderLeft;
		List<Integer> preOrderRight;
		List<Integer> inOrderLeft;
		List<Integer> inOrderRight;

		int rootIndex = inOrder.indexOf(preOrder.get(0));

		preOrderLeft = preOrder.subList(1, rootIndex + 1);
		preOrderRight = preOrder.subList(rootIndex + 1, preOrder.size());

		inOrderLeft = inOrder.subList(0, rootIndex);
		inOrderRight = inOrder.subList(rootIndex + 1, inOrder.size());

		return tree;
	}

	private static boolean isCompleteBinaryTree(TreeNode root) {
		if (root == null) {
			return false;
		}

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		boolean mustNoChild = false;
		boolean result = true;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.removeFirst();
			if (mustNoChild) {
				if (cur.left != null || cur.right != null) {
					result = false;
					break;
				}
			} else {
				if (cur.left != null && cur.right != null) {
					queue.add(cur.left);
					queue.add(cur.right);
				} else if (cur.left != null && cur.right == null) {
					mustNoChild = true;
					queue.add(cur.left);
				} else if (cur.left == null && cur.right != null) {
					result = false;
					break;
				} else {
					mustNoChild = true;
				}
			}
		}
		return result;
	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

}

