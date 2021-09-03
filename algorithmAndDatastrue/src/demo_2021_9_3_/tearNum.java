package demo_2021_9_3_;

import java.util.Arrays;

public class tearNum {
	public static int process(int pre,int rest) {
		if(rest==0) {
			return 1;
		}
		if(rest<pre) {
			return 0;
		}
		if(rest<0) {
			return 0;
		}
		int ans=0;
		for(int i=pre;i<=rest;i++) {
			ans+=process(i, rest-i);
		}
		return ans;
	}
	
	public static int selfMemo(int num) {
		int[][]dp=new int[num+1][num+1];
		for(int[]li:dp) {
			Arrays.fill(li, -1);
		}
		return memo(1, num, dp);
	}
	public static int memo(int pre,int rest,int[][]dp) {
		if(rest==0) {
			return 1;
		}
		if(rest<pre) {
			return 0;
		}
		if(dp[pre][rest]!=-1) {
			return dp[pre][rest];
		}
		int ans=0;
		for(int i=pre;i<=rest;i++) {
			ans+=memo(i, rest-i, dp);
		}
		dp[pre][rest]=ans;
		return dp[pre][rest];
	}
	public static int selfTable(int num) {
		int[][]dp=new int[num+1][num+1];
		for(int pre=1;pre<=num;pre++) {
			dp[pre][0]=1;
		}
		for(int pre=num;pre>0;pre--) {
			for(int rest=pre;rest<=num;rest++) {
				for(int i=pre;i<=rest;i++) {
					dp[pre][rest]+=dp[i][rest-i];
				}
			}
		}
		return dp[1][num];
	}
	public static int selfTable2(int num) {
		int[][]dp=new int[num+1][num+1];
		for(int pre=1;pre<=num;pre++) { 
			dp[pre][0]=1;
		}
		for(int pre=1;pre<=num;pre++) {
			dp[pre][pre]=1;
		}
		for(int pre=num-1;pre>0;pre--) {
			for(int rest=pre+1;rest<=num;rest++) {
				dp[pre][rest]=dp[pre][rest-pre]+dp[pre+1][rest];
			}
		}
		return dp[1][num];
	}
	public static void main(String[] args) {
//		System.out.println(process(1,50));
		System.out.println(selfMemo(1110));
		System.out.println(selfMemo(1111));
		System.out.println(selfTable(1111));
		System.out.println(selfTable2(1111));
	}
}
