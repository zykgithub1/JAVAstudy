package demo_2021_8_11;

public class KMP {
	public static void main(String[] args) {

	}

	public static int kmp(String text, String pattern) {
		if (text == null || pattern == null || text.length() < pattern.length()) {
			return -1;
		}
		char[] textArr = text.toCharArray();
		char[] patternArr = pattern.toCharArray();
		int i1 = 0, i2 = 0;
		int[] next = getNextArray(patternArr);
		while (i1 < text.length() && i2 < pattern.length()) {
			if (textArr[i1] == patternArr[i2]) {
				i1++;
				i2++;
			} else if (i2 == 0) { // nextArr only i2==0 next[i2]=-1 ->i2 can not move back at all
				i1++;
			} else {
				i2 = next[i2];
			}
		}
		return i2 == pattern.length() ? i1 - i2 : -1;
	}

	private static int[] getNextArray(char[] patternArr) {
		int n = patternArr.length;
		int[] next = new int[n];
		next[0] = -1;
		next[1] = 0;
		int i = 2;
		int j = 0;
		while (i < n) {
			if (patternArr[i - 1] == patternArr[j]) {
				next[i++] = ++j;
			} else if (j > 0) {
				j = next[j];
			} else {
				next[i++] = 0;
			}
		}
		return next;
	}

}
