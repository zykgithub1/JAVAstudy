package demo_2021_8_20_;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MagicOp {
	@SuppressWarnings("unlikely-arg-type")
	public static int maxOp(int[] arr1, int[] arr2) {
		double sum1 = 0;
		int ans = 0;
		for (int ar1 : arr1) {
			sum1 += (double) ar1;
		}
		double sum2 = 0;
		for (int ar1 : arr2) {
			sum2 += (double) ar1;
		}
		if (avg(sum1, arr1.length) == avg(sum2, arr2.length))
			return 0;
		int[] arrBig = null;
		int[] arrSmall = null;
		double sumBig = 0;
		double sumSmall = 0;
		if (avg(sum1, arr1.length) > avg(sum2, arr2.length)) {
			arrBig = arr1;
			arrSmall = arr2;
			sumBig = sum1;
			sumSmall = sum2;
		} else {
			arrBig = arr2;
			arrSmall = arr1;
			sumBig = sum2;
			sumSmall = sum1;
		}
		Arrays.sort(arrBig);
		Set<Integer> seen = new HashSet<Integer>();
		for (int arr : arrSmall) {
			seen.add(arr);
		}
		int bigLen = arrBig.length;
		int smallLen = arrSmall.length;
		for (int i = 0; i < arrBig.length; i++) {
			double cur = (double) arrBig[i];
			if (cur < avg(sumBig, bigLen) && cur > avg(sumSmall, smallLen) && !seen.contains(cur)) {
				sumBig -= cur;
				sumSmall += cur;
				bigLen--;
				smallLen++;
				seen.add(arrBig[i]);
				ans++;
			}
		}
		return ans;
	}

	private static double avg(double sum1, int length) {
		return sum1 / (double) length;
	}

}
