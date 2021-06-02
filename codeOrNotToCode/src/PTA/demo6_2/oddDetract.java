package PTA.demo6_2;

import java.util.Scanner;

public class oddDetract {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while (N > 0) {
			for (int i = 0; i < N; i++) {
				double a = sc.nextDouble();
				cheack(a);
			}
		}
	}

	public static void cheack(double a) {
		if (a > 2 && a % 2 != 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
