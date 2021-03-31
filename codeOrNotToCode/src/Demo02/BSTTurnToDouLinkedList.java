package Demo02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BSTTurnToDouLinkedList {
	public static void main(String[] args) {
		BNode head=new BNode(6);
		head.left=new BNode(4);
		head.right=new BNode(7);
		head.left.left=new BNode(2);
		head.left.right=new BNode(5);
		head.left.left.left=new BNode(1);
		head.left.left.right=new BNode(3);
		head.right.right=new BNode(9);
		head.right.right.left=new BNode(8);
		inOrder(head);
		head=convert2(head);
		//inOrder(head);
		System.out.println();
		list(head);
	}
	
	private static BNode convert2(BNode head) {
		if(head==null) {
			return null;
		}
		BNode last=process(head);
		head=last.right;
		last.right=null;
		return head;
	}

	private static BNode process(BNode head) {
		if(head==null) {
			return null;
		}
		BNode leftEnd=process(head.left);
		BNode rightEnd=process(head.right);
		BNode leftStart=leftEnd!=null?leftEnd.right:null;
		BNode rightStart=rightEnd!=null?rightEnd.right:null;
		if(leftEnd!=null&&rightEnd!=null) {
			head.left=leftEnd;
			leftEnd.right=head;
			rightStart.left=head;
			head.right=rightStart;
			rightEnd.right=leftStart;
			return rightEnd;
		}else if(leftEnd!=null) {
			leftEnd.right=head;
			head.left=leftEnd;
			head.right=leftStart;
			return head;
		}else if(rightEnd!=null) {
			head.right=rightStart;
			rightStart.left=head;
			rightEnd.right=head;
			return rightEnd;
		}else {
			head.right=head;
			return head;
		}
		
	}

	public static void list(BNode head) {
		if(head==null) {
			return;
		}
		while(head!=null) {
			System.out.print(head.value+" ");
			head=head.right;
		}
		System.out.println();
	}
	private static BNode convert1(BNode head) {
		Queue<BNode> queue=new LinkedList<BNode>();
		inorderToQueue(head,queue);
		head=queue.poll();
		BNode cur=null;
		BNode pre=head;
		BNode left=null;
		while(!queue.isEmpty()) {
			cur=queue.poll();
			pre.right=cur;
			cur.left=pre;
			pre=cur;
		}
		pre.right=null;
		return head;
	}


	private static void inorderToQueue(BNode head, Queue<BNode> queue) {
		if(head==null) {
			return;
		}
		inorderToQueue(head.left, queue);
		queue.add(head);
		inorderToQueue(head.right, queue);
	}


	public static void inOrder(BNode head) {
		if(head==null) {
			return;
		}
		inOrder(head.left);
		System.out.print(head.value+" ");
		inOrder(head.right);
	}

}
class BNode{
	public int value;
	public BNode left;
	public BNode right;
	public BNode(int data) {
		this.value=data;
	}
}
