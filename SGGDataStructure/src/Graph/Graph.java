package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

	private ArrayList<String> vertexList;
	private int[][] edges;
	private int numOfEdges;
	private boolean[] isVisited;

	public static void main(String[] args) {
		int n=5;
		String vertexValue[]= {"A","B","C","D","E"};
		Graph graph=new Graph(n);
		for(String a:vertexValue) {
			graph.insetVextex(a);
		}
		//A-B  A-C B-C  B-D  B-E
		graph.insetEdge(0, 1, 1);
		graph.insetEdge(0, 2, 1);
		graph.insetEdge(1, 2, 1);
		graph.insetEdge(1, 3, 1);
		graph.insetEdge(1, 4, 1);
		graph.showMatrix();
		graph.dfs(0);

	}

	public void showMatrix() {
		for (int[] a : edges) {
			System.err.println(Arrays.toString(a));
		}
	}

	public Graph(int n) {
		edges = new int[n][n];
		vertexList = new ArrayList<>(n);
		numOfEdges = 0;
		isVisited=new boolean[n];
	}
	
	public int getFirstNeighbor(int index) {
		for(int i=0;i<vertexList.size();i++) {
			if(edges[index][i]!=0) {
				return i;
			}
		}
		return -1;
	}
	//根据前一个返回的邻接点的下表返回下一个临接点的下标
	//i=v2+1 !!!!你没加1
	public int getNextNeighbor(int v1,int v2) {
		for(int i=v2+1;i<vertexList.size();i++) {
			if(edges[v1][i]!=0) {
				return i;
			}
		}
		return -1;
	}
	
	private void dfs(int i) {
		if(!isVisited[i]) {
			System.out.print(vertexList.get(i)+"->");
			isVisited[i]=true;
		}
		int next=getFirstNeighbor(i);
		while(next!=-1) {
			if(!isVisited[next]) {
				dfs(next);
			}
			next=getNextNeighbor(i, next);
		}
	}
	
	public void dfs() {
		for(int i=0;i<vertexList.size();i++) {
			if(!isVisited[i]) {
				dfs(i);
			}
		}
	}

	public int getNumofEdges() {
		return numOfEdges;
	}

	public int getVertexValue() {
		return vertexList.size();
	}

	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}

	public String getVertex(int index) {
		return vertexList.get(index);
	}

	public void insetEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}

	public void insetVextex(String vex) {
		vertexList.add(vex);
	}

}
