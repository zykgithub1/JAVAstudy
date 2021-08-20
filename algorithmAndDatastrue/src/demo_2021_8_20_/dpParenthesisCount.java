package demo_2021_8_20_;

public class dpParenthesisCount {
	public static void main(String[] args) {
		System.out.println(maxLen("())))(()()(()(())"));
	}

	public static int maxLen(String str) {
		char[] chs = str.toCharArray();
		int n = chs.length;
		int[] dp = new int[n];
		int pre = 0;
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (chs[i] == ')') {
				pre = i - dp[i - 1] - 1;
				if (pre >= 0 && chs[pre] == '(') {
					dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
				}
				res = Math.max(res, dp[i]);
			}
		}
		return res;
	}

}
