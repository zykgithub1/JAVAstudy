package PTA2021_5_30;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode7_10 {

}

class getrain {
	public int trap(int[] height) {
		int left = 0;
		int n = height.length;
		int right = n - 1;
		int leftMax = 0;
		int rightMax = 0;
		int ans = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] > leftMax) {
					leftMax = height[left];
				} else {
					ans += leftMax - height[left];
				}
				left++;
			} else {
				if (height[right] > rightMax) {
					rightMax = height[right];
				} else {
					ans += rightMax - height[right];
				}
				right--;
			}
		}
		return ans;

	}
}

class divideWords {
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> words = new HashSet<>(wordDict);
		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && words.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}
}

class StockTrade {
	public int maxProfit(int[] prices, int fee) {
		int ans = 0;
		int buy = prices[0] + fee;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] + fee < buy) {
				buy = prices[i] + fee;
			} else if (prices[i] > buy) {
				ans += prices[i] - buy;
				buy = prices[i];
			}
		}
		return ans;
	}
}
