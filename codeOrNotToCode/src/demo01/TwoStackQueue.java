package demo01;

import java.util.Stack;

public class TwoStackQueue {
	public static void main(String[] args) {
		TwoStackQueue tsq=new TwoStackQueue();
		Stack<Integer> stack=new Stack<>();
		stack.add(5);stack.add(4);stack.add(3);stack.add(2);stack.add(1);
		tsq.add(5);
		tsq.add(4);
		tsq.add(3);
		tsq.add(2);
		tsq.add(1);
		System.out.println("stack="+" "+stack.pop()+"tsq="+tsq.poll());
		System.out.println("stack="+" "+stack.pop()+"tsq="+tsq.poll());
		System.out.println("stack="+" "+stack.pop()+"tsq="+tsq.poll());
		System.out.println("stack="+" "+stack.pop()+"tsq="+tsq.poll());
		System.out.println("stack="+" "+stack.pop()+"tsq="+tsq.poll());
		//System.out.println("stack="+" "+stack.pop()+"tsq="+tsq.poll());
		
	}
	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;
	public TwoStackQueue() {
		stackPush=new Stack<>();
		stackPop=new Stack<>();
	}
	
	public void add(int num) {
		stackPush.add(num);
	}
	
	public int poll() {
		if(stackPush.isEmpty()&&stackPop.isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}else if(stackPop.isEmpty()){
			while(!stackPush.isEmpty()) {
				stackPop.add(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	
	public int peek() {
		if(stackPush.isEmpty()&&stackPop.isEmpty()) {
			throw new RuntimeException("stack is empty!");
		}else if(stackPop.isEmpty()){
			while(!stackPush.isEmpty()) {
				stackPop.add(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
	

}
