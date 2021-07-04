package PTA2021_5_30;

public class leetcode2021_7_4 {
	public int deleteAndEarn(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int os : nums) {
			max = Math.max(os, max);
		}
		int all[] = new int[max + 1];
		for (int os : nums) {
			all[os]++;
		}
		int[][] f = new int[max + 1][2];
		for (int i = 1; i <= max; i++) {
			f[i][1] = f[i - 1][0] + i * all[i];
			f[i][0] = Math.max(f[i - 1][1], f[i - 1][0]);
		}
		return Math.max(f[max][0], f[max][1]);
	}

	public int rob(int[] nums) {
		return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
	}

	public int rob(int[] nums, int start, int end) {
		int dp[] = new int[nums.length];
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		dp[start] = nums[start];
		dp[start + 1] = Math.max(nums[start], nums[start + 1]);
		for (int i = start + 2; i <= end; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[end];
	}

}
