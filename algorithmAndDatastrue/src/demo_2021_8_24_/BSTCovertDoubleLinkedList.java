package demo_2021_8_24_;

public class BSTCovertDoubleLinkedList {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	public static class Info {
		public Node tou;
		public Node end;

		public Info(Node head, Node end) {
			this.tou = head;
			this.end = end;
		}

	}

	public static Info covert(Node head) {
		if (head == null) {
			return new Info(null, head);
		}
		Info leftInfo = covert(head.left);
		Info rightInfo = covert(head.right);
		if (leftInfo.end != null) {
			leftInfo.end.right = head;
		}
		head.left = leftInfo.end;
		head.right = rightInfo.tou;
		if (rightInfo.tou != null) {
			rightInfo.tou.left = head;
		}
		return new Info(leftInfo.tou != null ? leftInfo.tou : head, 
				       rightInfo.tou != null ? rightInfo.end : head);
	}

}
