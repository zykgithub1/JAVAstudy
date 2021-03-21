package recursion;

public class NQueen {
	static int max = 8;
	static int arr[] = new int[max];
	static int count = 0;

	public static void main(String[] args) {
		NQueen q = new NQueen();
		q.cheak(0);
		System.out.println(count);

	}

	// 检查是否冲突:
	public static boolean judge(int n) {
		for (int i = 0; i < n; i++) {
			if (arr[i] == arr[n] || Math.abs(arr[i] - arr[n]) == Math.abs(i - n)) {
				return false;
			}
		}
		return true;
	}

	public static void cheak(int n) {
		if (n == max) {
			print();
			return;
		}
		for (int i = 0; i < max; i++) {
			arr[n] = i;
			if (judge(n)) {
				cheak(n + 1);
			}
		}
	}

	// 将皇后拜访的位置输出
	public static void print() {
		count++;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
