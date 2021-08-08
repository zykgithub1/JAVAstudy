package demo_2021_8_8_preFixAndGreedy;

import java.util.PriorityQueue;

public class getMiddleNum {
	public static void main(String[] args) {
		int arr[] = { 6, 5, 4, 3, 3, 2, 1 };
		System.out.println(getMiddle(arr));
	}

	public static double getMiddle(int[] arr) {
		PriorityQueue<Integer> minQ = new PriorityQueue();
		PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>((a, b) -> {
			return b - a;
		});
		maxQ.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] <= maxQ.peek()) {
				maxQ.offer(arr[i]);
			} else {
				minQ.offer(arr[i]);
			}
			if (Math.abs(maxQ.size() - minQ.size()) >= 2) {
				if (maxQ.size() > minQ.size()) {
					minQ.offer(maxQ.poll());
				} else {
					maxQ.offer(minQ.poll());
				}
			}
		}
		if (maxQ.size() > minQ.size()) {
			return (double) maxQ.peek();
		} else if (maxQ.size() == minQ.size()) {
			return (double) (maxQ.peek() + minQ.peek()) / 2;
		} else {
			return (double) minQ.peek();
		}
	}
}
