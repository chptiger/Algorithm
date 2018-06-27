
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

http://www.makuiyu.cn/2015/03/LeetCode_95.%20Unique%20Binary%20Search%20Trees%20II/ 

要生成1...n的所有结构不同的二叉搜索树，可依次令根节点为1...n。
假设当前根节点为i，则其左子树为1...i-1的所有结构不同的二叉搜索树，右子树为i+1...n的所有结构不同的二叉搜索树。
因此，左右子树分别转化为两个子问题了，可以选择递归处理该子问题即可。

由于问题可以转化为子问题进行求解，因此可以选择记录已求解的子问题。
记录存储的时候，为了降低空间复杂度，不采用dp[i][j]来存储i...j的所有情况，而采用dp[len]存储长度为len的所有情况，即1...len的所有情况。
这样，在需要i+1...r的子问题解的情况时，需要对1...r-i的节点数值加上偏移i即可，即对dp[r-i]的所有情况加上偏移i。
TreeNode * clone(TreeNode *root, int offset)函数的功能就是对root树中节点的数值进行加上偏移offset处理


http://www.cnblogs.com/EdwardLiu/p/3960079.html
第一次遇到这种让你construct a BST的问题，而且结果并不是建立一个ArrayList<ArrayList<Integer>>型的，而是建立一个ArrayList<TreeNode>型的，
这我就不知道怎么搞了，看了别人的才发现原来只要把几种方案的root放在最终的结果ArrayList<TreeNode>里面就好了，每个root有自己的left & right，但是不用放在这个ArrayList里面，只要指定好就可以了。
Note that current node needed to be created for each possible sub-tree setting. 

以上是本问题的难点和不熟悉的地方，本题的思路参考了http://blog.csdn.net/linhuanmars/article/details/24761437

 choose one number i from n as root, pass all the numbers less than i to recursive call to construct the current root's left sub-tree, 
 pass all the numbers greater than i to the recursive call to construct the current root's right sub-tree.  
 Take n=5 for example, when we choose root node = 3, then put 1,2 to recursive call to construct root node's left sub-tree, 
 and put 4,5 to recursive call to contract root's right subtree.

这里helper(int left, int right)函数的作用是：
用left到right这几个数来构造树的当前这一层，根节点i 依次从[left, right]里取值，左子树的构造通过递归helper(left, i-1)函数, 
右子树的构造通过递归helper(i+1, right)，然后返回值这样取：对于每一个（根节点，左子树，右子树）的组合模式，添加一次根节点进结果集。
其实这样的结果集就是以[left, right]所有数字构成的所有BST的根的集合
*/
import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree2_95 {
	public static void main(String[] args) {
		int n = 3;
		List<TreeNode> res = generateTrees(n);
		
		for( int i = 0; i < res.size(); i++){
			System.out.println(res.get(i).val);
		}
		
	}

	public static List<TreeNode> generateTrees(int n) {

		return genTrees(1, n);
	}

	public static List<TreeNode> genTrees(int start, int end) {

		List<TreeNode> list = new ArrayList<TreeNode>();

		if (start > end) {
			list.add(null);// reason of adding NULL is because OJ uses this
							// format to store trees
			return list;
		}

		if (start == end) {
			list.add(new TreeNode(start));
			return list;
		}

		List<TreeNode> left, right;
		// 遍历1~n，当它为根节点的情况
		for (int i = start; i <= end; i++) {

			left = genTrees(start, i - 1);
			right = genTrees(i + 1, end);
			// i is current tree node, left stores left child node, right stores
			// right child node
			// all nodes in left is smaller than i, all nodes in right is larger
			// than i
			// if n == 2;
			// 1st iteration: left null, right 2;
			// 2nd iteration: left 1, right null;
			for (TreeNode lnode : left) {
				for (TreeNode rnode : right) {
					TreeNode root = new TreeNode(i);
					root.left = lnode;
					root.right = rnode;
					list.add(root);
					System.out.println("root value: "+root.val);
				}
			}

		}
		
		return list;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
