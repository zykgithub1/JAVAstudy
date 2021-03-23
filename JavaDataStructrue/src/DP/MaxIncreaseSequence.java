package DP;

import java.util.Arrays;

public class MaxIncreaseSequence {
	public static void main(String[] args) {
		int arr[] = { 13,7,9,16,38,24,37,18,44,19,21,22,63,15 };
		int res = dpways(arr);
		int res2=dpways2(arr);
		System.out.println(res);
		System.out.println(res2);

	}
	private static int dpways2(int[] arr) {
		return process(arr,arr.length-1);
	}
	private static int process(int[] arr, int i) {
		if(i==1) {
			return 0;
		}
		if(arr[i]>=arr[i-1]) {
			return process(arr,i-1)+1;
		}else {
			return process(arr, i-1);
		}
	}
	// Ë¼Â·£º//19, 22, 5, 18, 2, 11, 29, 16, 1, 6, 21, 21, 25,3
	// 0£¬ 1£¬ 2£¬3£¬ 4£¬ 5£¬ 6£¬ 7£¬8£¬ 9£¬10£¬11£¬12 13

	private static int dpways(int[] arr) {
		int[]dp=new int[arr.length];
		dp[0]=1;
		int ans=0;
		for(int i=1;i<=arr.length-1;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>=arr[j]) {
					dp[i]=Math.max(dp[j], dp[i]);
				}
			}
			dp[i]++;
			//dp[i]++;
			ans=Math.max(ans, dp[i]);
		}
		System.out.println(Arrays.toString(dp));
		return ans;
	}

	

}
