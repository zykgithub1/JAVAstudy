package class1;

import java.util.Scanner;

public class ArrayStack {

	public static void main(String[] args) {
		ArrayStack1 stack=new ArrayStack1(4);
		String key="";
		boolean loop=true;
		Scanner sc=new Scanner(System.in);
		while(loop) {
			System.out.println("show:��ʾ��ʾջ");
			System.out.println("exit���˳�����");
			System.out.println("push:���Ԫ�ص�ջ");
			System.out.println("pop:��ջ");
			System.out.println("������");
			key=sc.nextLine();
			switch(key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("����Ҫ��ջ��Ԫ��");
				stack.push(sc.nextInt());
				break;
			case "pop":
				try {
					int res=stack.pop();
					System.out.println("��սԪ���ǣ�"+res);
				} catch (Exception e) {
					e.getMessage();
				}
				break;
			case "exit":
				sc.close();
				loop=false;
			}
		}
		System.out.println("�����˳�");
	}

}
class ArrayStack1{
	private int maxSize;
	private int[] stack;
	private int top=-1;
	public ArrayStack1(int maxSize) {
		super();
		this.maxSize = maxSize;
		stack=new int[maxSize];
	}
	
	public boolean isFull() {
		if(top+1==maxSize) {
			return true;
		}
		return false;
	}
	public boolean isEmpty() {
		return top==-1;
	}
	
	public void push(int num) {
		if(isFull()) {
			System.out.println("վ��");
			return;
		}
		stack[++top]=num;
	}
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("ջ��");
		}
		return stack[top--];
	}
	public void list() {
		if(isEmpty()) {
			System.out.println("ջ��");
		}
		for(int i=top;i>=0;i--) {
			System.out.println(stack[i]+" ");
		}
	}
	
}