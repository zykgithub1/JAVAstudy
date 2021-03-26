package DP;

import java.util.Scanner;

public class searchTreasure {
	public static void main(String[] args) {
//		Scanner sc=new Scanner(System.in);
//		int row=sc.nextInt();int col=sc.nextInt();
//		int[][]matrix=new int[row][col];
//		for(int i=0;i<row;i++) {
//			for(int j=0;j<col;j++) {
//				matrix[i][j]=sc.nextInt();
//			}
//		}
		int[][]arr= {{1,18,9,3},{7,10,6,12},{5,13,4,15},{2,11,8,16}};
//		int res=dp(arr);
//		int res2=dpway(arr);
//		int res3=dpwayUpgrade(arr);
//		System.out.println(res);
//		System.out.println(res2);
//		System.out.println(res3);
		System.out.println(finalDp(arr));
	}
	private static int finalDp(int[][] arr) {
		int m=arr.length;int n=arr[0].length;
		for(int j=1;j<n;j++) {
			arr[0][j]+=arr[0][j-1];
		}
		for(int j=1;j<m;j++) {
			arr[j][0]+=arr[j-1][0];
		}
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				arr[i][j]+=Math.max(arr[i][j-1],arr[i-1][j]);
			}
		}
		return arr[m-1][n-1];
	}
	private static int dpwayUpgrade(int[][] arr) {
		int m=arr.length;int n=arr[0].length;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0&&j==0) continue;
				if(i==0) {
					arr[i][j]+=arr[i][j-1];
				}else if(j==0) {
					arr[i][j]+=arr[i-1][j];
				}else {
					arr[i][j]+=Math.max(arr[i-1][j],arr[i][j-1]);
				}
			}
		}
		return arr[m-1][n-1];
		
	}
	/*
	 * 记忆化搜索
	 */
	private static int dpway(int[][] arr) {
		if(arr==null||arr.length==0) {
			return 0;
		}
		int row=arr.length;int col=arr[0].length;
		int[][]helper=new int[row][col];
		return process2(arr,row-1,col-1,helper);
	}

	private static int process2(int[][] arr, int i, int j, int[][] helper) {
		if(helper[i][j]!=0) {
			return helper[i][j];
		}
		if(i==0&&j>0) {
			return helper[i][j]=arr[i][j]+process(arr, i, j-1);
		}
		if(j==0&&i>0) {
			return helper[i][j]=arr[i][j]+process(arr, i-1, j);
		}
		if(i<0||j<0) {
			return 0;
		}
		return helper[i][j]=arr[i][j]+Math.max(process(arr, i-1, j), process(arr, i, j-1));
	}

	private static int dp(int[][] arr) {
		return process(arr,arr.length-1,arr[0].length-1);
	}

	/*
	 * 暴力递归：
	 * 如果已到顶部或者已到边缘：只能i-1或者j-1
	 * else暴力递归
	 * base case 超过边界返回0就好
	 * 	 */
	private static int process(int[][] arr, int i, int j) {
		if(i==0&&j>0) {
			return arr[i][j]+process(arr, i, j-1);
		}
		if(j==0&&i>0) {
			return arr[i][j]+process(arr, i-1, j);
		}
		if(i<0||j<0) {
			return 0;
		}
		return arr[i][j]+Math.max(process(arr, i-1, j), process(arr, i, j-1));
	}
}
