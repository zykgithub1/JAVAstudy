package DP;

import java.util.Arrays;
import java.util.Scanner;

public class numsTower {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][n+1];
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				arr[i][j]=-1;
//			}
//		}
		for (int row = 0; row < n; row++) {
			for (int col = 0; col <= row; col++) {
				arr[row][col] = sc.nextInt();
			}
		}
		int res = dp(arr, 0, 0);
		int res2=dpway(arr);
		//System.out.println(res);
//		System.out.println();
//		show(arr);
//		System.out.println();
		System.out.println(res);
		System.out.println(res2);
		sc.close();
	}

	private static int dpway(int[][] arr) {
		int m=arr.length;
		int n=arr[0].length;
		int dp[][]=new int[m][n];
		return process(arr,0,0,dp);
	}

	private static int process(int[][] arr, int i, int j, int[][] dp) {
		if(dp[i][j]!=0) {
			return dp[i][j];
		}
		if(i==arr.length-1) {
			return dp[i][j]=arr[i][j];
		}else {
			return dp[i][j]=Math.max(process(arr, i+1, j, dp), process(arr, i+1, j+1, dp))+arr[i][j];
		}
		
		
	}

	public static void show(int arr[][]) {
		for (int[] re : arr) {
			for (int i : re) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	private static int dp(int[][] arr, int i, int j) {
		if (i == arr.length-1) {
			return arr[i][j];
		} else {
			return Math.max(dp(arr, i + 1, j), dp(arr, i + 1, j + 1)) + arr[i][j];
		}
	}
}
