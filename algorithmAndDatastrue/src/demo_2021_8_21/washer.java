package demo_2021_8_21;

public class washer {
	public static int MinOps(int[] arr) {
		int sum = 0;
		for (int ar : arr) {
			sum += ar;
		}
		int n = arr.length;
		if (sum % (n) != 0) {
			return -1;
		}
		int leftSum = 0;
		int avg = sum / n;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int leftRest = leftSum - i * avg;
			int rightRest = (sum - leftSum - arr[i]) - (n - i - 1) * avg;
			if (leftRest < 0 && rightRest < 0) {
				ans = Math.max(ans, Math.abs(leftRest) + Math.abs(rightRest));
			} else {
				ans = Math.max(ans, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
			}
			leftSum += arr[i];
		}
		return ans;
	}

}
