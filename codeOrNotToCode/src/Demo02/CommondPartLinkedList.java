package Demo02;

public class CommondPartLinkedList {
	public static void main(String[] args) {
		SNode head1=new SNode(3);
		SingleLinkedList list1=new SingleLinkedList(head1);
		list1.add(4);
		list1.add(5);
		list1.add(6);
		list1.add(7);
		list1.traversal();
		SNode head2=new SNode(3);
		SingleLinkedList list2=new SingleLinkedList(head2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list2.traversal();
		//printCommonPart(head1, head2);
		//list1.setHead(removeLastKthNode(head1,3));
//		list1.setHead(reverseList(head1));
//		list1.traversal();
		list1.setHead(reversePart(head1, 1,2));
		list1.traversal();
		
	}
	 
	public static SNode reversePart(SNode head,int from,int to) {
		int len=0;
		SNode pre=null;
		SNode pro=null;
		SNode cur=head;
		while(cur!=null) {
			len++;
			pre=len==from-1?cur:pre;
			pro=len==to+1?cur:pro;
			cur=cur.next;
		}
		SNode node1=pre==null?head:pre.next;
		SNode node2=node1.next;
		node1.next=pro;SNode next=null;
		while(node2!=pro) {
			next=node2.next;
			node2.next=node1;
			node1=node2;
			node2=next;
		}
		if(pre!=null) {
			pre.next=node1;
			return head;
		}
		return node1;
		
	}
	
	
	public static SNode reverseList(SNode head) {
		if(head==null||head.next==null) {
			return head;
		}
		SNode cur=null;
		SNode next=null;
		while(head!=null) {
			next=head.next;
			head.next=cur;
			cur=head;
			head=next;
		}
		return cur;
	}
	public static SNode removeLastKthNode(SNode head,int k) {
		if(head==null) {
			System.out.println("头节点为空");
			return null;
		}
		if(k<1) {
			System.out.println("k值非法,删除失败");
			return head;
		}
		SNode cur=head;
		while(cur!=null) {
			k--;
			cur=cur.next;
		}
		if(k>0) {
			throw new RuntimeException("k值超出链表长度");
		}
		if(k==0) {
			head=head.next;
		}
		if(k<0) {
			cur=head;
			while(++k!=0) {
				cur=cur.next;
			}
			cur.next=cur.next.next;
		}
		return head;
	}
	
	public static void printCommonPart(SNode head1,SNode head2) {
		System.out.println("Common part");
		if(head1==null||head2==null) {
			return;
		}
		while(head1!=null&&head2!=null) {
			if(head1.value==head2.value) {
				System.out.print(head1.value+" ");
				head1=head1.next;
				head2=head2.next;
			}else if(head1.value<head2.value) {
				head1=head1.next;
			}else {
				head2=head2.next;
			}
		}
		System.out.println();
	}

}
class SNode{
	public int value;
	public SNode next;
	public SNode(int value) {
		super();
		this.value = value;
	}
}
class SingleLinkedList{
	
	public SNode getHead() {
		return head;
	}
	
	
	public void setHead(SNode head) {
		this.head = head;
	}
	public SNode head;
	
	public SingleLinkedList(SNode head) {
		super();
		this.head = head;
	}
	public void add(int value) {
		SNode cur=head;
		if(head==null) {
			head=new SNode(value);
		}else {
			while(cur.next!=null) {
				cur=cur.next;
			}
			cur.next=new SNode(value);
		}
	}
	public void traversal() {
		if(head==null) {
			return;
		}
		SNode cur=head;
		while(cur!=null) {
			System.out.print(cur.value+"->");
			cur=cur.next;
		}
		System.out.println();
	}
	
}

