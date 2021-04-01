package Demo02;

public class insetNumIncircle {
	public static void main(String[] args) {
		SNode head1=new SNode(1);
		SingleLinkedList list1=new SingleLinkedList(head1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		SNode last=list1.getNodeByNum(4);
		last.next=head1;
		list1.traversal();
		System.out.println(list1.isCircle());
		list1.setHead(insertNum(list1.head,5));
		list1.traversal();
	}

	private static SNode insertNum(SNode head, int num) {
		SNode insertion=new SNode(num);
		if(head==null) {
			insertion.next=insertion;
			return insertion;
		}else {
			SNode pre=head;
			SNode cur=head.next;
			while(cur!=head) {
				if(pre.value<=num&&cur.value>=num) {
					break;
				}
				pre=cur;
				cur=cur.next;
			}
			pre.next=insertion;
			insertion.next=cur;
			return head.value<num?head:insertion;
		}
	}
	

}
