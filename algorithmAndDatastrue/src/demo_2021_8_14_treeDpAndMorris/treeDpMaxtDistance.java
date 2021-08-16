package demo_2021_8_14_treeDpAndMorris;

public class treeDpMaxtDistance {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

	public static class Info {
		public int maxDistance;
		public int height;

		public Info(int maxDistance, int height) {
			super();
			this.maxDistance = maxDistance;
			this.height = height;
		}
	}

	public static int maxDistance(Node head) {
		if (head == null) {
			return 0;
		}
		return process(head).maxDistance;
	}

	private static Info process(Node head) {
		if (head == null) {
			return new Info(0, 0);
		}
		Info leftInfo = process(head.left);
		Info rightInfo = process(head.right);
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		int max = Math.max(leftInfo.maxDistance,
				Math.max(rightInfo.maxDistance, leftInfo.height + rightInfo.height + 1));
		return new Info(max, height);
	}

}
