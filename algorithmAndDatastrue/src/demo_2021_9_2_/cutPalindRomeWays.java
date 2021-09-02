package demo_2021_9_2_;

import java.util.Arrays;

public class cutPalindRomeWays {
	public static void main(String[] args) {
		String str="aadsaddaaassasadlkssasasaasasasaafkssaskaslkf";
		System.out.println(minPartition2(str));
		System.out.println(minPartition(str));
	}
	public static int minPartition(String s) {
		if(s.length()==0||s==null||s.equals("")) {
			return 0;
		}
		if(s.length()==1) {
			return 1;
		}
		return process(s.toCharArray(),0);
	}

	private static int process(char[] chs, int i) {
		if(i==chs.length) {
			return 0;
		}
		int ans=Integer.MAX_VALUE;
		for(int end=i;end<chs.length;end++) {
			if(valid(chs, i, end)) {
				ans=Math.min(ans, 1+process(chs, end+1));
			}
		}
		return ans;
	}
	public static boolean valid(char[]s,int i,int r) {
		while(i<r) {
			if(s[i]!=s[r]) {
				return false;
			}
			i++;
			r--;
		}
		return true;
	}
	public static int minPartition2(String s) {
		if(s.length()==0||s==null||s.equals("")) {
			return 0;
		}
		if(s.length()==1) {
			return 1;
		}
		int[]dp=new int[s.length()];
		Arrays.fill(dp, -1);
		return process2(s.toCharArray(),0,dp);
	}

	private static int process2(char[] chs, int i,int dp[]) {
		if(i==chs.length) {
			return 0;
		}
		if(dp[i]!=-1) {
			return dp[i];
		}
		
		int ans=Integer.MAX_VALUE;
		for(int end=i;end<chs.length;end++) {
			if(valid(chs, i, end)) {
				ans=Math.min(ans, 1+process2(chs, end+1,dp));
			}
		}
		dp[i]=ans;
		return dp[i];
	}

}
