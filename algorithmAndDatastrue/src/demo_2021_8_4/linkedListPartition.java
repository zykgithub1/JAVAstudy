package demo_2021_8_4;

import alogrithmUtils.Node;

public class linkedListPartition {

	public static Node listPartition(Node head, int povid) {
		Node sh = null;
		Node st = null;
		Node eh = null;
		Node et = null;
		Node bh = null;
		Node bt = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < povid) {
				if (sh == null) {
					sh = head;
					st = head;
				} else {
					st.next = head;
					st = st.next;
				}
			} else if (head.value == povid) {
				if (eh == null) {
					eh = head;
					et = head;
				} else {
					et.next = head;
					et = et.next;
				}
			} else {
				if (bh == null) {
					bh = head;
					bt = head;
				} else {
					bt.next = head;
					bt = bt.next;
				}
			}
			head = head.next;
		}
		if (st != null) {
			st.next = eh;
			et = et == null ? st : et;
		}
		if (et != null) {
			et.next = bh;
		}
		return sh != null ? sh : eh != null ? eh : bh;
	}

}
