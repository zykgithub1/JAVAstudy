package Demo02;

public class LinkedSelectionSort {
	public static void main(String[] args) {
		SNode head1=new SNode(8);
		SingleLinkedList list1=new SingleLinkedList(head1);
		list1.add(7);
		list1.add(6);
		list1.add(5);
		list1.add(4);
		list1.traversal();
		list1.setHead(selectionSort(head1));
		list1.traversal();
	}

//	private static SNode selectionSort(SNode head) {
//		if(head==null) {
//			return null;
//		}
//		SNode tail=null;
//		SNode cur=head;
//		SNode small=null;
//		SNode smallPre=null;
//		while(cur!=null) {
//			small=cur;
//			smallPre=getSmallestPreNode(cur);
//			if(smallPre!=null) {
//				small=smallPre.next;
//				smallPre.next=small.next;
//			}
//			cur=cur==small?cur.next:cur;
//			if(tail==null) {
//				head=small;
//			}else {
//				tail.next=small;
//			}
//			tail=small;
//		}
//		return head;
//		
//	}

//	private static SNode getSmallestPreNode(SNode head) {
//		SNode pre=head;
//		SNode small=head;
//		SNode smallPre=null;
//		SNode cur=head.next;
//		while(cur!=null) {
//			if(cur.value<small.value) {
//				smallPre=pre;
//				small=cur;
//			}
//			pre=cur;
//			cur=cur.next;
//		}
//		return smallPre;
//	}
	private static SNode selectionSort(SNode head) {
		if(head==null) {
			return head;
		}
		SNode small=null;
		SNode smallPre=null;
		SNode cur=head;
		SNode tail=null;
		while(cur!=null) {
			small=cur;
			smallPre=getSmallestPreNode(cur);
			if(smallPre!=null) {
				small=smallPre.next;
				smallPre.next=small.next;
			}
			cur=cur==small?cur.next:cur;
			if(tail==null) {
				head=small;
			}else {
				tail.next=small;
			}
			tail=small;
		}
		return head;
	}
	private static SNode getSmallestPreNode(SNode head) {
		SNode pre=head;SNode cur=head.next;
		SNode small=head;SNode smallPre=null;
		while(cur!=null) {
			if(cur.value<small.value) {
				smallPre=pre;
				small=cur;
			}
			pre=pre.next;
			cur=cur.next;
		}
		return smallPre;
	}
}
