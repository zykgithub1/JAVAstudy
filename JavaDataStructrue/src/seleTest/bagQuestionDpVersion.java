package seleTest;

public class bagQuestionDpVersion {
	public static void main(String[] args) {
//		int w[]= {2,3,5,6};
//		int v[]= {1,1,2,5};
//		int bag=10;
//		int recursion=bagQuestionRecursion(w, v, 0, bag);
//		int dpnum=dpWay(w, v, bag);
//		System.out.println(recursion+"  "+dpnum );
		//System.out.println(countNum("111") + "   " + dpChar("111"));
		int[] arr= {4,2,100,7};
		System.out.println(findWinner(arr));
	}

	public static int bagQuestionRecursion(int w[], int v[], int index, int rest) {
		return process1(w, v, 0, rest);
	}

	private static int process1(int[] w, int[] v, int index, int rest) {
		if (rest < 0) {
			return 0;
		}
		if (index == w.length) {
			return 0;
		}
		int p1 = process1(w, v, index + 1, rest);
		int p2 = Integer.MIN_VALUE;
		if (rest >= w[index]) {
			p2 = v[index] + process1(w, v, index + 1, rest - w[index]);
		}
		return Math.max(p1, p2);
	}

	public static int dpWay(int[] w, int[] v, int bag) {
		int N = w.length;
		int[][] dp = new int[N + 1][bag + 1];
		for (int index = N - 1; index >= 0; index--) {
			for (int rest = 0; rest <= bag; rest++) {
				// dp[index][rest]=? 通过暴力递归找到动态转移方程 完成dp数组；
				int p1 = dp[index + 1][rest];
				int p2 = -1;
				if (rest - w[index] >= 0) {
					p2 = v[index] + dp[index + 1][rest - w[index]];
				}
				dp[index][rest] = Math.max(p1, p2);
			}
		}
		return dp[0][bag];
	}

	public static int countNum(String str) {
		char[] chs = str.toCharArray();
		return processChar(chs, 0);
	}

	private static int processChar(char[] chs, int index) {
		if (index == chs.length) {
			return 1;
		}
		if (chs[index] == '0') {
			return 0;
		}
		if (chs[index] == '1') {
			int res = 0;
			res = processChar(chs, index + 1);
			if (index + 1 < chs.length) {
				res += processChar(chs, index + 2);
			}
			return res;
		}
		if (chs[index] == '2') {
			int res = processChar(chs, index + 1);
			if (chs[index + 1] > '0' && chs[index + 1] < '6' && index + 1 < chs.length) {
				res += processChar(chs, index + 2);
			}
			return res;
		} else {
			return processChar(chs, index + 1);
		}
	}

	private static int dpChar(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] str = s.toCharArray();
		int N = str.length;
		int[] dp = new int[N + 1];
		dp[N] = 1;
		for (int i = N - 1; i >= 0; i--) {
			if (str[i] == '0') {
				dp[i] = 0;
			}
			if (str[i] == '1') {
				dp[i] = dp[i + 1];
				if (i + 1 < N) {
					dp[i] += dp[i + 2];
				}
			}
			if (str[i] == '2') {
				dp[i] = dp[i + 1];
				if (i + 1 < N && str[i + 1] > 0 && str[i + 1] < 6) {
					dp[i] += dp[i + 2];
				}
			}
		}
		return dp[0];
	}

	public static int findWinner(int[] arr) {
		return Math.max(f(arr,0,arr.length-1), s(arr,0,arr.length-1));
	}

	private static int s(int[] arr, int L, int R) {
		if(L==R) {
			return 0;
		}
		return Math.min(f(arr,L+1,R),f(arr,L,R-1));
	}

	private static int f(int[] arr, int L, int R) {
		if(L==R) {
			return arr[L];
		}
		return Math.max(arr[L]+s(arr,L+1,R),arr[R]+s(arr,L,R-1));
	}
	
}
