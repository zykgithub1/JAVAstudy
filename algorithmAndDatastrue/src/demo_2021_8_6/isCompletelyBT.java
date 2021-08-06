package demo_2021_8_6;

import java.util.LinkedList;
import java.util.Queue;

public class isCompletelyBT {
	public static class Node {
		public Node left;
		public Node right;
		public int value;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

	public static boolean isCBT(Node head) {
		Queue<Node> que = new LinkedList();
		Node l = null, r = null;
		que.add(head);
		boolean leaf = false;
		while (!que.isEmpty()) {
			head = que.poll();
			l = head.left;
			r = head.right;
			if ((leaf && (l != null || r != null) || (l == null && r != null))) {
				return false;
			}
			if (l != null) {
				que.offer(l);
			}
			if (r != null)
				que.offer(r);
			if (l == null || r == null) {
				leaf = true;
			}
		}
		return true;
	}
	
	

}
