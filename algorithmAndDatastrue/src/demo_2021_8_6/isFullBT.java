package demo_2021_8_6;

public class isFullBT {
	public static class Node {
		public Node left;
		public Node right;
		public int value;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

	public static class Info {
		public int nodes;
		public int height;

		public Info(int nodes, int height) {
			super();
			this.nodes = nodes;
			this.height = height;
		}
	}

	public static Info isFull(Node head) {
		if (head == null) {
			return new Info(0, 0);
		}
		Info leftInfo = isFull(head.left);
		Info rigthInfo = isFull(head.right);

		int height = Math.max(leftInfo.height, rigthInfo.height) + 1;
		int nodes = leftInfo.nodes + rigthInfo.nodes + 1;
		return new Info(nodes, height);
	}

}
