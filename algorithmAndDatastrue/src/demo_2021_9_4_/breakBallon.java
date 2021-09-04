package demo_2021_9_4_;

public class breakBallon {
	public static void main(String[] args) {
		int[]arr= {3,2,5,4,3,2,5,4,3,2,4,5,6,4};
		System.out.println(getMaxScore(arr));
	}
	public static int getMaxScore(int[] arr) {
		int n = arr.length;
		int[] help = new int[n + 2];
		help[0] = 1;
		for (int i = 1; i <= n; i++) {
			help[i] = arr[i - 1];
		}
		help[n + 1] = 1;
		return process(help, 1, n);
	}

	/*
	 * 打爆[L,R]范围上的所有气球，返回最大的分数 假设arr[L-1]和arr[R+1]一定没有被打爆 尝试的方法，每一个位置的气球最后打爆
	 */
	private static int process(int[] arr, int l, int r) {
		if (l == r) {
			return arr[l - 1] * arr[l] * arr[l + 1];
		}
		// 最后打爆l和r的方案比较一下
		int max = Math.max(arr[l - 1] * arr[l] * arr[r + 1] + process(arr, l + 1, r),
				           arr[l - 1] * arr[r] * arr[r + 1] + process(arr, l, r - 1));
		//尝试中间位置的气球最后打爆的每一种方案
		for(int i=l+1;i<r;i++) {
			max=Math.max(max, arr[l-1]*arr[i]*arr[r+1]+process(arr, l, i-1)+process(arr, i+1, r));
		}
		return max;
	}

}
