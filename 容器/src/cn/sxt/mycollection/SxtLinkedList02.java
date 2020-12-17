package cn.sxt.mycollection;
//12-17保存在这里了 等下自己重新完全敲一次Arraylist和LinkedList;
public class SxtLinkedList02{
	private Node first;
	private Node last;
	private int size;
	
	public Object get(int index) {
		if(index<0||index>size-1) {
			throw new RuntimeException("索引数字不合法："+index);
		}
		Node temp=null;
		if(index<=size>>1) {
			temp=first;
			for(int i=0;i<index;i++) {
				temp=temp.next;
			}
		}
		if(index>size>>1) {
			temp=last;
			for(int i=size-1;i>index;i--) {
				temp=temp.previous;
			}
		}
		
		return temp.element;
	}
	
	
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
		size++;
		
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
		SxtLinkedList02 list=new SxtLinkedList02();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		list.add("g");
		System.out.println(list.get(3));
	}

}
