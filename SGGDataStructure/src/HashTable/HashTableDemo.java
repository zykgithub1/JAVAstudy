package HashTable;

import java.util.Scanner;
//��ʼ��һ������������ʱ�򲻽�Ҫ��ʼ����������Ĵ�С  ��Ҫnew��Array�е�ÿһ������

public class HashTableDemo {

	public static void main(String[] args) {
		HashMapEmp hashTab = new HashMapEmp(7);
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("add");
			System.out.println("list");
			System.out.println("exit");
			System.out.println("find");
			key = scanner.next();
			switch (key) {
			case "add":
				System.out.println("����id");
				int id = scanner.nextInt();
				System.out.println("��������");
				String name = scanner.next();
				Emp emp = new Emp(id, name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "exit":
				scanner.close();
				System.exit(0);
				break;
			case "find":
				System.out.println("������Ҫ���ҵ��˵�id");
				id=scanner.nextInt();
				hashTab.findEmpById(id);
				break;
			}
		}
	}
}

class HashMapEmp {
	public EmpLinkedList[] empLinkedArray;
	public int size;

	public HashMapEmp(int size) {
		this.size = size;
		empLinkedArray = new EmpLinkedList[size];//�״��  ���˳�ʼ����ɿ�ָ���쳣
		for(int i=0;i<size;i++) {
			empLinkedArray[i]=new EmpLinkedList();
		}
	}

	public void add(Emp emp) {
		int num = hashFun(emp.id);
		if(empLinkedArray[num].findEmpByID(emp.id)!=null) {
			System.out.println("���д�id�� �޷����");
		}else {
			empLinkedArray[num].add(emp);
		}
	}
	
	public void findEmpById(int id) {
		int num=hashFun(id);
		Emp emp=empLinkedArray[num].findEmpByID(id);
		if(emp!=null) {
			System.out.println("�ڵ�"+num+"���������ҵ��ù�Ա"+"id="+id);
		}else {
			System.out.println("�ڹ�ϣ����û���ҵ���Ա��");
		}
	}

	public int hashFun(int id) {
		return id % size;
	}

	public void list() {
		for (int i = 0; i < size; i++) {
			empLinkedArray[i].list(i);
		}
		System.out.println();
	}
}

class Emp {
	public int id;
	public String name;
	public Emp next;

	public Emp(int id, String name) {
		this.id = id;
		this.name = name;
	}
}

class EmpLinkedList {
	public Emp head;

	public void add(Emp emp) {
		if (head == null) {
			head = emp;
			return;
		}
		Emp cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		cur.next = emp;
	}

	public void list(int no) {
		if (head == null) {
			System.out.println("��"+no+"������Ϊ��");
			return;
		}
		Emp cur = head;
		System.out.print("��"+no+"��������ϢΪ");
		while (cur != null) {
			System.out.printf("id=%d  name=%s\t", cur.id, cur.name);
			cur=cur.next;
		}
		System.out.println();
	}
	public Emp findEmpByID(int id) {
		Emp cur=head;
		if(head==null) {
			return null;
		}
		while(cur!=null) {
			if(cur.id==id) {
				System.out.println("�ҵ���");
				return cur;
			}
			cur=cur.next;
		}
		System.out.println("û�ҵ�");
		return null;
	}
	
}
