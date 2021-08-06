package demo_2021_8_6;

import java.util.Stack;

public class isBinarySearchTree {
	public static class Node {
		public Node left;
		public Node right;
		public int value;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

	public static int preValue = Integer.MIN_VALUE;

	public static boolean isBST(Node head) {
		Stack<Node> stack = new Stack();
		while (head != null || !stack.isEmpty()) {
			if (head != null) {
				stack.push(head);
				head = head.left;
			} else {
				head = stack.pop();
				if (preValue >= head.value) {
					return false;
				} else {
					preValue = head.value;
				}
				head = head.right;
			}
		}
		return true;
	}

	public static class Info {
		public boolean isBST;
		public int max;
		public int min;

		public Info(boolean isBST, int max, int min) {
			super();
			this.isBST = isBST;
			this.max = max;
			this.min = min;
		}
	}

	public static Info isBSTReturnInfo(Node head) {
		if (head == null) {
			return null;
		}
		Info leftInfo = isBSTReturnInfo(head.left);
		Info rightInfo = isBSTReturnInfo(head.right);
		int min = head.value;
		int max = head.value;
		if (leftInfo != null) {
			min = Math.min(min, leftInfo.min);
			max = Math.max(max, leftInfo.max);
		}
		if (rightInfo != null) {
			min = Math.min(min, rightInfo.min);
			max = Math.max(max, rightInfo.max);
		}
		boolean isBst = true;
		if (leftInfo != null && (!leftInfo.isBST || leftInfo.max >= head.value)) {
			isBst = false;
		}
		if (rightInfo != null && (!rightInfo.isBST || rightInfo.min <= head.value)) {
			isBst = false;
		}
		return new Info(isBst, max, min);
	}

}
