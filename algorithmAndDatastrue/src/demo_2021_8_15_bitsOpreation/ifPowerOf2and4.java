package demo_2021_8_15_bitsOpreation;

public class ifPowerOf2and4 {
	public static void main(String[] args) {
//		System.out.println(0x55555555);
//		System.out.println(is4Power(16));
		System.out.println(add(3, 11));
		System.out.println(minus(3, 11));
		System.out.println(multi(-3, 11));
	}

	public static boolean is4Power(int n) {
		return ((n & (n - 1)) == 0) && ((n & 0x55555555) != 0);
	}

	public static int add(int a, int b) {
		int xor = a;
		while (b != 0) {
			xor = a ^ b; // 无进位相加
			b = (a & b) << 1; // 进位
			a = xor;
		}
		return xor;
	}

	public static int minus(int a, int b) {
		return add(a, negNum(b));
	}

	// 一个数的相反数就是 他的反 加1
	private static int negNum(int b) {
		return add(~b, 1);
	}

	public static int multi(int a, int b) {
		int res = 0;
		while (b != 0) {
			if ((b & 1) != 0) {
				res = add(res, a);
			}
			a <<= 1;
			b >>>= 1;
		}
		return res;
	}

}
