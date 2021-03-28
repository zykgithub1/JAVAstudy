package Demo02;

public class listDiv {
	public static void main(String[] args) {
		SNode head1=new SNode(9);
		SingleLinkedList list1=new SingleLinkedList(head1);
		list1.add(0);
		list1.add(4);
		list1.add(5);
		list1.add(1);
		list1.traversal();
		list1.setHead(listPartion2(list1.head,0));
		list1.traversal();
		
	}

	private static SNode listPartion2(SNode head, int pivol) {
		if(head==null) {
			return null;
		}
		SNode sH=null;
		SNode sT=null;
		SNode eH=null;
		SNode eT=null;
		SNode bH=null;
		SNode bT=null;
		SNode next=null;
		while(head!=null) {
			next=head.next;
			head.next=null;
			if(head.value<pivol) {
				if(sH==null) {
					sH=head;
					sT=head;
				}else {
					sT.next=head;
					sT=head;
				}
			}else if(head.value==pivol){
				if(eH==null) {
					eH=head;
					eT=head;
				}else {
					eT.next=head;
					sT=head;
				}
				
			}else {
				if(bH==null) {
					bH=head;
					bT=head;
				}else {
					bT.next=head;
					bT=head;
				}
			}
			head=next;
		}
		if(sT!=null) {
			sT.next=eH;
			eT=eT==null?sT:eT;
		}
		if(eT!=null) {
			eT.next=bH;
		}
		return sH!=null?sH:eH!=null?eH:sH;
	}

	private static SNode listPartion1(SNode head, int pivol) {
		if(head==null) {
			return null;
		}
		int len=0;
		SNode cur=head;
		while(cur!=null) {
			len++;cur=cur.next;
		}
		SNode[]nodeArr=new SNode[len];
		cur=head;
		for(int i=0;i<nodeArr.length;i++) {
			nodeArr[i]=cur;
			cur=cur.next;
		}
		nodeArrPation(nodeArr,pivol);
		int i=1;
		for(i=1;i<nodeArr.length;i++) {
			nodeArr[i-1].next=nodeArr[i];
		}
		nodeArr[i-1].next=null;
		return nodeArr[0];
	}

	private static void nodeArrPation(SNode[] nodeArr, int pivol) {
		int less=-1;
		int more=nodeArr.length;
		int cur=0;
		while(cur<more) {
			if(nodeArr[cur].value<pivol) {
				swap(nodeArr,++less,cur++);
			}else if(nodeArr[cur].value>pivol) {
				swap(nodeArr,--more,cur);
			}else {
				cur++;
			}
		}
		
	}

	private static void swap(SNode[] nodeArr, int i, int j) {
		SNode tmp=nodeArr[i];
		nodeArr[i]=nodeArr[j];
		nodeArr[j]=tmp;
	}

}
