package demo_2021_8_24_;

public class MaxSubBstSize {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	public static class Info {
		public Node maxBSTHead;
		public boolean isBST;
		public int maxNum;
		public int minNum;
		public int BSTSize;

		public Info(Node maxBSTHead, boolean isBST, int maxNum, int minNum, int bSTSize) {
			this.maxBSTHead = maxBSTHead;
			this.isBST = isBST;
			this.maxNum = maxNum;
			this.minNum = minNum;
			BSTSize = bSTSize;
		}
	}

	public static Info process(Node head) {
		if (head == null) {
			return new Info(null, true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
		}
		Info leftInfo = process(head.left);
		Info rightInfo = process(head.right);
		int maxNum = head.value;
		int minNum = head.value;
		int BSTSize = 0;
		boolean isBST = false;
		Node maxBSTHead = null;
		if (leftInfo != null) {
			maxNum = Math.max(maxNum, leftInfo.maxNum);
			minNum = Math.min(leftInfo.minNum, minNum);
			BSTSize = Math.max(leftInfo.BSTSize, BSTSize);
			maxBSTHead = leftInfo.maxBSTHead;
		}
		if (rightInfo != null) {
			maxNum = Math.max(maxNum, rightInfo.maxNum);
			minNum = Math.min(rightInfo.minNum, minNum);
			if (rightInfo.BSTSize > BSTSize) {
				BSTSize = rightInfo.BSTSize;
				maxBSTHead = rightInfo.maxBSTHead;
			}
		}
		if (((leftInfo == null || leftInfo.isBST) && (rightInfo == null || rightInfo.isBST))) {
			if ((leftInfo == null || leftInfo.maxNum < head.value)
					&& (rightInfo == null || rightInfo.minNum > head.value)) {
				isBST = true;
				int leftMsize = leftInfo == null ? 0 : leftInfo.BSTSize;
				int rightMsize = rightInfo == null ? 0 : rightInfo.BSTSize;
				BSTSize = leftMsize + 1 + rightMsize;
				maxBSTHead = head;
			}
		}
		return new Info(maxBSTHead, isBST, maxNum, minNum, BSTSize);
	}

}
