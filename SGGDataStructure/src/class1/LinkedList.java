package class1;

public class LinkedList {
	public static void main(String[] args) {
		heroNode no1=new heroNode(1, "�ν�", "��ʱ��");
		heroNode no2=new heroNode(2, "¬����", "������");
		heroNode no3=new heroNode(3, "����", "�Ƕ���");
		heroNode no4=new heroNode(4, "�ֳ�", "����ͷ");
		SingleLinkedList list=new SingleLinkedList();
		list.add(no1);
		list.add(no2);
		list.add(no3);
		list.add(no4);
		list.list();
	}
}
class heroNode{
	private int no;
	private String name;
	private String nickName;
	public heroNode next;
	
	public heroNode(int no, String name, String nickName) {
		super();
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}
	
	@Override
	public String toString() {
		return "heroNode [no=" + no + ", name=" + name + ", nickName=" + nickName +  "]";
	}
}

class SingleLinkedList{
	heroNode head=new heroNode(0, "", "");
	int size;
	
	
	public void add(heroNode node) {
		heroNode p=head;
		while(p.next!=null) {
			p=p.next;
		}
		p.next=node;
		node.next=null;
	}
	
	public void list() {
		heroNode p=head.next;
		while(p!=null) {
			System.out.println(p);
			p=p.next;
		}
	}
}


