package cn.sxt.array2;

import java.util.Arrays;

public class TestArrays {
	public static void main(String[]a) {
		int[] a1= {110,220,30,40,5,3,1};
		System.out.println(a1);
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.binarySearch(a1,110));

		Arrays.sort(a1);
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.binarySearch(a1,110));
	}

}
