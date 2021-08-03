package demo_2021_8_3;

import java.util.PriorityQueue;

public class sortedArrDistanceLessk {
	public static void main(String[] args) {

	}

	public static void samllHeap(int[] arr, int k) {
		PriorityQueue<Integer> que = new PriorityQueue<>();
		int index = 0;
		int len = arr.length;
		for (; index <= Math.min(k, len); index++) {
			que.add(arr[index]);
		}
		int i = 0;
		for (; index <= len; index++, i++) {
			arr[i] = que.poll();
			que.add(arr[index]);
		}
		while (!que.isEmpty()) {
			arr[i++] = que.poll();
		}
	}

}
