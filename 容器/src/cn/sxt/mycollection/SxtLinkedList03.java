package cn.sxt.mycollection;
//增加  插入  版本
public class SxtLinkedList03{
	private Node first;
	private Node last;
	private int size;
	
	//a,b,c,d,e,
	//a,c,d,e,
	public void remove(int index) {
		Node temp=getNode(index);
		if(temp!=null) {
			Node tempq=temp.previous;
			Node temph=temp.next;
			if(tempq!=null) {
				tempq.next=temph;
			}
			if(temph!=null) {
				temph.previous=tempq;
			}
			if(index==0) {
				first=temph;
			}
			if(index==size-1) {
				last=tempq;
			}
			size--;
		}
		
		
	}
	//a,b,c,d,e
	//a,b,c,c,d,e
	public void add(int index,Object obj) {
		Node temp=getNode(index);
		Node node=new Node(obj);
		if(temp!=null) {
			Node up=temp.previous;
			Node down=temp.next;
			
			up.next=node;
			node.next=temp;
			temp.previous=node;
			node.previous=up;
			
			size++;
		}
		
	}
	
	
	public Node getNode(int index) {
		if(index<0||index>size-1) {
			throw new RuntimeException("索引越界"+index);
		}
		Node temp=null;
		if(index<=(size>>1)) {
			temp=first;
			for(int i=0;i<index;i++) {
				temp=temp.next;
			}
		}else {
			temp=last;
			for(int i=size-1;i>index;i--) {
				temp=temp.previous;
			}
		}
		return temp;
	}

	
	public Object get(int index) {
		if(index<0||index>size-1) {
			throw new RuntimeException("索引数字不合法："+index);
		}
		Node temp=getNode(index);
		
		return temp!=null?temp.element:null;
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
		SxtLinkedList03 list=new SxtLinkedList03();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.add("f");
		//list.add("g");
		System.out.println(list);
		list.add(3, "Zzz");
		System.out.println(list);
		
	}

}
