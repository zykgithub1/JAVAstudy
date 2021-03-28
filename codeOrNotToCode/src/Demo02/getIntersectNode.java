package Demo02;

public class getIntersectNode {
	public static void main(String[] args) {
		SNode head1=new SNode(1);//head
		SingleLinkedList list1=new SingleLinkedList(head1);
		list1.add(2);//head.next
		list1.add(3);//head.n.n
		list1.add(4);//h.n.n.n
		list1.add(5);//h.n.n.n.n
		list1.add(6);//h.n.n.n.n.n
		list1.add(7);
		//list1.findLast().next=list1.head.next.next;
		list1.traversal();
		SNode head2=new SNode(2);
		
		SingleLinkedList list2=new SingleLinkedList(head2);
		list2.findLast().next=list1.head.next.next.next.next;
		list2.traversal();
		//list2.findLast().next=list1.head.next.next.next;
		SNode ans=getIntersectNode(list1.head,list2.head);
		System.out.println(ans.value);
	}

	private static SNode getIntersectNode(SNode head, SNode head2) {
		if(head==null||head2==null) {
			return null;
		}
		SNode loop1=getLoopNode(head);
		SNode loop2=getLoopNode(head2);
		if(loop1==null&&loop2==null) {
			return noLoop(head,head2);
		}
		return null;
	}

	private static SNode noLoop(SNode head, SNode head2) {
		if(head==null||head2==null) {
			return head;
		}
		int n=0;
		SNode cur=head;
		SNode cur2=head2;
		while(cur.next!=null) {
			n++;
			cur=cur.next;
		}
		cur2=head2;
		while(cur2.next!=null) {
			n--;
			cur2=cur2.next;
		}
		if(cur!=cur2) {
			return null;
		}
		cur=n>0?head:head2;
		cur2=cur==head?head2:head;
		Math.abs(n);
		while(n>0) {
			n--;
			cur=cur.next;
		}
		while(cur!=cur2) {
			cur=cur.next;
			cur2=cur2.next;
		}
		return cur;
	}

	private static SNode getLoopNode(SNode head) {
		if(head==null||head.next==null||head.next.next==null) {
			return null;
		}
		SNode fast=head.next.next;
		SNode slow=head.next;
		while(fast!=slow) {
			if(fast.next==null||fast.next.next==null) {
				return null;
			}
			fast=fast.next.next;
			slow=slow.next;
		}
		fast=head;
		while(fast!=slow) {
			fast=fast.next;
			slow=slow.next;
		}
		return fast;
	}

}


