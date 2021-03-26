package DP;

import java.util.Scanner;

public class longestSubSequence {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int s1Size=sc.nextInt();
		int s2Size=sc.nextInt();
		Scanner sc2=new Scanner(System.in);
		String str1=null;
		String str2=null;
		str1=sc2.nextLine();
		str2=sc2.nextLine();
		System.out.println(str1);
		System.out.println(str2);
		int res=dp(str1,str2);
		System.out.println(res);
	}

	private static int dp(String s1, String s2) {
		if(s1==null||s2==null||s1.length()==0||s2.length()==0) {
			System.out.println("sasasa");
			return 0;
		}
		char[]str1=s1.toCharArray();
		char[]str2=s2.toCharArray();
		return process(str1,str2);
	}

	private static int process(char[] str1, char[] str2) {
		int[][]dp=new int[str1.length][str2.length];
		dp[0][0]=str1[0]==str2[0]?1:0;
		for(int i=1;i<str1.length;i++) {
			dp[i][0]=Math.max(dp[i-1][0], str1[i]==str2[0]?1:0);
		}
		for(int i=1;i<str2.length;i++) {
			dp[0][i]=Math.max(dp[0][i-1], str1[0]==str2[i]?1:0);
		}
		
		for(int i=1;i<str1.length;i++) {
			for(int j=1;j<str2.length;j++) {
				dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				//System.out.println(dp[i][j]);
				if(str1[i]==str2[j]) {
					dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+1);
					//System.out.println(dp[i][j]);
				}
			}
		}
		return dp[str1.length-1][str2.length-1];
	}

}
