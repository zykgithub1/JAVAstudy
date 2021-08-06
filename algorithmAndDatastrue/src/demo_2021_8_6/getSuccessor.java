package demo_2021_8_6;

public class getSuccessor {
	public static class Node {
		public Node left;
		public Node right;
		public Node father;
		public int value;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

	public static Node getSuccessorNode(Node node) {
		if (node == null) {
			return null;
		}
		if (node.right != null) {
			return getRightMostLeft(node.right);
		} else {
			Node parent = node.father;
			while (parent != null && parent.left != node) {
				node = parent;
				parent = node.father;
			}
			return parent;
		}
	}

	private static Node getRightMostLeft(Node right) {
		while (right.left != null) {
			right = right.left;
		}
		return right;
	}

}
