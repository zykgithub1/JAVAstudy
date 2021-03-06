package selfTest;

import Tree.isBlanceTree.Node;

public class selfTestTree {
	public static void main(String[] args) {
		Node tree = new Node(4);
		tree.left = new Node(2);
		tree.left.left = new Node(1);
		tree.left.right = new Node(3);
		tree.right = new Node(7);
		tree.right.left = new Node(6);
		tree.right.left.left = new Node(9);
		tree.right.right = new Node(8);
		tree.show(tree);
		System.out.println();
		System.out.println(isBalanceTree(tree));
		System.out.println(findMaxDistance(tree));
		System.out.println(findBSTNum(tree));
	}

	public static class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public static void show(Node x) {
			if (x == null) {
				return;
			}
			show(x.left);
			System.out.print(x.value + "  ");
			show(x.right);
		}
	}

	public static class balanceInfo {
		public int height;
		public boolean isbalance;

		public balanceInfo(int height, boolean isbalance) {
			this.height = height;
			this.isbalance = isbalance;
		}
	}

	public static boolean isBalanceTree(Node x) {
		return progress1(x).isbalance;
	}

	public static balanceInfo progress1(Node x) {
		if (x == null) {
			return new balanceInfo(0, true);
		}
		balanceInfo leftInfo = progress1(x.left);
		balanceInfo rightInfo = progress1(x.right);
		int height = 0;
		height = Math.max(leftInfo.height, rightInfo.height) + 1;
		boolean isBlance = false;
		if (leftInfo.isbalance == true && rightInfo.isbalance == true
				&& Math.abs(leftInfo.height - rightInfo.height) < 2) {
			isBlance = true;
		}
		return new balanceInfo(height, isBlance);
	}

	public static class distanceInfo {
		private int height;
		private int maxDistance;

		public distanceInfo(int height, int maxDistance) {
			super();
			this.height = height;
			this.maxDistance = maxDistance;
		}
	}

	public static int findMaxDistance(Node x) {
		return process2(x).maxDistance;
	}

	public static distanceInfo process2(Node x) {
		if (x == null) {
			return new distanceInfo(0, 0);
		}
		distanceInfo leftDisInfo = process2(x.left);
		distanceInfo rightDisInfo = process2(x.right);
		int height = 0;
		height = Math.max(leftDisInfo.height, rightDisInfo.height) + 1;
		int maxDistance = 0;
		maxDistance = Math.max(Math.max(leftDisInfo.height, rightDisInfo.height),
				(leftDisInfo.height + rightDisInfo.height) + 1);
		return new distanceInfo(height, maxDistance);
	}

	public static class BSTInfo {
		private boolean isBSTree;
		private int maxBSTSize;
		private int min;
		private int max;

		public BSTInfo(boolean isBSTree, int maxBSTSize, int min, int max) {
			this.isBSTree = isBSTree;
			this.maxBSTSize = maxBSTSize;
			this.min = min;
			this.max = max;
		}
	}

	public static BSTInfo process3(Node x) {
		if (x == null) {
			return null;
		}
		BSTInfo leftBSTInfo = process3(x.left);
		BSTInfo rightBSInfo = process3(x.right);
		boolean isBSTree = false;
		int maxBSTSize = 0;
		int min = x.value;
		int max = x.value;
		if (leftBSTInfo != null) {
			maxBSTSize = leftBSTInfo.maxBSTSize;
			max = Math.max(leftBSTInfo.max, max);
			min = Math.min(min, leftBSTInfo.min);
		}
		if (rightBSInfo != null) {
			maxBSTSize = Math.max(maxBSTSize, rightBSInfo.maxBSTSize);
			max = Math.max(max, rightBSInfo.max);
			min = Math.min(min, rightBSInfo.min);
		}
		if (      leftBSTInfo == null ? true
				: leftBSTInfo.isBSTree && rightBSInfo == null ? true
						: rightBSInfo.isBSTree && x.value > leftBSTInfo.max && x.value < rightBSInfo.min) {
			isBSTree = true;
			maxBSTSize = (leftBSTInfo == null ? 0 : leftBSTInfo.maxBSTSize)
					+ (rightBSInfo == null ? 0 : rightBSInfo.maxBSTSize) + 1;
		}
		return new BSTInfo(isBSTree, maxBSTSize, min, max);
	}

	public static int findBSTNum(Node x) {
		return process3(x).maxBSTSize;
	}

}
