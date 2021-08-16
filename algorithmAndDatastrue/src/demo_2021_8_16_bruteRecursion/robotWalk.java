package demo_2021_8_16_bruteRecursion;

import java.util.Arrays;

public class robotWalk {
	public static void main(String[] args) {
		System.out.println(bruteWalk(5, 4, 12, 2));
		System.out.println(memoWalk(5, 4, 12, 2));
	}
	public static int bruteWalk(int N,int goal,int rest,int cur) {
		return process1(N,goal,rest,cur);
	}
	public static int memoWalk(int N,int goal,int rest,int cur) {
		int[][]dp=new int[rest+1][N+1];
		for(int[]link:dp) {
			Arrays.fill(link, -1);
		}
		return process2(N,goal,rest,cur,dp);
	}
	
	private static int process2(int N, int p, int rest, int cur, int[][] dp) {
		if(dp[rest][cur]!=-1) {
			return dp[rest][cur];
		}
		if (rest == 0) {
			return cur == p ? 1 : 0;
		}
		if (cur == 1) {
			return process2(N, p, rest - 1, cur + 1,dp);
		}
		if (cur == N) {
			return process2(N, p, rest - 1, cur - 1,dp);
		}
		int ans=process2(N, p, rest-1, cur+1, dp)+process2(N, p, rest-1, cur-1, dp);
		dp[rest][cur]=ans;
		return ans;
	}
	/*
	 * N= size
	 * p=goal
	 * rest-> rest steps
	 * cur ->cur location
	 */
	private static int process1(int N, int p, int rest, int cur) {
		if (rest == 0) {
			return cur == p ? 1 : 0;
		}
		if (cur == 1) {
			return process1(N, p, rest - 1, cur + 1);
		}
		if (cur == N) {
			return process1(N, p, rest - 1, cur - 1);
		}
		int ans = 0;
		ans += process1(N, p, rest - 1, cur + 1);
		ans += process1(N, p, rest - 1, cur - 1);
		return ans;
	}
	
	

}
