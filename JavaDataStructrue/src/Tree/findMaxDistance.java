package Tree;

public class findMaxDistance {
	public static class Node {
		private Node left;
		private Node right;
		private int value;
	}

	public static class Info {
		public int height;
		public int maxDistance;

		public Info(int h, int d) {
			this.height = h;
			this.maxDistance = d;
		}
	}

	public static Info process(Node x) {
		if (x == null) {
			return new Info(0, 0);
		}
		Info leftInfo = process(x.left);
		Info rightInfo = process(x.right);
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		int maxDist = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance),
				leftInfo.height + rightInfo.height + 1);
		return new Info(height, maxDist);
	}

	public static Info process2(isBlanceTree.Node x) {
		if (x == null) {
			return new Info(0, 0);
		}
		Info leftInfo = process2(x.left);
		Info rightInfo = process2(x.right);
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		int maxDist = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance),
				leftInfo.height + rightInfo.height + 1);
		return new Info(height, maxDist);
	}

	public static int findMax(isBlanceTree.Node x) {
		return process2(x).maxDistance;
	}

}
