package algorithm;

import java.util.Arrays;

public class primAlgorithm {
	public static void main(String[] args) {
		char[]data= {'A','B','C','D','E','F','G'};
		int verxs=data.length;
		int[][]matrix= {
				{999,5,7,999,999,999,2},
				{5,999,999,9,999,999,3},
				{7,999,999,999,8,999,999},
				{999,9,999,999,999,4,999},
				{999,999,8,999,999,5,4},
				{999,999,999,4,5,999,6},
				{2,3,999,999,4,6,999},
		};
		Graph graph=new Graph(verxs);
		minTree minTree=new minTree();
		minTree.creatGraph(graph, verxs, data, matrix);
		minTree.showGraph(graph);
		minTree.prim(graph, 1);
		
	}

}
class minTree{
	/**
	 * 
	 * @param graph  图对象
	 * @param verxs  图的点数
	 * @param data   图的边集
	 * @param matrix 邻接矩阵
	 */
	
	public void creatGraph(Graph graph,int verxs,char[]data,int[][]matrix) {
		for(int i=0;i<verxs;i++) {
			graph.data[i]=data[i];
			for(int j=0;j<verxs;j++) {
				graph.martrix[i][j]=matrix[i][j];
			}
		}
	}
	
	public void showGraph(Graph graph) {
		for(int[]link:graph.martrix) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	public void prim(Graph graph,int start) {
		int[]visited=new int[graph.verxs];
		visited[start]=1;
		int h1=-1;int h2=-1;
		int minWeight=Integer.MAX_VALUE;
		for(int k=1;k<graph.verxs;k++) {
			for(int i=0;i<graph.verxs;i++) {
				for(int j=0;j<graph.verxs;j++) {
					if(visited[i]==1&&visited[j]==0&&graph.martrix[i][j]<minWeight) {
						minWeight=graph.martrix[i][j];
						h1=i;h2=j;
					}
				}
			}
			visited[h2]=1;
			minWeight=Integer.MAX_VALUE;
			System.out.println("<"+graph.data[h1]+", "+graph.data[h2]+"权值为"+" "+graph.martrix[h1][h2]+">");
		}
	}
	
	
}
class Graph{
	int verxs;
	char[]data;
	int[][]martrix;
	public Graph(int verxs) {
		super();
		this.verxs = verxs;
		data=new char[verxs];
		martrix=new int[verxs][verxs];
	}
	
}
