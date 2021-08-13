package demo_2021_8_13;

import java.util.LinkedList;

public class slidingWindow {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
		int[] ans = process(arr, 3);
		for (int nu : ans) {
			System.out.printf(nu + " ");
		}
		System.out.println();
	}

	private static int[] process(int[] arr, int window) {
		int n = arr.length;
		int size = arr.length - window + 1;
		int[] res = new int[size];
		int index = 0;
		LinkedList<Integer> que = new LinkedList();
		for (int i = 0; i < n; i++) {
			while (!que.isEmpty() && arr[que.peekLast()] <= arr[i]) {
				que.pollLast();
			}
			que.add(i);
			if (que.peekFirst() == i - window) {
				que.pollFirst();
			}
			if (i >= window - 1) {
				res[index++] = arr[que.peekFirst()];
			}
		}
		return res;
	}

}
