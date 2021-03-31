package Demo02;

import java.util.Stack;

public class reverseKth {
	public static void main(String[] args) {
		SNode head = new SNode(1);
		SingleLinkedList list = new SingleLinkedList(head);
		for (int i = 2; i <= 8; i++) {
			list.add(i);
		}
		list.traversal();
		list.setHead(reverseNode2(list.head, 3));
		System.out.println("reverse后");
		list.traversal();
		list.setHead(reverseNode1(list.head, 3));
		list.traversal();
	}

	private static SNode reverseNode2(SNode head, int k) {
		if (k < 2) {
			return head;
		}
		SNode cur = head;
		SNode pre = null;
		SNode next = null;
		SNode start = null;
		int count = 1;
		while (cur != null) {
			next = cur.next;
			if (count == k) {
				start = pre == null ? head : pre.next;// 你要知道这条要反转的链表它的起点吧
				head = pre == null ? cur : head; // 头节点特殊处理
				resign2(pre, start, cur, next);
				pre=start;
				count=0;
			}
			count++;
			cur=next;
		}
		return head;
	}

	/**
	 * 
	 * @param left  前一组的最后一个节点
	 * @param start 当前逆序的起始节点
	 * @param end   当前小段的最后一个点
	 * @param right 下一段的起点
	 */
	private static void resign2(SNode left, SNode start, SNode end, SNode right) {
		SNode pre=start;
		SNode cur=start.next;
		SNode next=null;
		while(cur!=right) {
			next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
		}
		if(left!=null) {
			left.next=pre;
		}
		start.next=right;
	}

//	private static SNode reverseNode1(SNode head, int k) {
//		if(k<2) {
//			return head;
//		}
//		Stack<SNode> stack=new Stack();
//		SNode cur=head;
//		SNode pre=null;
//		SNode next=null;
//		SNode newHead=head;
//		while(cur!=null) {
//			next=cur.next;
//			stack.add(cur);
//			if(stack.size()==k) {
//				pre=asign(stack,pre,next);
//				newHead=newHead==head?cur:newHead;
//			}
//			cur=next;
//		}
//		return newHead;
//	}

//	private static SNode asign(Stack<SNode> stack, SNode pre, SNode next) {
//		SNode cur=stack.pop();
//		if(pre!=null) {
//			pre.next=cur;
//		}
//		while(!stack.isEmpty()) {
//			SNode tmp=stack.pop();
//			cur.next=tmp;
//			cur=tmp;
//		}
//		cur.next=next;
//		return cur;
//	}
	private static SNode asign(Stack<SNode> stack, SNode pre, SNode next) {
		SNode cur = stack.pop();
		if (pre != null) {
			pre.next = cur;
		}
		SNode tmp = null;
		while (!stack.isEmpty()) {
			tmp = stack.pop();
			cur.next = tmp;
			cur = tmp;
		}
		tmp.next = next;
		return tmp;
	}

	private static SNode reverseNode1(SNode head, int k) {
		if (k < 2) {
			return head;
		}
		Stack<SNode> stack = new Stack();
		SNode cur = head;
		SNode next = null;
		SNode pre = null;
		SNode newHead = null;
		while (cur != null) {
			next = cur.next;
			stack.add(cur);
			if (stack.size() == k) {
				newHead = pre == null ? cur : newHead;
				pre = asign(stack, pre, next);
			}
			cur = next;
		}
		return newHead;
	}
}
