package demo_2021_8_3;

public class bucketSort {
	public static void main(String[] args) {
		System.out.println(10 / 100);

	}

	public static int maxbits(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int ar : arr) {
			max = Math.max(ar, max);
		}
		int ans = 0;
		while (max > 0) {
			ans++;
			max /= 10;
		}
		return ans;
	}

	public static void radixSort(int arr[], int l, int r, int digit) {
		final int radix = 10;
		int[] bucket = new int[r - l + 1];
		for (int d = 1; d <= digit; d++) {
			int[] count = new int[radix];
			for (int i = l; i <= r; i++) {
				int j = getDigit(arr[i], d);
				count[j]++;
			}
			for (int i = 1; i < radix; i++) {
				count[i] = count[i] + count[i - 1];
			}
			for (int i = r; i >= l; i--) {
				int j = getDigit(arr[i], d);
				bucket[count[j] - 1] = arr[i];
				count[j]--;
			}
			for (int i = l, j = 0; i <= r; i++, j++) {
				arr[i] = bucket[j];
			}
		}
	}

	private static int getDigit(int x, int d) {
		return ((x / (int) (Math.pow(10, d - 1))) % 10);
	}

}
