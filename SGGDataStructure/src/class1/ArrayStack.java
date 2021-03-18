package class1;

import java.util.Scanner;

public class ArrayStack {

	public static void main(String[] args) {
		ArrayStack1 stack=new ArrayStack1(4);
		String key="";
		boolean loop=true;
		Scanner sc=new Scanner(System.in);
		while(loop) {
			System.out.println("show:表示显示栈");
			System.out.println("exit：退出程序");
			System.out.println("push:添加元素到栈");
			System.out.println("pop:出栈");
			System.out.println("请输入");
			key=sc.nextLine();
			switch(key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("输入要入栈的元素");
				stack.push(sc.nextInt());
				break;
			case "pop":
				try {
					int res=stack.pop();
					System.out.println("出战元素是："+res);
				} catch (Exception e) {
					e.getMessage();
				}
				break;
			case "exit":
				sc.close();
				loop=false;
			}
		}
		System.out.println("程序退出");
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
			System.out.println("站满");
			return;
		}
		stack[++top]=num;
	}
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("栈空");
		}
		return stack[top--];
	}
	public void list() {
		if(isEmpty()) {
			System.out.println("栈空");
		}
		for(int i=top;i>=0;i--) {
			System.out.println(stack[i]+" ");
		}
	}
	
}