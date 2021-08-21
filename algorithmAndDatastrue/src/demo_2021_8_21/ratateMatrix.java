package demo_2021_8_21;

public class ratateMatrix {
	public static void rotate(int[][]matrix) {
		int tl=0;
		int tr=0;
		int dl=matrix.length-1;
		int dr=matrix[0].length-1;
		while(tl<dl) {
			rotateEdge(matrix,tl++,tr++,dl--,dr--);
		}
	}

	private static void rotateEdge(int[][] matrix, int a, int b, int c, int d) {
		int temp=0;
		for(int i=0;i<d-b;i++) {
			temp=matrix[a][b+i];
			matrix[a][b+i]=matrix[a+i][d];
			matrix[a+i][d]=matrix[c][d-i];
			matrix[c][d-i]=matrix[d-i][b];
			matrix[d-i][b]=temp;
		}
		
	}
	

}
