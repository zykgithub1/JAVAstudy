package selfTestFirstChapter;

import java.util.Stack;

public class getMinStack {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	public getMinStack() {
		stackData=new Stack<>();
		stackMin=new Stack();
	}
	
	public void push(int num) {
		stackData.push(num);
		if(stackMin.isEmpty()) {
			stackMin.push(num);
		}else if(num<=getMin()) {
			stackMin.push(num);
		}
	}
	
	public int pop() {
		if(stackData.isEmpty()&&stackMin.isEmpty()) {
			throw new RuntimeException("your stack is empty");
		}
		int value=stackData.pop();
		if(value==getMin()) {
			stackMin.pop();
		}
		return value;
		
	}
	
	public int getMin() {
		if(stackMin.isEmpty()) {
			throw new RuntimeException("your stack is empty");
		}
		return stackMin.peek();
	}
}

class myStack2{
	private Stack<Integer>stackData;
	private Stack<Integer>stackMin;
	public myStack2() {
		stackData=new Stack();
		stackMin=new Stack();
	}
	
	public int getMin() {
		if(stackMin.isEmpty()) {
			throw new RuntimeException();
		}
		return stackMin.peek();
	}
	
	public void push(int num) {
		if(stackMin.isEmpty()) {
			stackMin.push(num);
		}else if(num<getMin()) {
			stackMin.push(num);
		}else {
			stackMin.push(stackMin.peek());
		}
		stackData.push(num);
	}
	
	public int pop() {
		if(stackData.isEmpty()) {
			throw new RuntimeException();
		}
		stackData.pop();
		return stackMin.pop();
	}
	
	
}











