package Algorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import entities.TreeNode;

/**
 * Get the list of list of keys in a given binary tree layer by layer. Each
 * layer is represented by a list of keys and the keys are traversed from left
 * to right. Examples 5 / \ 3 8 / \ \ 1 4 11 the result is [ [5], [3, 8], [1, 4,
 * 11] ] Corner Cases What if the binary tree is null? Return an empty list of
 * list in this case. How is the binary tree represented? We use the level order
 * traversal sequence with a special symbol "#" denoting the null node. For
 * Example: The sequence [1, 2, 3, #, #, 4] represents the following binary
 * tree: 1 / \ 2 3 / 4
 *
 */
public class GetKeysInBinaryTreeLayerByLayer_33 {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(11);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;

		List<List<Integer>> result = GetKeysInBinaryTreeLayerByLayer(t1);
		System.out.println(result.toString());
	}

	public static List<List<Integer>> GetKeysInBinaryTreeLayerByLayer(TreeNode root) {
		List<List<Integer>> result = new ArrayList();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> layer = new LinkedList<TreeNode>();
		layer.add(root);
		while (!layer.isEmpty()) {
			int size = layer.size();
			List<Integer> curLayer = new LinkedList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode cur = layer.poll();
				curLayer.add(cur.key);
				if (cur.left != null) {
					layer.add(cur.left);
				}
				if (cur.right != null) {
					layer.add(cur.right);
				}
			}
			result.add(curLayer);
		}
		return result;
	}

}
