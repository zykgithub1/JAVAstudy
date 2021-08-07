package demo_2021_8_7_graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Kruskal {
	public static class MySets {
		public Map<Node, List<Node>> setMap;

		public MySets(List<Node> allNodes) {
			setMap = new HashMap<>();
			for (Node node : allNodes) {
				List<Node> set = new ArrayList<>();
				set.add(node);
				setMap.put(node, set);
			}
		}

		public boolean isSameSet(Node from, Node to) {
			List<Node> fromSet = setMap.get(from);
			List<Node> toSet = setMap.get(to);
			return fromSet == toSet;
		}

		public void union(Node from, Node to) {
			List<Node> fromSet = setMap.get(from);
			List<Node> toSet = setMap.get(to);
			for (Node node : toSet) {
				fromSet.add(node);
				setMap.put(node, fromSet);
			}
		}

		public static Set<Edge> kruskalMST(Graph graph) {
			MySets unionFind = new MySets(new ArrayList<Node>(graph.nodes.values()));
			PriorityQueue<Edge> que = new PriorityQueue<>(new Comparator<Edge>() {
				public int compare(Edge a, Edge b) {
					return a.weight - b.weight;
				}
			});
			Set<Edge> ans = new HashSet();
			for (Edge edge : graph.edges) {
				que.add(edge);
			}
			while (!que.isEmpty()) {
				Edge edge = que.poll();
				if (!unionFind.isSameSet(edge.from, edge.to)) {
					ans.add(edge);
					unionFind.union(edge.from, edge.to);
				}
			}
			return ans;
		}
	}

}
