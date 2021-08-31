package demo_2021_8_31_;

public class LongestSumSubArr {
	public static int maxLenAwesome(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int n = arr.length;
		int[] minSums = new int[n];
		int[] minSumEnds = new int[n];
		minSums[n - 1] = arr[n - 1];
		minSumEnds[n - 1] = n - 1;
		for (int i = n - 2; i >= 0; i--) {
			if (minSums[i + 1] < 0) {
				minSums[i] = arr[i] + minSums[i + 1];
				minSumEnds[i] = minSumEnds[i + 1];
			} else {
				minSums[i] = arr[i];
				minSumEnds[i] = i;
			}
		}
		int end = 0;
		int sum = 0;
		int res = 0;
		for (int i = 0; i < n; i++) {
			while (end < n && sum + minSums[end] <= k) {
				sum += minSums[end];
				end = minSumEnds[end] + 1;
			}
			res = Math.max(res, end - i);
			if (end > i) {
				sum -= arr[i];
			} else {
				end = i + 1;
			}
		}
		return res;
	}
}
