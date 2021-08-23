package demo_2021_8_22_;

public class saveWater {
	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 5, 2, 4 };
		System.out.println(save(arr));
	}

	public static int save(int[] arr) {
		int l = 0;
		int r = arr.length - 1;
		int leftMax = 0;
		int rightMax = 0;
		int ans = 0;
		while (l < r) {
			if (arr[l] < arr[r]) {
				if (arr[l] > leftMax) {
					leftMax = arr[l];
				} else {
					ans += leftMax - arr[l];
				}
				l++;
			} else {
				if (arr[r] > rightMax) {
					rightMax = arr[r];
				} else {
					ans += rightMax - arr[r];
				}
				r--;
			}
		}
		return ans;
	}

}
