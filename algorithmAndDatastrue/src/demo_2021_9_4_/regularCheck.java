package demo_2021_9_4_;

public class regularCheck {
	public static void main(String[] args) {
		String str = "aaaaab";
		String exp = "a*b";
		System.out.println(isMatch(str, exp));

	}

	public static boolean isMatch(String str, String exp) {
		if (str == null || exp == null) {
			return false;
		}
		char[] s = str.toCharArray();
		char[] e = exp.toCharArray();
		return isValid(s, e) && process(s, e, 0, 0);
	}

	private static boolean process(char[] s, char[] e, int si, int ei) {
		if (ei == e.length) {
			return si == s.length;
		}
		if (ei + 1 == e.length || e[ei + 1] != '*') {
			return si != s.length && (s[si] == e[ei] || e[ei] == '.') && process(s, e, si + 1, ei + 1);
		}
		while (si != s.length && (s[si] == e[ei] || e[ei] == '.')) {
			if (process(s, e, si, ei + 2)) {
				return true;
			}
			si++;
		}
		return process(s, e, si, ei + 2);
	}

	private static boolean isValid(char[] s, char[] e) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] == '.' || s[i] == '*') {
				return false;
			}
		}
		for (int i = 0; i < e.length; i++) {
			if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
				return false;
			}
		}
		return true;
	}

}
