package PTA.demo6_2;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int bag=sc.nextInt();
		int[]w=new int[N];
		int[]v=new int[N];
		for(int i=0;i<N;i++) {
			w[i]=sc.nextInt();
			v[i]=sc.nextInt();
		}
		System.out.println(process(w,v,bag));
		
	}

	private static int process(int[] w, int[] v, int bag) {
		int dp[][]=new int[w.length+1][bag+1];
		for(int i=1;i<=w.length;i++) {
			for(int j=1;j<=bag;j++) {
				if(j>=w[i-1]) {
					dp[i][j]=Math.max(dp[i-1][j], v[i-1]+dp[i-1][j-w[i-1]]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[v.length][bag];
	}

}
