package demo_2021_8_26_;

public class waysOfexpress {
	public static int num1(String express, boolean desire) {
		if (express == null || express.length() == 0) {
			return 0;
		}
		char[] exp = express.toCharArray();
		if (!isValid(exp)) {
			return 0;
		}
//		return p(exp, desire, 0, exp.length - 1);
		return 1;
	}

	/*
	 * l 和r 位置一定不能压中逻辑符号
	 * 
	 */
//	private static int p(char[] exp, boolean desire, int l, int r) {
//		if (l == r) {
//			if (exp[l] == '1') {
//				return desire ? 1 : 0;
//			} else {
//				return desire ? 0 : 1;
//			}
//		}
//	}

	private static boolean isValid(char[] exp) {
		if ((exp.length & 1) == 0) {
			return false;
		}
		for (int i = 0; i < exp.length; i += 2) {
			if (exp[i] != '&' && exp[i] != '|' && exp[i] != '^') {
				return false;
			}
		}
		for (int i = 1; i < exp.length; i += 2) {
			if (exp[i] != '1' && exp[i] != '0') {
				return false;
			}
		}
		return true;
	}

}
