package demo_2021_8_7_graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class PrimMST {
	public static Set<Edge> prim(Graph graph) {
		PriorityQueue<Edge> que = new PriorityQueue<Edge>((a, b) -> {
			return a.weight - b.weight;
		});
		Set<Node> seen = new HashSet();
		Set<Edge> result = new HashSet<>();
		for (Node node : graph.nodes.values()) {
			if (!seen.contains(node)) {
				seen.add(node);
				for (Edge edge : node.edges) {
					que.offer(edge);
				}
				while (!que.isEmpty()) {
					Edge edge = que.poll();
					Node toNode = edge.to;
					if (!seen.contains(toNode)) {
						seen.add(toNode);
						result.add(edge);
						for (Edge nextEdge : toNode.edges) {
							que.add(nextEdge);
						}
					}
				}
			}
		}
		return result;
	}

}
