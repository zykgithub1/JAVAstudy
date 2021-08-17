package demo_2021_8_17_dp;

public class makeChanges {
	public static void main(String[] args) {
		int len = 10, max = 10;
		int times = 1000;
		for (int i = 0; i < times; i++) {
			int[] arr = alogrithmUtils.generator.generateRandomArray(len, max);
			int aim = (int) (Math.random() * 3 * max) + max;
			int dp = dpWay1(arr, aim);
			int brute = bruteWay1(arr, aim);
			int dp2 = dpWay2(arr, aim);
//			System.out.println(dp + " " + brute + " " + dp2);
			if (dp != brute || dp2 != brute) {
				System.out.println("alogrithm error");
			}
		}
		System.out.println("success");
		int a = 5;
		System.out.println(a);

	}

	public static int bruteWay1(int[] arr, int aim) {
		return process(arr, 0, aim);
	}

	private static int process(int[] arr, int index, int rest) {
		if (index == arr.length) {
			return rest == 0 ? 1 : 0;
		}
		int ans = 0;
		for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
			ans += process(arr, index + 1, rest - zhang * arr[index]);
		}
		return ans;
	}

	public static int dpWay1(int[] arr, int aim) {
		int n = arr.length;
		int[][] dp = new int[n + 1][aim + 1];
		dp[n][0] = 1;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= aim; j++) {
				for (int zhang = 0; zhang * arr[i] <= j; zhang++) {
					dp[i][j] += dp[i + 1][j - arr[i] * zhang];
				}
			}
		}
		return dp[0][aim];
	}

	public static int dpWay2(int[] arr, int aim) {
		int n = arr.length;
		int[][] dp = new int[n + 1][aim + 1];
		dp[n][0] = 1;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= aim; j++) {
				dp[i][j] = dp[i + 1][j];
				if (j - arr[i] >= 0) {
					dp[i][j] += dp[i][j - arr[i]];
				}
			}
		}
		return dp[0][aim];
	}

}
