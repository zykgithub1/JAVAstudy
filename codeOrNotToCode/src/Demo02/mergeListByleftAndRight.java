package Demo02;

public class mergeListByleftAndRight {
	public static void main(String[] args) {
		SNode head1=new SNode(1);
		SingleLinkedList list1=new SingleLinkedList(head1);
		list1.add(2);
		list1.add(3);
//		list1.add(4);
////		list1.add(5);
////		list1.add(6);
		list1.traversal();
		System.out.println();
		relocate(list1.head);
		list1.traversal();
	}

	private static void relocate(SNode head) {
		if(head==null||head.next==null) {
			return;
		}
		SNode right=head.next;
		SNode mid=head;
		while(right.next!=null&&right.next.next!=null) {
			right=right.next.next;
			mid=mid.next;
		}
		right=mid.next;
		mid.next=null;
		merger(head,right);
	}

	private static void merger(SNode left, SNode right) {
		SNode next=null;
		while(left.next!=null) {
			next=right.next;
			right.next=left.next;
			left.next=right;
			left=left.next.next;
			right=next;
		}
		left.next=right;
	}

}
