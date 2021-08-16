package demo_2021_8_15_bitsOpreation;

public class returnMaxNum {
	public static void main(String[] args) {
		int a = -16;
		int b = 1;
		System.out.println(getMax1(a, b));
		System.out.println(getMax2(a, b));
		a = 2147483647;
		b = -2147480000;
		System.out.println(getMax1(a, b));
		System.out.println(getMax2(a, b));
	}

	public static int flip(int n) {
		return n ^ 1;
	}

	public static int sign(int n) {
		// if neg or pos
		return flip((n >> 31) & 1);
	}

	public static int getMax1(int a, int b) {
		int c = a - b;
		int scA = sign(c);
		int scB = flip(scA);
		return scA * a + scB * b;
	}

	public static int getMax2(int a, int b) {
		int c = a - b;
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(c);
		int difSab = sa ^ sb; // if a b同号 为0，不然为1
		int sameSab = flip(difSab);
		int returnA = sameSab * sc + difSab * sa;
		int returnB = flip(returnA);
		return a * returnA + b * returnB;
	}

}
