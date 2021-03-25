package DP;

import java.util.Scanner;

public class maxSequenceSum {
	public static void main(String[] args) {
		int n=0;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int res=dp(arr,arr.length-1);
		System.out.println(res);
	}


	private static int dp(int[] arr, int i) {
		int[]dp=new int[i+1];
		dp[0]=arr[0];
		int max=0;
		for(int j=1;j<i;j++) {
			dp[j]=Math.max(dp[j-1]+arr[j],arr[j]);
			max=Math.max(max, dp[j]);
		}
		return max;
	}
}
