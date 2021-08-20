package demo_2021_8_20_;

public class BTIsomorphism {
	public static void main(String[] args) {
		for (int i = 3; i < 10; i++) {
			System.out.println(process(i) + "   " + numTrees(i) + "  " + selfDp(i));
		}

	}

	public static int process(int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2)
			return 2;
		int res = 0;
		for (int leftNum = 0; leftNum <= n - 1; leftNum++) {
			int leftWays = process(leftNum);
			int rightWays = process(n - leftNum - 1);
			res += leftWays * rightWays;
		}
		return res;
	}

	public static int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}

	public static int selfDp(int n) {
		int[] f = new int[n + 1];
		f[0] = 1;
		f[1] = 1;
		f[2] = 2;
		for (int i = 3; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				f[i] += f[j] * f[i - j - 1];
			}
		}
		return f[n];
	}

}
