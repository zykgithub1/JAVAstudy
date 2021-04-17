package algorithm;

public class floyedAlgorithm {
	public static final int N=999;
	public static void main(String[] args) {
		char[]vertex="ABCDEFG".toCharArray();
		int[][]matrix=new int[vertex.length][vertex.length];
		matrix[0]=new int[] {0,5,7,N,N,N,2};
		matrix[1]=new int[] {5,0,N,9,N,N,3};
		matrix[2]=new int[] {7,N,0,N,8,N,N};
		matrix[3]=new int[] {N,9,N,0,N,4,N};
		matrix[4]=new int[] {N,N,8,N,0,5,4};
		matrix[5]=new int[] {N,N,N,4,5,0,6};
		matrix[6]=new int[] {2,3,N,N,4,6,0};
		FGraph graph=new FGraph(vertex.length, matrix, vertex);
		graph.floyed();
		graph.show();
	}
}
class FGraph{
	private char[]vertex;
	private int[][]dis;
	private int[][]pre;
	public FGraph(int length,int[][]matrix,char[]vertex) {
		this.vertex=vertex;
		dis=matrix;
		pre=new int[length][length];
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				pre[i][j]=i;
			}
		}
	}
	
	public void show() {
		for(int i=0;i<vertex.length;i++) {
			for(int j=0;j<vertex.length;j++) {
				System.out.printf("%9c    ",vertex[pre[i][j]]);
			}
			System.out.println();
			for(int k=0;k<dis.length;k++) {
				System.out.print("   ("+vertex[i]+"->"+vertex[k]+" "+dis[i][k]+")"+" ");
			}
			System.out.println();
			System.out.println();
		}
	}
	
	public void floyed() {
		for(int k=0;k<vertex.length;k++) {
			for(int i=0;i<vertex.length;i++) {
				for(int j=0;j<vertex.length;j++) {
					if(dis[i][k]+dis[k][j]<dis[i][j]) {
						dis[i][j]=dis[i][k]+dis[k][j];
						pre[i][j]=pre[k][j];
					}
				}
			}
		}
	}
}
