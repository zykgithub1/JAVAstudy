package demo_2021_9_27_leetcode;

import java.util.Stack;

public class twoSumAdd {
	static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int val) {
			super();
			this.val = val;
		}

	}

	static class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			Stack<Integer> s1 = new Stack();
			Stack<Integer> s2 = new Stack();
			ListNode cur = l1;
			while (cur != null) {
				s1.push(cur.val);
				cur = cur.next;
			}
			cur = l2;
			while (cur != null) {
				s2.push(cur.val);
				cur = cur.next;
			}
			int num1 = 0;
			int num2 = 0;
			int sum = 0;
			int jinwei = 0;
			ListNode ans = new ListNode(0);
			ListNode link = ans;
			while (!s1.isEmpty() || !s2.isEmpty()) {
				num1 = !s1.isEmpty() ? s1.pop() : 0;
				num2 = !s2.isEmpty() ? s2.pop() : 0;
				sum = num1 + num2 + jinwei;
				jinwei = sum >= 10 ? 1 : 0;
				ListNode temp = new ListNode(sum % 10);
				temp.next = ans.next;
				ans.next = temp;
			}
			if (jinwei != 0) {
				ListNode t = new ListNode(1);
				t.next = ans.next;
				ans.next = t;
			}
			return ans.next;
		}
	}

}
