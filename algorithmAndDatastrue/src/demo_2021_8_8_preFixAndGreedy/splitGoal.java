package demo_2021_8_8_preFixAndGreedy;

import java.util.PriorityQueue;

public class splitGoal {
	/**
	 * equal to huffman code
	 */
	public static int lessMoney(int[] arr) {
		PriorityQueue<Integer> que = new PriorityQueue();
		for (int num : arr) {
			que.add(num);
		}
		int sum = 0;
		int cur = 0;
		while (que.size() > 1) {
			cur = que.poll() + que.poll();
			sum += cur;
			que.add(cur);
		}
		return sum;
	}

	public static class Node {
		public int p;
		public int c;

		public Node(int p, int c) {
			super();
			this.p = p;
			this.c = c;
		}

	}

	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Captital) {
		PriorityQueue<Node> minCost = new PriorityQueue<Node>((a, b) -> {
			return a.c - b.c;
		});
		PriorityQueue<Node> maxProfits = new PriorityQueue<Node>((a, b) -> {
			return b.p - a.p;
		});
		for (int i = 0; i < Profits.length; i++) {
			minCost.add(new Node(Profits[i], Captital[i]));
		}
		for (int i = 0; i < k; i++) {
			while (!minCost.isEmpty() && minCost.peek().c <= W) {
				maxProfits.offer(minCost.poll());
			}
			if (maxProfits.isEmpty()) {
				return W;
			}
			W += maxProfits.poll().p;
		}
		return W;
	}
}
