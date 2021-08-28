package demo_2021_8_28_;

import java.util.Arrays;

import demo_2021_8_24_.prefix;

public class bucketSort {
	public static void main(String[] args) {
		int[]arr= {1,51,79,100,54,23,67,55,42};
		int[]nums=arr.clone();
		Arrays.sort(nums);
		for(int nu:nums) {
			System.out.printf(nu+" ");
		}
		System.out.println();
		System.out.println(maxGap(nums));
		System.out.println(maxGap(arr));
		System.out.println(1^2);
	}
	public static int maxGap(int[] nums) {
		int len = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		if (min == max) {
			return 0;
		}
		boolean[] hasNum = new boolean[len + 1];
		int[] maxs = new int[len + 1];
		int[] mins = new int[len + 1];
		for (int i = 0; i < len; i++) {
			int bid = bucket(nums[i], len, min, max);
			maxs[i] = hasNum[i] ? Math.max(maxs[i], nums[i]) : nums[i];
			mins[i] = hasNum[i] ? Math.min(nums[i], mins[i]) : nums[i];
			hasNum[i]=true;
		}
		int res=0;
		int lastMax=maxs[0];
		for(int i=1;i<=len;i++) {
			if(hasNum[i]) {
				res=Math.max(res, mins[i]-lastMax);
				lastMax=maxs[i];
			}
		}
		return res;
	}

	private static int bucket(int num, int len, int min, int max) {
		return ((num - min) * len) / (max - min);
	}

}
