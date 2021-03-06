package selfTestFirstChapter;

import java.util.LinkedList;

public class maxSubNumsEqualN {
	public static void main(String[] args) {
		int arr[] = { 1,2,3,4,5 };
		int n = getNum(arr, 2);
		System.out.println(n);
	}

	private static int getNum(int[] arr, int num) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int res=0;
		LinkedList<Integer> qmin = new LinkedList<>();
		LinkedList<Integer> qmax = new LinkedList<>();
		int i = 0, j = 0;
		while (i < arr.length) {
			while (j< arr.length) {
				while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
					qmin.pollLast();
				}
				qmin.addLast(j);
				while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
					qmax.pollLast();
				}
				qmax.addLast(j);
				if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
					break;
				}
				j++;
			}
			if(qmax.peekFirst()==i) {
				qmax.pollFirst();
			}
			if(qmin.peekFirst()==i) {
				qmin.pollFirst();
			}
			res+=j-i;
			i++;
		}
		return res;
	}

}
