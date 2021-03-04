package seleTest;

public class dpTestSecond {
	public static void main(String[] args) {
//		int w[]= {2,3,5,6};
//		int v[]= {5,6,7,8};
//		int bag=10;
//		int recursion=bagQuestionRecursion(w, v, 0, bag);
//		int dpnum=dpWay(w, v, bag);
//		System.out.println(recursion+"  "+dpnum );
//		System.out.println(countNum("11111") + "   " + dpChar("11111"));
		int[] arr= {4,7,9,5,19,29,80,4};
		System.out.println(dpWinner(arr)+"     "+findWinner(arr));
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
		int N=w.length;
		int[][] dp=new int[N+1][bag+1];
		for(int index=N-1;index>=0;index--) {
			for(int rest=0;rest<=bag;rest++) {
				int p1=dp[index+1][rest];
				int p2=-1;
				if(rest-w[index]>=0) {
					p2=v[index]+dp[index+1][rest-w[index]];
				}
				dp[index][rest]=Math.max(p1, p2);
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
		dp[N]=1;
		for(int index=N-1;index>=0;index--) {
			if(str[index]=='1') {
				dp[index]=dp[index+1];
				if(index+1<N) {
					dp[index]+=dp[index+2];
				}
			}
			if(str[index]=='2') {
				dp[index]=dp[index+1];
				if(index+1<N&&str[index]>'0'&&str[index]<'6') {
					dp[index]+=dp[index+2];
				}
			}
		}
		return dp[0];
	}

	public static int dpWinner(int[] arr) {
		int N=arr.length;
		int f[][]=new int[N+1][N+1];
		int s[][]=new int[N+1][N+1];
		for(int i=0;i<N;i++) {
			f[i][i]=arr[i];
		}
		for(int i=1;i<N;i++) {
			int L=0;
			int R=i;
			while(L<N&&R<N) {
				f[L][R]=Math.max(
						arr[L]+s[L+1][R]           ,
						arr[R]+s[L][R-1]           );
				s[L][R]=Math.min(f[L+1][R], f[L][R-1]);
				L++;
				R++;
			}
		}
		return Math.max(f[0][N-1], s[0][N-1]);
		
	}

	public static int findWinner(int arr[]) {
		if(arr.length<2||arr==null) {
			return 0;
		}
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
