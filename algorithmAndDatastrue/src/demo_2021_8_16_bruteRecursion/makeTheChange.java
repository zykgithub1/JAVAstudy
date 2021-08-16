package demo_2021_8_16_bruteRecursion;

import java.util.Arrays;

public class makeTheChange {
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[] coins = { 2, 3};
		System.out.println(brute(coins, 5));
		System.out.println(memoWay(coins, 5));
		System.out.println(dpTable(coins, 5));

	}

	private static int brute(int[] coins, int target) {
		return recursion(coins, 0, target);
	}

	private static int recursion(int[] coins, int index, int rest) {
		if (rest < 0) {
			return -1;
		}
		if (rest == 0) {
			return 0;
		}
		if (index == coins.length) {
			return -1;
		}
		int p1 = recursion(coins, index + 1, rest);
		int p2Next = recursion(coins, index + 1, rest - coins[index]);
		if (p1 == -1 && p2Next == -1) {
			return -1;
		} else {
			if (p1 == -1) {
				return p2Next + 1;
			}
			if (p2Next == -1) {
				return p1;
			}
			return Math.min(p1, p2Next + 1);
		}
	}

	private static int memoWay(int[] coins, int target) {
		int[][] dp = new int[coins.length + 1][target + 1];
		for (int[] link : dp) {
			Arrays.fill(link, -1);
		}
		return process(coins, 0, target, dp);
	}

	private static int process(int[] coins, int index, int rest, int[][] dp) {
		if (rest < 0) {
			return -1;
		}
		if (dp[index][rest] != -1) {
			return dp[index][rest];
		}
		if (rest == 0) {
			dp[index][rest] = 0;
			return 0;
		}
		if (index == coins.length) {
			return -1;
		}
		int p1 = process(coins, index + 1, rest, dp);
		int p2Next = process(coins, index + 1, rest - coins[index], dp);
		if (p1 == -1 && p2Next == -1) {
			return -1;
		} else {
			if (p1 == -1) {
				dp[index][rest] = p2Next + 1;
				return p2Next + 1;
			}
			if (p2Next == -1) {
				dp[index][rest] = p1;
				return p1;
			}
			dp[index][rest] = Math.min(p1, p2Next + 1);
			return dp[index][rest];
		}
	}

	private static int dpTable(int[] coins, int target) {
		int N = coins.length;
		int[][] dp = new int[N + 1][target + 1];
		for (int i = 0; i <= N; i++) {
			dp[i][0] = 0;
		}
		for (int i = 1; i <= target; i++) {
			dp[N][i] = -1;
		}
//		for (int i = 0; i <= N; i++) {
//			for (int j = 0; j <= target; j++) {
//				System.out.printf(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("next");
		for (int index = N - 1; index >= 0; index--) {
			for (int rest = 1; rest <= target; rest++) {
				int p1 = dp[index + 1][rest];
				int p2 = -1;
				if (rest - coins[index] >= 0) {
					p2 = dp[index + 1][rest - coins[index]];
				}
				if (p1 == -1 && p2 == -1) {
					dp[index][rest] = -1;
				} else {
					if (p1 == -1) {
						dp[index][rest] = p2 + 1;
					}
					else if (p2 == -1) {
						dp[index][rest] = p1;
					} else {
						dp[index][rest] = Math.min(p1, p2 + 1);
					}
				}
			}
		}
//		for (int i = 0; i <= N; i++) {
//			for (int j = 0; j <= target; j++) {
//				System.out.printf(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println();
		return dp[0][target];
	}

}
