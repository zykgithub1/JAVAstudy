package Demo02;

public class josephus {
	public static void main(String[] args) {
		Circle cir=new Circle();
		cir.add(10);
		cir.list();
		cir.game(1, 3);
	}

}
class Circle{
	public Node head=null;
	
	public void list() {
		if(this.head==null) {
			System.out.println("empty");
			return;
		}
		Node cur=head;
		while(true) {
			System.out.print(cur.num+" ");
			if(cur.next==head) {
				break;
			}
			cur=cur.next;
		}
	}
	
	public void game(int startNo,int k) {
		Node pre=head;
		while(pre.next!=null&&pre.next.num!=startNo) {
			pre=pre.next;
		}
		Node cur=pre.next;
		while(pre!=cur) {
			for(int i=0;i<k-1;i++) {
				pre=pre.next;
				cur=cur.next;
			}
			System.out.println(cur.num+"号出圈");
			pre.next=cur.next;
			cur=pre.next;
		}
		System.out.println("最后剩下的是"+cur.num);
	}
	
	public void add(int nums) {
		Node cur=null;
		for(int i=1;i<=nums;i++) {
			Node node=new Node(i);
			if(i==1) {
				head=node;
				cur=head;
				head.next=head;
			}else {
				cur.next=node;
				node.next=head;
				cur=cur.next;
			}
		}
		
	}
	
//	public Circle(Node head) {
//		this.head = head;
//		if(this.head==null) {
//			System.out.println("链表为空");
//			return;
//		}
//		Node cur=head;
//		while(cur.getNext()!=null) {
//			cur=cur.getNext();
//		}
//		cur.setNext(this.head);
//	}

	public Node getHead() {
		return head;
	}	
}
class Node{
	public int num;
	public Node next;
	
	public Node(int num) {
		super();
		this.num = num;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
