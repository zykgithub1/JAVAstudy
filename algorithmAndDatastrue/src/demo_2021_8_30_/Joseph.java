package demo_2021_8_30_;

public class Joseph {
	/*
	 * 一共i个节点，数到m就杀人，最终活下来的节点，返回它在有i个节点时的编号 旧
	 */
	public static int getAlive(int i, int m) {
		if (i == 1) {
			return 1;
		}
		return (getAlive(i - 1, m) + m - 1) % i + 1;
	}

	public static void main(String[] args) {
		System.out.println(getAlive(8781, 9));
	}
	/*
	 * 0-n-1个人围一圈，依次循环取用arr中的数字
	 * 杀n-1轮，返回最后留用的人
	 */
	public static int getJob(int n, int arr[]) {
		return no(n, arr, 0);
	}

	private static int no(int i, int[] arr, int index) {
		if (i == 1) {
			return 1;
		}
		// 老=（新+m-1）%i+1
		return (no(i - 1, arr, nextIndex(arr.length, index)) + arr[index] - 1) % i + 1;
	}

	public static int nextIndex(int size, int index) {
		return index == size - 1 ? 0 : size + 1;
	}

}
