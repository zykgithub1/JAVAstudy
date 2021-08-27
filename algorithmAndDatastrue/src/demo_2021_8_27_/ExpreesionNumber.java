package demo_2021_8_27_;

public class ExpreesionNumber {
	public static void main(String[] args) {
		String expresss="1^0&0|1&1^0&0^1|0|1&1";
		boolean desired=true;
		System.out.println(dpLive(expresss, desired));
		System.out.println(nums1(expresss, desired));
	}
	
	public static int nums1(String str,boolean desire) {
		char[]chs=str.toCharArray();
		if(!isValid(chs)) {
			return 0;
		}
		return p(chs, desire, 0, str.length()-1);
	}
	public static boolean isValid(char[] exp) {
		if ((exp.length & 1) == 0) {
			return false;
		}
		for (int i = 0; i < exp.length; i += 2) {
			if (exp[i] != '1' && exp[i] != '0') {
				return false;
			}
		}
		for (int i = 1; i < exp.length; i += 2) {
			if (exp[i] != '&' && exp[i] != '|' && exp[i] != '^') {
				return false;
			}
		}
		return true;
	}

	public static int p(char[] exp, boolean desire, int L, int R) {
		if (L == R) {
			if (exp[L] == '1') {
				return desire ? 1 : 0;
			} else {
				return desire ? 0 : 1;
			}
		}
		int res = 0;
		if (desire) {
			for (int i = L + 1; i < R; i++) {
				switch (exp[i]) {
				case '&':
					res += p(exp, true, L, i - 1) * p(exp, true, i + 1, R);
					break;
				case '|':
					res += p(exp, true, L, i - 1) * p(exp, true, i + 1, R)
							+ p(exp, true, L, i - 1) * p(exp, false, i + 1, R)
							+ p(exp, false, L, i - 1) * p(exp, true, i + 1, R);
					break;
				case '^':
					res += p(exp, true, L, i - 1) * p(exp, false, i + 1, R);
					res += p(exp, false, L, i - 1) * p(exp, true, i + 1, R);
					break;
				}
			}
		} else {
			for (int i = L + 1; i < R; i++) {
				switch (exp[i]) {
				case '&':
					res += p(exp, true, L, i - 1) * p(exp, false, i + 1, R);
					res += p(exp, false, L, i - 1) * p(exp, true, i + 1, R);
					res += p(exp, false, L, i - 1) * p(exp, false, i + 1, R);
					break;
				case '|':
					res += p(exp, false, L, i - 1) * p(exp, false, i + 1, R);
					break;
				case '^':
					res += p(exp, true, L, i - 1) * p(exp, true, i + 1, R);
					res += p(exp, false, L, i - 1) * p(exp, false, i + 1, R);
					break;
				}
			}
		}
		return res;
	}

	public static int dpLive(String express, boolean desire) {
		char[] str = express.toCharArray();
		int N = str.length;
		int[][] tMap = new int[N][N];
		int[][] fMap = new int[N][N];
		for (int i = 0; i < N; i += 2) {
			tMap[i][i] = str[i] == '1' ? 1 : 0;
			fMap[i][i] = str[i] == '0' ? 1 : 0;
		}
		for (int row = N - 3; row >= 0; row -= 2) {
			for (int col = row + 2; col < N; col += 2) {
				for (int i = row + 1; i < col; i += 2) {
					switch (str[i]) {
					case '&':
						tMap[row][col] = tMap[row][i - 1] * tMap[i + 1][col];
						break;
					case '|':
						tMap[row][col] += tMap[row][i - 1] * tMap[i + 1][col];
						tMap[row][col] += tMap[row][i - 1] * fMap[i + 1][col];
						tMap[row][col] += fMap[row][i - 1] * tMap[i + 1][col];
						break;
					case '^':
						tMap[row][col] = tMap[row][i - 1] * fMap[i + 1][col];
						tMap[row][col] = fMap[row][i - 1] * tMap[i + 1][col];
						break;
					}
					switch (str[i]) {
					case '&':
						fMap[row][col] = tMap[row][i - 1] * fMap[i + 1][col];
						fMap[row][col] = fMap[row][i - 1] * tMap[i + 1][col];
						fMap[row][col] = fMap[row][i - 1] * fMap[i + 1][col];
						break;
					case '|':
						fMap[row][col] += fMap[row][i - 1] * fMap[i + 1][col];
						break;
					case '^':
						fMap[row][col] = fMap[row][i - 1] * fMap[i + 1][col];
						fMap[row][col] = tMap[row][i - 1] * tMap[i + 1][col];
						break;
					}
				}
			}
		}
		return desire ? tMap[0][N - 1] : fMap[0][N - 1];
	}
}
