package algorithm;

import java.util.Arrays;

public class dijkstra {
	public static final int N=999;
	public static void main(String[] args) {
		char[]vertex;
		String str="ABCDEFG";
		vertex=str.toCharArray();
		int len=vertex.length;
		int[][]matrix=new int[len][len];
		matrix[0]=new int[] {N,5,7,N,N,N,2};
		matrix[1]=new int[] {5,N,N,9,N,N,3};
		matrix[2]=new int[] {7,N,N,N,8,N,N};
		matrix[3]=new int[] {N,9,N,N,N,4,N};
		matrix[4]=new int[] {N,N,8,N,N,5,4};
		matrix[5]=new int[] {N,N,N,4,5,N,6};
		matrix[6]=new int[] {2,3,N,N,4,6,N};
		DGraph graph=new DGraph(vertex, matrix);
		graph.showGraph();
		graph.dijkstra(6);
		graph.showDij();
		
	}

}

class DGraph{
	private char[]vertex;
	private int[][]matrix;
	private VisitedVertex vv;
	public DGraph(char[] vertex, int[][] matrix) {
		super();
		this.vertex = vertex;
		this.matrix = matrix;
	}
	
	public void showGraph() {
		for(int[]link:matrix) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	public void dijkstra(int index) {
		vv=new VisitedVertex(vertex.length, index);
		updata(index);
		for(int j=1;j<vertex.length;j++) {
			index=vv.updataArr();
			updata(index);
		}
	}
	
	public void showDij() {
		vv.show();
	}
	
	public void updata(int index) {
		int len=0;
		for(int j=0;j<matrix[index].length;j++) {
			len=vv.getDis(index)+matrix[index][j];
			if(!vv.in(j)&&vv.getDis(j)>len) {
				vv.updateDis(j, len);
				vv.updataPre(j, index);
			}
		}
	}
}
class VisitedVertex{
	//记录各点是否访问过
	public int[]already_arr;
	//每一个下表对应的值为第一个顶点的下表
	public int[]pre_visited;
	//记录出发顶点到其他顶点的距离
	public int[]dis;
	/**
	 * 
	 * @param len     顶点个数
	 * @param index   出发顶点
	 */
	public VisitedVertex(int len,int index) {
		super();
		already_arr=new int[len];
		this.pre_visited=new int[len];
		this.dis=new int[len];
		already_arr[index]=1;
		Arrays.fill(dis, dijkstra.N);
		this.dis[index]=0;
	}
	
	public boolean in(int index) {
		return already_arr[index]==1;
	}
	/**
	 * 更新出发顶点到Index点的距离
	 * @param index
	 * @param len
	 */
	public void updateDis(int index,int len) {
		dis[index]=len;
	}
	/**
	 * 更新Pre这个顶点的前驱顶点为index
	 * @param pre
	 * @param index
	 */
	public void updataPre(int pre,int index) {
		pre_visited[pre]=index;
	}
	
	public int getDis(int index) {
		return dis[index];
	}
	
	public int updataArr() {
		int index=0;
		int min=dijkstra.N;
		for(int i=0;i<already_arr.length;i++) {
			if(already_arr[i]==0&&min>getDis(i)) {
				min=getDis(i);
				index=i;
			}
		}
		already_arr[index]=1;
		return index;
	}
	
	public void show() {
		for(int i:already_arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i:pre_visited) {
			System.out.print(i+" ");
		}
		System.out.println();
		for(int i:dis) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	
}
