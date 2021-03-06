package Tree;

public class isBlanceTree {
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
		System.out.println(isBalance2(tree));
		System.out.println(findMaxDistance.findMax(tree));
		System.out.println(findMaxBSTHead.getBSTHead(tree));
	}

	public static class Node {
		Node left;
		Node right;
		public int value;
		public static Node root = null;

		public Node(int value2) {
			this.value=value2;
		}

		public static void show(Node x) {
			if (x == null) {
				return;
			}
			show(x.left);
			System.out.print(x.getValue());
			show(x.right);
		}

		public int getValue() {
			return this.value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}

	public static class Info {
		private boolean isBalance;
		private int height;

		public Info(boolean b, int h) {
			this.height = h;
			this.isBalance = b;
		}
	}

	public static Info process2(Node x) {
		if (x == null) {
			return new Info(true, 0);
		}
		Info leftInfo = process2(x.left);
		Info rightInfo = process2(x.right);
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		boolean isbalance = true;
		if (leftInfo.isBalance == false || rightInfo.isBalance == false
				|| Math.abs(leftInfo.height - rightInfo.height) > 1) {
			isbalance = false;
		}
		return new Info(isbalance, height);
	}

	public static boolean isBalance2(Node root) {
		return process2(root).isBalance;
	}

}
