package demo_2021_8_4;

import java.util.HashMap;

import alogrithmUtils.randNode;

public class copyRandNode {
	public static void main(String[] args) {

	}

	public static randNode copyRandNode(randNode head) {
		HashMap<randNode, randNode> map = new HashMap<>();
		randNode cur = head;
		while (cur != null) {
			map.put(cur, new randNode(cur.value));
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			map.get(cur).rand = map.get(cur.rand);
			map.get(cur).next = map.get(cur.next);
			cur = cur.next;
		}
		return map.get(head);
	}

	public static randNode coRandNodeNoMap(randNode head) {
		randNode cur = head;
		randNode next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = new randNode(cur.value);
			cur.next.next = next;
			cur = next;
		}
		randNode curCopy = null;
		cur = head;
		while (cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			curCopy.rand = cur.rand != null ? cur.rand.next : null;
			cur = next;
		}
		randNode ans = head.next;
		cur = head;
		while (cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			curCopy.next = next != null ? next.next : null;
			cur = next;
		}
		return ans;
	}

}
