package Demo02;

import java.util.Stack;

public class isPalindrome {
	public static void main(String[] args) {
		SNode head1=new SNode(1);
		SingleLinkedList list1=new SingleLinkedList(head1);
		list1.add(2);
		list1.add(3);
		list1.add(3);
		list1.add(2);
		list1.add(1);
		list1.traversal();
		boolean ans=ispalindrome1(list1);
		list1.traversal();
		boolean ans2=ispalindrome2(list1);
		list1.traversal();
		boolean ans3=ispalindrome3(list1);
		System.out.println(ans+"  "+ans2);
		System.out.println(ans3);
		list1.traversal();
	}

	private static boolean ispalindrome3(SingleLinkedList list1) {
		if(list1.head==null) {
			return false;
		}
		SNode n1=list1.head;
		SNode n2=list1.head;
		while(n2.next!=null&&n2.next.next!=null) {
			n1=n1.next;
			n2=n2.next.next;
		}
		n2=n1.next;
		n1.next=null;
		SNode n3=null;
		while(n2!=null) {
			n3=n2.next;
			n2.next=n1;
			n1=n2;
			n2=n3;
		}
		n3=n1;
		n2=list1.head;
		boolean flag=true;
		while(n1!=null&&n2!=null) {
			if(n1.value!=n2.value) {
				flag=false;
				break;
			}
			n1=n1.next;n2=n2.next;
		}
		n1=n3.next;
		n3.next=null;
		while(n1!=null) {
			n2=n1.next;
			n1.next=n3;
			n3=n1;
			n1=n2;
		}
		return flag;
	}

	private static boolean ispalindrome2(SingleLinkedList list1) {
		SNode cur=list1.head;
		if(cur==null) {
			return false;
		}
		SNode right=cur.next;
		while(cur.next!=null&&cur.next.next!=null) {
			cur=cur.next.next;
			right=right.next;
		}
		Stack<Integer>stack=new Stack();
		while(right!=null) {
			stack.add(right.value);
			right=right.next;
		}
		cur=list1.head;
		while(!stack.isEmpty()) {
			if(cur.value!=stack.pop()) {
				return false;
			}
			cur=cur.next;
		}
		return true;

	}

	private static boolean ispalindrome1(SingleLinkedList list1) {
		SNode cur=list1.head;
		if(list1.head==null||list1.head.next==null) {
			return false;
		}
		boolean flag=true;
		Stack<Integer>stack=new Stack();
		while(cur!=null) {
			stack.push(cur.value);
			cur=cur.next;
		}
		cur=list1.head;
		while(cur!=null) {
			if(cur.value!=stack.pop()) {
				flag=false;
				return flag;
			}
			cur=cur.next;
		}
		return flag;
	}
	

}
