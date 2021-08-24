package demo_2021_8_24_;

public class subArrMaxSum {
	public static void main(String[] args) {
		int[] arr = { 1, 1, -1, 11, -11, 8, -6, 9, 20, -10, -2 };
		int[] arr2 = { -2, -3, -5, -6, -9 };
		int res = process2(arr2);
		System.out.println(res);
	}

	private static int process(int[] arr) {
		int ans = arr[0], pre = 0;
		for (int ar : arr) {
			pre += ar;
			ans = Math.max(ans, pre);
			pre = pre < 0 ? 0 : pre;
		}
		return ans;
	}

	private static int process2(int[] arr) {
		int ans = arr[0], pre = 0;
		for (int ar : arr) {
			pre += ar;
			ans = Math.min(ans, pre);
			pre = pre > 0 ? 0 : pre;
		}
		return ans;
	}
}
