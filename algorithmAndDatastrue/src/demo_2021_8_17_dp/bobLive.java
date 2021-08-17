package demo_2021_8_17_dp;

public class bobLive {
	public static void main(String[] args) {
		long ans=gcd(125,50);
		System.out.println(ans);
		System.out.println(bob1(22, 22, 11, 11, 11));
	}
	
	public static String bob1(int N,int M,int i,int j,int step) {
		long all=(long) Math.pow(4, step);
		long live=brute(N,M,i,j,step);
		long gcd=gcd(all,live);
		return String.valueOf(live/gcd+"/"+all/gcd);
	}

	private static long brute(int n, int m, int i, int j, int step) {
		if(i<0||i>=n||j<0||j>=m) {
			return 0;
		}
		if(step==0) {
			return 1;
		}
		long live=brute(n, m, i+1, j, step-1);
		live+=brute(n, m, i-1, j, step-1);
		live+=brute(n, m, i, j-1, step-1);
		live+=brute(n, m, i, j+1, step-1);
		return live;
	}

	private static long gcd(long m, long n) {
		return (long)n==0?m:gcd(n,m%n);
	}

}
