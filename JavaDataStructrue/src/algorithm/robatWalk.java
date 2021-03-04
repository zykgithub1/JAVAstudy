package algorithm;
//机器人走步子，初识动态规划   记忆化收索：
public class robatWalk {
	public static void main(String[] args) {
		int res = way1(6, 2,5, 3);
		int res1=way2(6, 2, 5, 3);
		System.out.println(res+"  "+res1);
	}

	public static int way1(int size, int cur, int rest, int P) {
		if (size < 2 || cur > size || P > size || rest < 1||P<1) {
			return 0;
		}
		return walk(size, cur, rest, P);
	}

	public static int walk(int N, int cur, int rest, int P) {
		if (rest == 0) {
			return cur == P ? 1 : 0;
		}
		if (cur == 1)
			return walk(N, 2, rest - 1, P);
		if (cur == N) {
			return walk(N, N - 1, rest - 1, P);
		}
		return walk(N, cur + 1, rest - 1, P) + walk(N, cur - 1, rest - 1, P);
	}

	public static int way2(int size, int cur, int rest, int P) {
		if (size < 1 || cur > size || P > size || rest < 0) {
			return 0;
		}
		int[][] dp = new int[size + 1][rest + 1];
		for (int i = 0; i < size + 1; i++) {
			for (int j = 0; j < rest + 1; j++) {
				dp[i][j] = -1;
			}
		}
		return walk2(size, cur, rest, P, dp);
	}

	private static int walk2(int size, int cur, int rest, int p, int[][] dp) {
		if(dp[cur][rest]!=-1) {
			return dp[cur][rest];
		}
		if(rest==0) {
			if(cur==p) {
				dp[cur][rest]=1;
				return dp[cur][rest];
			}
			return 0;
		}
		if(cur==1) {
			dp[cur][rest]=walk2(size, 2, rest-1, p, dp);
			return dp[cur][rest];
		}
		if(cur==size) {
			dp[cur][rest]=walk2(size, size-1, rest-1, p, dp);
			return dp[cur][rest];
		}
		dp[cur][rest]=walk2(size, cur-1, rest-1, p, dp)+walk2(size, cur+1, rest-1, p, dp);
		return dp[cur][rest];
	}
}
