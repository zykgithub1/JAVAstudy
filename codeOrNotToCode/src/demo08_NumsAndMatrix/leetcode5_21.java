package demo08_NumsAndMatrix;

public class leetcode5_21 {
	public static void main(String[] args) {
		Solution1 so = new Solution1();
		int h = so.maxUncrossedLines(new int[] { 4, 1, 2 }, new int[] { 2, 3, 1 });
		System.out.println(h);
	}

}

class Solution1 {
	public int maxUncrossedLines(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (nums1[i - 1] == nums2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];

	}
}