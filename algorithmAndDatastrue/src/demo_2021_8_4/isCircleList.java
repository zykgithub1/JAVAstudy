package demo_2021_8_4;

import java.util.HashSet;
import java.util.Set;

import alogrithmUtils.Node;

public class isCircleList {
	public static void main(String[] args) {

	}

	public static Node getIntersectNode(Node head1, Node head2) {
		Node loop1 = isCircleFastSlowPoint(head1);
		Node loop2 = isCircleFastSlowPoint(head2);
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}

	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		if (loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1.next != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2.next != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n > 0) {
				cur1 = cur1.next;
				n--;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return cur1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}

	public static Node isCircleFastSlowPoint(Node head) {
		Node fast = head.next.next, slow = head.next;
		while (fast != slow) {
			if (fast.next == null || fast.next.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}

	public static Node noLoop(Node head1, Node head2) {
		Node h1 = head1, h2 = head2;
		int n = 0;
		while (h1.next != null) {
			n++;
			h1 = h1.next;
		}
		while (h2.next != null) {
			n--;
			h2 = h2.next;
		}
		if (h1 != h2) {
			return null;
		}
		h1 = n > 0 ? head1 : head2;
		h2 = h1 == head1 ? head2 : head1;
		n = Math.abs(n);
		while (n > 0) {
			h1 = h1.next;
			n--;
		}
		while (h1 != h2) {
			h1 = h1.next;
			h2 = h2.next;
		}
		return h1;
	}

	public static Node isCircleReturnEnter(Node head) {
		Set<Node> set = new HashSet();
		Node cur = head;
		while (cur != null) {
			if (set.contains(cur)) {
				return cur;
			} else {
				set.add(cur);
			}
			cur = cur.next;
		}
		return null;
	}
}
