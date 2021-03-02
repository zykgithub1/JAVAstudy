package algorithm;
//·¶Î§³¢ÊÔÄ£ĞÍ
public class chooseMorePoints {
	public static void main(String[] args) {
		int arr[] = { 70, 100, 1, 6 };
		int result = win1(arr);
		System.out.println(result);
	}

	public static int win1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
	}

	public static int f(int[] arr, int i, int j) {
		if (i == j) {
			return arr[i];
		}
		return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
	}

	private static int s(int[] arr, int i, int j) {
		if (i == j) {
			return 0;
		}
		return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
	}
}
