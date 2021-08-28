package demo_2021_8_28_;

import java.util.HashMap;

public class xorSum {
	public static void main(String[] args) {
		int arr[] = { 3, 2, 1, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println(mostXor(arr));
	}

	public static int mostXor(int[] arr) {
		int xor = arr[0];
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		int[] dp = new int[n];
		dp[0] = arr[0] == 0 ? 1 : 0;
		map.put(0, -1);
		for (int i = 1; i < n; i++) {
			xor ^= arr[i];
			if (map.containsKey(xor)) {
				int pre = map.get(xor);
				dp[i] = pre == -1 ? 1 : dp[pre] + 1;
			}
			dp[i] = Math.max(dp[i - 1], dp[i]);
			map.put(xor, i);
		}
		return dp[n - 1];
	}

}
