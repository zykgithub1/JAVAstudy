package Demo02;

import java.util.HashSet;

public class delRepetitionNodes {
	public static void main(String[] args) {
		SNode head=new SNode(1);
		SingleLinkedList list=new SingleLinkedList(head);
		list.add(1);list.add(1);list.add(1);list.add(1);list.add(1);list.add(1);list.add(1);
		//removeRep(list.head);
		removerRep2(head);
		list.traversal();
	}

	private static void removerRep2(SNode head) {
		if(head==null) {
			return;
		}
		SNode cur=head;
		SNode pre=null;
		SNode next=null;
		while(cur!=null) {
			pre=cur;
			next=cur.next;
			while(next!=null) {
				if(next.value==cur.value) {
					pre.next=next.next;
				}else {
					pre=next;
				}
				next=next.next;
			}
			cur=cur.next;
		}
		
	}


	private static void removeRep(SNode head) {
		if(head==null) {
			System.out.println("empty");
			return;
		}
		SNode pre=head;
		SNode cur=pre.next;
		HashSet<Integer>set=new HashSet();
		set.add(pre.value);
		while(cur!=null) {
			if(set.contains(cur.value)) {
				pre.next=cur.next;
			}else {
				set.add(cur.value);
				pre=cur;
			}
			cur=cur.next;
		}
	}

}
