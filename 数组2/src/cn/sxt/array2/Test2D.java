package cn.sxt.array2;

public class Test2D {
	public static void main(String[]a) {
		//int[] a1=new int[3];
		int[][] a1 =new int[3][];
		a1[0]=new int[]{20,30};
		a1[1]=new int[] {12,111};
		a1[2]=new int[] {50,60};
		System.out.println(a1[0][1]);
		int[][] b= {
				{20,30,40},
				{11,111,1111},
				{22,33,44,55}
		};
		System.out.println(b[1][2]);
	}

}
