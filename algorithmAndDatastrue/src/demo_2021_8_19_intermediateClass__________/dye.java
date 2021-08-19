package demo_2021_8_19_intermediateClass__________;

public class dye {
	public static void main(String[] args) {
		System.out.println(minPaintTest("RGRGRGRGGR"));
	}

	/*
	 * 左全G，又全R 每一个G颜色的左边都没有R颜色
	 */
	public static int minPaintTest(String str) {
		char[] chs = str.toCharArray();
		int n = chs.length;
		int countR[] = new int[chs.length];
		countR[0] = chs[0] == 'R' ? 1 : 0;
		int countG[] = new int[chs.length];
		countG[n - 1] = chs[n - 1] == 'G' ? 1 : 0;
		// 预处理两个数组存 R,G的信息
		for (int i = 1; i < n; i++) {
			if (chs[i] == 'R') {
				countR[i] = countR[i - 1] + 1;
			} else {
				countR[i] = countR[i - 1];
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			if (chs[i] == 'G') {
				countG[i] = countG[i + 1] + 1;
			} else {
				countG[i] = countG[i + 1];
			}
		}
		System.out.println("countR");
		for (int in : countR) {
			System.out.printf(in + " ");
		}
		System.out.println();
		System.out.println("countG");
		for (int in : countG) {
			System.out.printf(in + " ");
		}
		System.out.println();
		int min = Integer.MAX_VALUE;
		for (int l = 0; l <= n; l++) {
			if (l == 0) {
				min = Math.min(min, countR[n - 1]);
			} else if (l == n) {
				min = Math.min(min, countG[0]);
			} else {
				int lg = countG[l] + countR[l];
				min = Math.min(min, lg);
			}
			System.out.printf(min + "  " + ":");
		}
		System.out.println();
		return min;
	}

}
