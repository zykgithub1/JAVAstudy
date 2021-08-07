package demo_2021_8_7_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class graphAlgorithms {
	public static void main(String[] args) {
		int[][] matrix = new int[5][5];
		Graph graph = twoDimensionalArrTransformGraph.createGraph(matrix);

	}

	public static void bfs(Node node) {
		if (node == null) {
			return;
		}
		Set<Node> set = new HashSet();
		Queue<Node> que = new LinkedList();
		que.add(node);
		set.add(node);
		while (!que.isEmpty()) {
			node = que.poll();
			System.out.println(node.value);
			for (Node next : node.nexts) {
				if (!set.contains(next)) {
					set.add(next);
					que.add(next);
				}
			}
		}
	}

	public static void dfs(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> s = new Stack();
		Set<Node> set = new HashSet<>();
		s.add(node);
		set.add(node);
		while (!s.isEmpty()) {
			node = s.pop();
			for (Node next : node.nexts) {
				if (!set.contains(next)) {
					set.add(next);
					System.out.println(next.value);
					s.push(node);
					s.push(next);
					break;
				}
			}
		}
	}

	public static List<Node> topologicSort(Graph graph) {
		HashMap<Node, Integer> inMap = new HashMap<>();
		Queue<Node> zeroInQue = new LinkedList<>();
		for (Node cur : graph.nodes.values()) {
			inMap.put(cur, cur.in);
			if (cur.in == 0) {
				zeroInQue.offer(cur);
			}
		}
		List<Node> ans = new ArrayList();
		while (!zeroInQue.isEmpty()) {
			Node cur = zeroInQue.poll();
			ans.add(cur);
			for (Node next : cur.nexts) {
				inMap.put(next, inMap.get(next) - 1);
				if (inMap.get(next) == 0) {
					zeroInQue.offer(next);
				}
			}
		}
		return ans;
	}

}
