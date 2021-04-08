package algorithm;

public class bagQuestion {
	public static void main(String[] args) {
		int w[]= {1,4,3};
		int v[]= {1500,3000,2000};
		int bag=4;
		int maxValue=dpway(w,v,bag);
		System.out.println(maxValue);
	}

	private static int dpway(int[] w, int[] v, int bag) {
		int dp[][]=new int[v.length+1][bag+1];
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<=bag;j++) {
				if(j>=w[i-1]) {
					dp[i][j]=Math.max(dp[i-1][j],  v[i-1]+dp[i-1][j-w[i-1]]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[v.length][bag];
	}

}
