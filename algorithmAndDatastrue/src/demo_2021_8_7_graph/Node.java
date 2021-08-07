package demo_2021_8_7_graph;

import java.util.ArrayList;

public class Node {
	public int value;
	public int in;
	public int out;
	public ArrayList<Node> nexts;
	public ArrayList<Edge> edges;

	public Node(int value) {
		super();
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList();
		edges = new ArrayList();
	}

}
