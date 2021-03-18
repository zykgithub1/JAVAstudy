package class1;

import java.util.Stack;

public class Calculator {
	public static void main(String[] args) {
		String expression="3+2*6-5";
		ArrayStack2 numStack=new ArrayStack2(10);
		ArrayStack2 operStack=new ArrayStack2(10);
		int index=0,num1=0,num2=0,oper=0,res = 0;
		char ch=' ';
		while(true) {
			char[]ex=expression.toCharArray();
			ch=ex[index++];
			if(operStack.isOper(ch)) {
				if(operStack.isEmpty()) {
					operStack.push(ch);
				}else {//��Ϊ�գ�Ҫ�ж����ȼ�
					if(operStack.priority(ch)<=operStack.priority(operStack.peek())) {
						num1=numStack.pop();
						num2=numStack.pop();
						oper=operStack.pop();
						res=operStack.cal(num1, num2, (char) oper);
						numStack.push(res);
						operStack.push(ch);
					}else {
						operStack.push(ch);
					}
				}
			}else {
				numStack.push(ch-48);
			}
			if(index==ex.length) {
				break;
			}
		}
		while(operStack.isEmpty()) {
			num1=numStack.pop();
			num2=numStack.pop();
			oper=operStack.pop();
			res=operStack.cal(num1, num2, (char) oper);
			numStack.push(res);
		}
		int res2=numStack.pop();
		System.out.printf("���ʽ%s=%d",expression,res);
	}

}
class ArrayStack2{
	private int maxSize;
	private int[] stack;
	private int top=-1;
	public ArrayStack2(int maxSize) {
		super();
		this.maxSize = maxSize;
		stack=new int[maxSize];
	}
	
	public int peek() {
		if(!isEmpty()) {
			return stack[top];
		}
		throw new RuntimeException();
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
	//�������ȼ��㷨��
	//��������Ӧ������Խ�����ȼ�Խ�ߣ�
	public int priority(int oper) {
		if(oper=='*'||oper=='/') {
			return 1;
		}else if(oper=='+'||oper=='-') {
			return 0;
		}else {
			return -1;
		}
	}
	
	public boolean isOper(char val) {
		if(val=='+'||val=='-'||val=='*'||val=='/') {
			return true;
		}
		return false;
	}
	public int cal(int num1,int num2,char oper) {
		int res=0;
		switch(oper) {
		case '+':
			res=num1+num2;
			break;
		case '-':
			res=num2-num1;
			break;
		case '*':
			res=num1*num2;
			break;
		case '/':
			res=num2/num1;
			break;
		}
		return res;
	}
	
}