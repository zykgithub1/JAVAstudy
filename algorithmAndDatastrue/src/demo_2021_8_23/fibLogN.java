package demo_2021_8_23;

public class fibLogN {
	public static void main(String[] args) {
		System.out.println(fi(44));
		System.out.println(1>>1);
//		System.out.println(-13>>1);
//		System.out.println(-14>>1);
//		System.out.println(-15>>1);
//		System.out.println(-16>>1);
		System.out.println(rabits(1));
	}
	public static int rabits(int n) {
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 3;
		}
		return rabits(n-1)+2*rabits(n-2);
	}
	public static int fi(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int[][] base = { { 1, 1 }, { 1, 0 } };
		int res[][] = matrixPower(base, n - 2);
		return res[0][0] + res[1][0];
	}

	private static int[][] matrixPower(int[][] base, int p) {
		int[][] res = new int[base.length][base[0].length];
		for (int i = 0; i < res.length; i++) {
			res[i][i] = 1;
		}
		int[][] t = base;
		while (p != 0) {
			if ((p & 1) != 0) {
				res = mutiMatrix(t, res);
			}
			t = mutiMatrix(t, t);
			p >>= 1;
		}
		return res;
	}

	private static int[][] mutiMatrix(int[][] t, int[][] r) {
		int tm = t.length;
		int tn = t[0].length;
		int rm = r.length;
		int rn = r[0].length;
		if (tn != rm) {
			throw new RuntimeException("¾ØÕóÎŞ·¨Ïà³Ë");
		}
		int res[][] = new int[tm][rn];
		for (int i = 0; i < tm; i++) {
			for (int j = 0; j < rn; j++) {
				for (int k = 0; k < rm; k++) {
					res[i][j] += t[i][k] * r[k][j];
				}
			}
		}
		return res;
	}
	
	

}
