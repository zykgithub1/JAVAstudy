package demo_2021_9_3_;

public class perfectShif {
	public static void main(String[] args) {

	}

	public static void shif(int[] arr) {
		shuffle(arr, 0, arr.length);
	}

	private static void shuffle(int[] arr, int L, int R) {
		while (R - L + 1 > 0) {
			int len = R - L;
			int base = 3;
			int k = 1;
			while (base <= (len + 1) / 3) {
				base *= 3;
				k++;
			}
			int half = (base - 1) / 2;
			int mid = (L + R) / 2;
			rotate(arr, L + half, mid, mid + half);
			cycles(arr, L, base - 1, k);
			L = L + base - 1;
		}

	}

	private static void cycles(int[] arr, int start, int len, int k) {
		for (int i = 0, triger = 1; i < k; i++, triger *= 3) {
			int preValue = arr[triger + start - 1];
			int cur = modifyIndex(triger, len);
			while (cur != triger) {
				int tmp = arr[cur + start - 1];
				arr[cur + start - 1] = preValue;
				preValue = tmp;
				cur = modifyIndex(cur, len);
			}
			arr[cur + start - 1] = preValue;
		}

	}

	private static void rotate(int[] arr, int i, int mid, int j) {
		// TODO Auto-generated method stub

	}

	public static int modifyIndex(int i, int len) {
		if (i <= len / 2) {
			return 2 * i;
		} else {
			return 2 * (i - (len / 2)) - 1;
		}
	}

}
