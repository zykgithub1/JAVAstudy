package Demo02;

public class essentricDelNode {
	public static void main(String[] args) {
		SNode head1=new SNode(1);
		SingleLinkedList list1=new SingleLinkedList(head1);
		list1.add(2);
		list1.add(3);
		SNode delNode=list1.getNodeByNum(3);
		removeNodeWired(delNode);
		list1.traversal();
	}

	private static void removeNodeWired(SNode node) {
		if(node==null) {
			return;
		}
		SNode next=node.next;
		if(next!=null) {
			node.value=next.value;
			node.next=next.next;
		}else {
			throw new RuntimeException("can not del last NODE");
		}
		
		
	}

}
