package demo01;

import java.util.Stack;

public class getMinStack {
	public static void main(String[] args) {
		getMinStack s1=new getMinStack();
		s1.push(3);
		s1.push(4);
		s1.push(5);
		s1.push(1);
		s1.push(2);
		s1.push(1);
		System.out.println(s1.getMin());
		System.out.println(s1.pop());
	}
	private Stack<Integer> stackDate;
	private Stack<Integer> stackMin;
	
	public getMinStack() {
		this.stackDate=new Stack<Integer>();
		this.stackMin=new Stack<>();
	}
	
	public void push(int newNum) {
		if(stackMin.isEmpty()) {
			stackMin.push(newNum);
		}else if(newNum<=stackMin.peek()) {
			stackMin.push(newNum);
		}
		stackDate.push(newNum);
	}
	
	public int pop(){
		if(stackMin.isEmpty()) {
			throw new RuntimeException("your stack is empty!");
		}
		int value=stackDate.pop();
		if(value==this.getMin()) {
			stackMin.pop();
		}
		return value;
	}
	
	public int getMin() {
		if(stackMin.isEmpty()) {
			throw new RuntimeException("empty!!!");
		}
		return stackMin.peek();
	}
}
