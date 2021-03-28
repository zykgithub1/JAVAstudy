package Demo02;

import java.util.HashMap;

public class copyListWithRandom {
	public static void main(String[] args) {
		linkRNode list=new linkRNode();
		for(int i=1;i<=5;i++) {
			list.add(i);
		}
		list.list();
		rNode newN=copyWithRand2(list.head);
		linkRNode list2=new linkRNode();
		list2.setHead(newN);
		list2.list();
		
	}

	private static rNode copyWithRand2(rNode head) {
		if(head==null) {
			System.out.println("empty");
			return null;
		}
		rNode cur=head;
		rNode next=null;
		while(cur!=null) {
			next=cur.next;
			rNode node=new rNode(cur.value);
			node.next=next;
			cur.next=node;
			cur=next;
		}
		cur=head;
		rNode copyNode=null;
		while(cur!=null) {
			next=cur.next.next;
			copyNode=cur.next;
			copyNode.rand=cur.rand!=null?cur.rand.next:null;
			cur=next;
		}
		cur=head;
		rNode res=cur.next;
		while(cur!=null) {
			next=cur.next.next;
			copyNode=cur.next;
			cur.next=next;
			copyNode.next=next!=null?next.next:null;
			cur=next;
		}
		return res;
	}

	private static rNode copyWithRand1(rNode head) {
		if(head==null) {
			System.out.println("empty");
			return null;
		}
		HashMap<rNode,rNode>map=new HashMap();
		rNode cur=head;
		while(cur!=null) {
			map.put(cur, new rNode(cur.value));
			cur=cur.next;
		}
		cur=head;
		while(cur!=null) {
			map.get(cur).next=map.get(cur.next);
			map.get(cur).rand=map.get(cur.rand);
			cur=cur.next;
		}
		return map.get(head);
	}

}
class linkRNode{
	public rNode head=null;

	public rNode getHead() {
		return head;
	}
	
	public void list() {
		if(head==null) {
			System.out.println("Empty");
			return;
		}
		rNode cur=head;
		while(cur!=null) {
			System.out.print(cur.value+" ");
			cur=cur.next;
		}
		System.out.println();
	}

	public void setHead(rNode head) {
		this.head = head;
	}
	
	public void add(int data) {
		if(head==null) {
			head=new rNode(data);
		}else {
			rNode cur=head;
			while(cur.next!=null) {
				cur=cur.next;
			}
			cur.next=new rNode(data);
		}
	}
	
}
class rNode{
	public int value;
	public rNode next;
	public rNode rand;
	public rNode(int value) {
		this.value = value;
	}
}
