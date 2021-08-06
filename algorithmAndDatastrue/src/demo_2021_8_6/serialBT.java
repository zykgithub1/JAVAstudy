package demo_2021_8_6;

import java.util.LinkedList;
import java.util.Queue;

public class serialBT {
	public static class Node {
		public Node left;
		public Node right;
		public int value;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

	public static String serialByPre(Node head) {
		StringBuilder sb = new StringBuilder();
		dfs(head, sb);
		return sb.toString();
	}

	private static void dfs(Node head, StringBuilder sb) {
		if (head == null) {
			sb.append("#_");
		}
		sb.append(head.value);
		sb.append("_");
		dfs(head.left, sb);
		dfs(head.right, sb);
	}

	public static Node reconBypreString(String preStr) {
		String[] values = preStr.split("_");
		Queue<String> que = new LinkedList();
		for (int i = 0; i < values.length; i++) {
			que.add(values[i]);
		}
		return reconPreOrder(que);
	}

	private static Node reconPreOrder(Queue<String> que) {
		String cur = que.poll();
		if (cur.equals("#")) {
			return null;
		}
		Node head = new Node(Integer.parseInt(cur));
		head.left = reconPreOrder(que);
		head.right = reconPreOrder(que);
		return head;
	}

}
