package Demo02;

public class O1MegerTwoIncreaseList {
	public static void main(String[] args) {
		SNode head1=new SNode(1);
		SingleLinkedList list1=new SingleLinkedList(head1);
		list1.add(5);
		list1.add(6);
		list1.traversal();System.out.println();
		SNode head2=new SNode(2);
		SingleLinkedList list2=new SingleLinkedList(head2);
		list2.add(3);
		list2.add(7);
		list2.traversal();
		System.out.println();
		list1.setHead(meger(head1,head2));
		list1.traversal();

	}

	private static SNode meger(SNode head1, SNode head2) {
		if(head1==null||head2==null) {
			return head1!=null?head1:head2;
		}
		SNode head=head1.value<head2.value?head1:head2;
		SNode cur1=head==head1?head1:head2;
		SNode cur2=head==head1?head2:head1;
		SNode pre=null;
		SNode next=null;
		while(cur1!=null&&cur2!=null) {
			if(cur1.value<=cur2.value) {
				pre=cur1;
				cur1=cur1.next;
			}else {
				next=cur2.next;
				pre.next=cur2;
				cur2.next=cur1;
				pre=cur2;
				cur2=next;
			}
		}
		pre.next=cur1==null?cur2:cur1;
		return head;
	}

}
