package demo_2021_9_4_;

public class hanoiMove {
	public static void main(String[] args) {
		int[]arr= {3,2,1};
		System.out.println(step1(arr));
	}
	public static int step1(int[]arr) {
		if(arr==null||arr.length==0) {
			return -1;
		}
		return process(arr,arr.length-1,1,2,3);
		
	}
	/*
	 * 目标是把0-i的圆盘，从from全部挪到to上
	 * 返回，arr中的状态arr[0-i],它是最优解的第几步
	 */
	private static int process(int[] arr, int i, int from, int other, int to) {
		if(i==-1) {
			return 0;
		}
		if(arr[i]!=from&&arr[i]!=to) {
			return -1;
		}
		if(arr[i]==from) {
			return process(arr, i-1, from, to, other);
		}else {
			int rest=process(arr, i-1, other, from, to);
			if(rest==-1) {
				return -1;
			}
			return (1<<i)+rest;
		}
	}

}
