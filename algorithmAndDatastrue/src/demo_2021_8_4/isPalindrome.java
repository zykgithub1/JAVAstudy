package demo_2021_8_4;

import java.util.Stack;

import alogrithmUtils.Node;

public class isPalindrome {
	public static void main(String[] args) {

	}

	public static boolean isPalindrome1(Node head) {
		Node cur = head;
		Stack<Node> stack = new Stack();
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (head != null) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	public static boolean ispalindrome2(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		boolean ans = true;
		Node n1 = head, n2 = head;
		while (n2.next != null && n2.next.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
		}
		Node n3 = null;
		n2 = n1.next;
		n1.next = null;
		while (n2 != null) {
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		n3 = n1;
		n2 = head;
		while (n1 != null && n2 != null) {
			if (n1.value != n2.value) {
				ans = false;
				break;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		n1 = n3.next;
		n3.next = null;
		while (n1 != null) {
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return ans;
	}

}
