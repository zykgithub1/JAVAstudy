package demo_2021_8_20_;

import demo_2021_8_5.traversal.Node;

public class BTPathMaxSum {
	public static class Node {
		public Node left;
		public Node right;
		public int value;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

	static int maxSum = Integer.MIN_VALUE;

	public static int maxPath(Node head) {
		p(head, 0);
		return maxSum;
	}

	private static void p(Node head, int sum) {
		if (head.left == null && head.right == null) {
			maxSum = Math.max(maxSum, sum + head.value);
			return;
		}
		if (head.left != null) {
			p(head.left, sum + head.value);
		}
		if (head.right != null) {
			p(head.right, sum + head.right.value);
		}
	}

	public static int process2(Node head) {
		if (head.left == null && head.right == null) {
			return head.value;
		}
		int next = Integer.MIN_VALUE;
		if (head.left != null) {
			next = process2(head.left);
		}
		if (head.right != null) {
			next = Math.max(next, process2(head.right));
		}
		return next + head.value;
	}

}
