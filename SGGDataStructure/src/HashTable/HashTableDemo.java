package HashTable;

import java.util.Scanner;
//初始化一个类对象数组的时候不仅要初始化整个数组的大小  还要new出Array中的每一个对象

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
				System.out.println("输入id");
				int id = scanner.nextInt();
				System.out.println("输入名字");
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
				System.out.println("请输入要查找的人的id");
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
		empLinkedArray = new EmpLinkedList[size];//易错点  忘了初始化造成空指针异常
		for(int i=0;i<size;i++) {
			empLinkedArray[i]=new EmpLinkedList();
		}
	}

	public void add(Emp emp) {
		int num = hashFun(emp.id);
		if(empLinkedArray[num].findEmpByID(emp.id)!=null) {
			System.out.println("已有此id号 无法添加");
		}else {
			empLinkedArray[num].add(emp);
		}
	}
	
	public void findEmpById(int id) {
		int num=hashFun(id);
		Emp emp=empLinkedArray[num].findEmpByID(id);
		if(emp!=null) {
			System.out.println("在第"+num+"条链表中找到该雇员"+"id="+id);
		}else {
			System.out.println("在哈希表中没有找到该员工");
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
			System.out.println("第"+no+"条链表为空");
			return;
		}
		Emp cur = head;
		System.out.print("第"+no+"条链表信息为");
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
				System.out.println("找到了");
				return cur;
			}
			cur=cur.next;
		}
		System.out.println("没找到");
		return null;
	}
	
}
