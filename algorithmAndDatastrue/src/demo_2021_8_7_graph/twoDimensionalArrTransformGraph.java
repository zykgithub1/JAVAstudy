package demo_2021_8_7_graph;

public class twoDimensionalArrTransformGraph {
	public static Graph createGraph(int[][]matrix) {
		Graph graph=new Graph();
		int n=matrix.length;
		for(int i=0;i<n;i++) {
			int from=matrix[i][0];
			int to=matrix[i][1];
			int weight=matrix[i][2];
			if(!graph.nodes.containsKey(from)) {
				graph.nodes.put(from, new Node(from));
			}
			if(!graph.nodes.containsKey(to)) {
				graph.nodes.put(to, new Node(to));
			}
			Node fromNode=graph.nodes.get(from);
			Node toNode=graph.nodes.get(to);
			Edge edge=new Edge(weight, fromNode, toNode);
			fromNode.nexts.add(toNode);
			fromNode.out++;
			toNode.in++;
			graph.edges.add(edge);
			fromNode.edges.add(edge);
		}
		return graph;
	}

}
