package cn.sxt.mycollection;

public class SxtLinkedList01{
	private Node first;
	private Node last;
	private int size;
	
	
	
	
	public void add(Object obj) {
		
		Node node=new Node(obj);
		if(first==null) {
			first=node;
			last=node;
		}else {
			node.previous=last;
			node.next=null;
			last.next=node;
			last=node;
		}
		
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("[");
		Node temp=first;
		while(temp!=null) {
			sb.append(temp.element+",");
			temp=temp.next;
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	public static void main(String[]ats) {
		SxtLinkedList01 list=new SxtLinkedList01();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		System.out.println(list);
	}

}
