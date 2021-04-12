package algorithm;

public class Kruskal {
	private int degeNum=0;;
	private char[]vertexs;
	private int[][]matrix;
	public static final int INF=999;
	
	
	public static void main(String[] args) {
		char[]vertex= {'A','B','C','D','E','F','G'};
		int[][]matrix= {
				{0,12,INF,INF,INF,16,14},
				{12,0,10,INF,INF,7,INF},
				{INF,10,0,3,5,6,INF},
				{INF,INF,3,0,4,INF,INF},
				{INF,INF,5,4,0,2,8},
				{16,7,6,INF,2,0,9},
				{14,INF,INF,INF,8,9,0},
		};
		Kruskal kruskal=new Kruskal(vertex, matrix);
		kruskal.print();
		
		
	}


	public Kruskal(char[] vertexs, int[][] matrix) {
		int vlen=vertexs.length;
		this.vertexs=new char[vertexs.length];
		for(int i=0;i<vertexs.length;i++) {
			this.vertexs[i]=vertexs[i];
		}
		
		this.matrix=new int[vlen][vlen];
		for(int i=0;i<vlen;i++) {
			for(int j=0;j<vlen;j++) {
				if(matrix[i][j]!=INF) {
					this.degeNum++;
				}
				this.matrix[i][j]=matrix[i][j];
			}
		}
	}
	
	public void print() {
		System.out.println("ÁÚ½Ó¾ØÕó");
		for(int i=0;i<vertexs.length;i++) {
			for(int j=0;j<vertexs.length;j++) {
				System.out.printf("%d\t",this.matrix[i][j]);
			}
			System.out.println();
		}
		
	}
}
