package demo_2021_8_6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class findMostCloseAncestor {
	public static class Node {
		public Node left;
		public Node right;
		public int value;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

	public static void main(String[] args) {

	}

	public static Node LowestCommonAncestor(Node head, Node o1, Node o2) {
		HashMap<Node, Node> fatherMap = new HashMap<>();
		fatherMap.put(head, head);
		Set<Node> set1 = new HashSet();
		Node cur = o1;
		while (fatherMap.get(cur) != head) {
			set1.add(cur);
			cur = fatherMap.get(cur);
		}
		set1.add(head);
		while (fatherMap.get(o2) != head) {
			if (set1.contains(o2)) {
				return o2;
			}
			o2 = fatherMap.get(o2);
		}
		return null;
	}

	public static Node LowestCommonAncestorRe(Node root, Node o1, Node o2) {
		if (root == null || root == o1 || root == o2) {
			return root;
		}
		Node l = LowestCommonAncestorRe(root.left, o1, o2);
		Node r = LowestCommonAncestorRe(root.left, o1, o2);
		if (l != null && r != null) {
			return root;
		}
		return l != null ? l : r;
	}

	public static void process(Node head, HashMap<Node, Node> fatherMap) {
		if (head == null) {
			return;
		}
		fatherMap.put(head.left, head);
		fatherMap.put(head.right, head);
		process(head.left, fatherMap);
		process(head.right, fatherMap);
	}

}
