package class1;

public class DoubleLinkedList {
	public static void main(String[] args) {
		DoubleLinkedList list=new DoubleLinkedList();
		heroNode2 no1 = new heroNode2(1, "宋江", "及时雨");
		heroNode2 no2 = new heroNode2(2, "卢俊义", "玉麒麟");
		heroNode2 no3 = new heroNode2(3, "吴用", "智多星");
		heroNode2 no4 = new heroNode2(4, "林冲", "豹子头");
		
		list.addByOrder(no1);
		list.addByOrder(no3);
		list.addByOrder(no4);
		list.addByOrder(no2);
		list.addByOrder(no1);
		list.addByOrder(no3);
		list.addByOrder(no4);
		list.addByOrder(no2);
		list.list();
//		heroNode2 newH=new heroNode2(4, "公孙胜", "入云龙");
//		list.updata(newH);
//		list.list();
//		
//		list.delet(3);
//		list.list();
		
	}
	private heroNode2 head=new heroNode2(0, null, null);
	
	
	public heroNode2 getHead() {
		return head;
	}
	public void list() {
		heroNode2 p = head.next;
		while (p != null) {
			System.out.println(p);
			p = p.next;
		}
	}
	
	public void add(heroNode2 node) {
		heroNode2 p=head;
		while(p.next!=null) {
			p=p.next;
		}
		p.next=node;
		node.pre=p;
	}
	
	public void updata(heroNode2 newNode) {
		if(head.next==null) {
			System.out.println("链表为空");
			return;
		}
		heroNode2 p=head.next;
		while(p!=null) {
			if(p.no==newNode.no) {
				p.name=newNode.name;
				p.nickName=newNode.nickName;
				System.out.println("修改完成");
				return;
			}
			p=p.next;
		}
		System.out.printf("未找到该%d节点\n",newNode.no);
	}
	public void addByOrder(heroNode2 newH) {
		heroNode2 p=head;
		boolean flag=false;
		while(p.next!=null) {
			if(p.next.no>newH.no) {
				newH.next=p.next;
				p.next.pre=newH;
				p.next=newH;
				newH.pre=p;
				return;
			}
			if(p.next.no==newH.no) {
				flag=true;
				break;
			}
			p=p.next;
		}
		if(flag) {
			System.out.printf("%d人物已存在，无法增加\n",newH.no);
			//return;
		}else {
			p.next=newH;
			newH.pre=p;
			System.out.printf("%d号人物增加在末尾\n",newH.no);
		}
	}
	public void delet(int i) {
		if(head.next==null) {
			System.out.println("链表为空删无可删");
			return;
		}
		heroNode2 p=head.next;
		while(p!=null) {
			if(p.no==i) {
				p.pre.next=p.next;
				if(p.next!=null) {
					p.next.pre=p.pre;
				}
				System.out.println("删除成功");
				return;
			}
			p=p.next;
		}
		System.out.println("未找到该节点");
	}
	
	
	
	


}

class heroNode2 {
	public int no;
	public String name;
	public String nickName;
	public heroNode2 next;
	public heroNode2 pre;

	public heroNode2(int no, String name, String nickName) {
		super();
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "heroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
}