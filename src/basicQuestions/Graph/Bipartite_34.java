package Algorithm.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Determine if an undirected graph is bipartite. A bipartite graph is one in
 * which the nodes can be divided into two groups such that no nodes have direct
 * edges to other nodes in the same group.
 * 
 * Examples 1 -- 2 / 3 -- 4 is bipartite (1, 3 in group 1 and 2, 4 in group 2).
 * 
 * 1 -- 2 / | 3 -- 4 is not bipartite.
 * 
 * Assumptions The graph is represented by a list of nodes, and the list of
 * nodes is not null.
 */
public class Bipartite_34 {
	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);

		List<GraphNode> neighbors1 = new ArrayList<>();
		neighbors1.add(n2);
		n1.neighbors = neighbors1;
		List<GraphNode> neighbors2 = new ArrayList<>();
		neighbors2.add(n1);
		neighbors2.add(n3);
		n2.neighbors = neighbors2;
		List<GraphNode> neighbors3 = new ArrayList<>();
		neighbors3.add(n2);
		neighbors3.add(n4);
		n3.neighbors = neighbors3;
		List<GraphNode> neighbors4 = new ArrayList<>();
		// neighbors4.add(n2);
		neighbors4.add(n3);
		n3.neighbors = neighbors4;

		// @TODO how to build a graph? there is an issue for n3. do a debug test.
		List<GraphNode> graph = new ArrayList<GraphNode>();
		graph.add(n1);
		graph.add(n2);
		graph.add(n3);
		graph.add(n4);
		System.out.println(isBitpartite(graph));
	}

	public static boolean isBitpartite(List<GraphNode> graph) {
		HashMap<GraphNode, Integer> visited = new HashMap();
		for (GraphNode node : graph) {
			if (!BST(node, visited)) {
				return false;
			}
		}
		return true;
	}

	public static boolean BST(GraphNode node, HashMap<GraphNode, Integer> visited) {
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.offer(node);
		visited.put(node, 0);
		while (!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			int curGroup = visited.get(cur);
			int neiGroup = curGroup == 0 ? 1 : 0;
			for (GraphNode nei : cur.neighbors) {
				if (!visited.containsKey(nei)) {
					queue.offer(nei);
					visited.put(nei, neiGroup);
				} else if (visited.get(nei) != neiGroup) {
					return false;
				}
			}
		}

		return true;
	}
}
