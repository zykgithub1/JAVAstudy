package Demo02;

import java.util.Stack;

public class listSum {
	public static void main(String[] args) {
		SNode head1=new SNode(9);
		SingleLinkedList list1=new SingleLinkedList(head1);
		list1.add(3);
		list1.add(7);
		list1.traversal();
		SNode head2=new SNode(6);
		SingleLinkedList list2=new SingleLinkedList(head2);
		list2.add(3);
		list2.traversal();
		SingleLinkedList list3=new SingleLinkedList(listSum2(list1.head,list2.head));
		list3.traversal();
		list1.traversal();
		list2.traversal();
		
	}

	private static SNode listSum2(SNode head, SNode head2) {
		head=reverse(head);
		head2=reverse(head2);
		SNode c1=head;
		SNode c2=head2;
		int n1,n2,n,ca=0;
		SNode pre=null,node=null;
		while(c1!=null||c2!=null) {
			n1=c1!=null?c1.value:0;
			n2=c2!=null?c2.value:0;
			n=n1+n2+ca;
			pre=node;
			node=new SNode(n%10);
			node.next=pre;
			ca=n/10;
			c1=c1!=null?c1.next:null;
			c2=c2!=null?c2.next:null;
		}
		if(ca!=0) {
			pre=node;
			node=new SNode(1);
			node.next=pre;
		}
		head=reverse(head);
		head2=reverse(head2);
		return node;
	}

	private static SNode reverse(SNode head) {
		SNode pre=null,next=null;
		while(head!=null) {
			next=head.next;
			head.next=pre;
			pre=head;
			head=next;
		}
		return pre;
	}

	private static SNode listSum(SNode head, SNode head2) {
		if(head==null||head2==null) {
			return null;
		}
		SNode tmp=null;
		SingleLinkedList ans=new SingleLinkedList(tmp);
		int sum=0;int ca=0,n1,n2,n;
		Stack<Integer>stack1=new Stack();
		Stack<Integer>stack2=new Stack();
		SNode cur=head;
		while(cur!=null) {
			stack1.push(cur.value);
			cur=cur.next;
		}
		cur=head2;
		while(cur!=null) {
			stack2.push(cur.value);
			cur=cur.next;
		}
		SNode pre=null;
		SNode node=null;
		while(!stack1.isEmpty()||!stack2.isEmpty()) {
			n1=stack1.isEmpty()?0:stack1.pop();
			n2=stack2.isEmpty()?0:stack2.pop();
			n=n1+n2+ca;
			pre=node;
			node=new SNode(n%10);
			node.next=pre;
			ca=n/10;
		}
		if(ca!=0) {
			pre=node;
			node=new SNode(1);
			node.next=pre;
		}
		return node;
		
	}

}
