package Demo02;

import java.util.Stack;

public class delSpecificNum {
	public static void main(String[] args) {
		SNode head=new SNode(1);
		SingleLinkedList list=new SingleLinkedList(head);
		list.add(2);list.add(3);list.add(3);list.add(2);list.add(2);list.add(1);list.add(1);
		//delete(head,0);
		//list.setHead(removeValue(head,2));
		list.setHead(removeValue2(head,1));
		list.traversal();
	}

	private static SNode removeValue2(SNode head, int pivol) {
		while(head!=null) {
			if(head.value!=pivol) {
				break;
			}
			head=head.next;
		}
		SNode pre=head;
		SNode cur=head;
		while(cur!=null) {
			if(cur.value==pivol) {
				pre.next=cur.next;
			}else {
				pre=cur;
			}
			cur=cur.next;
		}
		return head;
	}

	private static SNode removeValue(SNode head, int num) {
		if(head==null) {
			return null;
		}
		Stack<SNode>stack=new Stack<>();
		while(head!=null) {
			if(head.value!=num) {
				stack.push(head);
			}
			head=head.next;
		}
		while(!stack.isEmpty()) {
			stack.peek().next=head;
			head=stack.pop();
		}
		return head;
	}

	private static void delete(SNode head, int pivol) {
		if(head==null) {
			return ;
		}
		SNode pre=null;
		SNode cur=head;
		SNode next=null;
		while(cur!=null) {
			pre=cur;
			next=cur.next;
			while(next!=null) {
				if(next.value==pivol) {
					pre.next=next.next;
				}else {
					pre=next;
				}
				next=next.next;
			}
			cur=cur.next;
		}
		
	}

}
