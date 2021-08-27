package demo_2021_8_27_;

public class StringToKth {
	public static void main(String[] args) {
		char a = 'a';
		System.out.println((int) (a));
		System.out.println(a + 1);
	}

	/*
	 * 以i号子字符开头，总长度为len的子序列有多少个
	 */
	public static int g(int i, int len) {
		int sum = 0;
		if (len == 1) {
			return 1;
		}
		for (int j = i + 1; j <= 26; j++) {
			sum += g(j, len - 1);
		}
		return sum;
	}

	public static int f(int len) {
		int sum = 0;
		for (int i = 1; i <= 26; i++) {
			sum += g(i, len);
		}
		return sum;
	}

	public static int kth(String s) {
		char[] str = s.toCharArray();
		int sum = 0;
		int len = str.length;
		for (int i = 1; i < len; i++) {
			sum += f(i);
		}
		int first = str[0] - 'a' + 1;
		for (int i = 1; i < first; i++) {
			sum += g(i, len);
		}
		int pre = first;
		for (int i = 1; i < len; i++) {
			int cur = str[i] - 'a' + 1;
			for (int j = pre + 1; j < cur; j++) {
				sum += g(j, len - i);
			}
			pre = cur;
		}
		return sum + 1;
	}

}
