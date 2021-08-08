package demo_2021_8_8_preFixAndGreedy;

public class NQueen {

	public static void main(String[] args) {
		System.out.println(num1(8)+" "+num2(8));
	}

	public static int num1(int n) {
		if (n < 1 || n > 16) {
			return 0;
		}
		int[] record = new int[n];
		return process1(0, record, n);
	}

	/*
	 * come up cur row record include positions of past queens
	 */
	private static int process1(int cur, int[] record, int n) {
		if (cur == n) {
			return 1;
		}
		int res = 0;
		for (int j = 0; j < n; j++) {
			if (isValid(record, cur, j)) {
				record[cur] = j;
				res += process1(cur + 1, record, n);

			}
		}
		return res;
	}

	private static boolean isValid(int[] record, int i, int j) {
		for (int k = 0; k < i; k++) {
			if (record[k] == j || Math.abs(record[k] - j) == Math.abs(i - k)) {
				return false;
			}
		}
		return true;
	}

	public static int num2(int n) {
		if (n < 1 || n > 32) {
			return 0;
		}
		int limit = n == 32 ? -1 : (1 << n) - 1;
		return process3(limit, 0, 0, 0);
	}

	private static int process2(int limit, int colLim, int leftLim, int rightLim) {
		if(colLim==limit) {
			return 1;
		}
		int pos=limit&(~(colLim|leftLim|rightLim));
		int mostRightOne=0;
		int ans=0;
		while(pos!=0) {
			mostRightOne=pos&(~pos+1);
			pos=pos-mostRightOne;
			ans+=process2(limit, colLim|mostRightOne, (leftLim|mostRightOne)<<1, (rightLim|mostRightOne)>>>1);
		}
		return ans;
	}
	private static int process3(int limit, int colLim, int leftLim, int rightLim) {
		if(colLim==limit) {
			return 1;
		}
		int pos=limit&(~(colLim|leftLim|rightLim));
		int mostRightOne=0;
		int res=0;
		while(pos!=0) {
			mostRightOne=pos&(~pos+1);
			pos-=mostRightOne;
			res+=process3(limit, colLim|mostRightOne, (leftLim|mostRightOne)<<1, (rightLim|mostRightOne)>>>1);
		}
		return res;
	}

}
