package selfTestFirstChapter;

import java.util.Stack;

public class twoStackQueue {
	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	public twoStackQueue() {
		stackPop=new Stack();
		stackPush=new Stack();
	}
	
	public void add(int num) {
		stackPush.add(num);
	}
	
	public int poll() {
		if(stackPop.isEmpty()&&stackPush.isEmpty()) {
			throw new RuntimeException();
		}else if(stackPop.isEmpty()){
			while(!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	
	public int peek() {
		if(stackPop.isEmpty()&&stackPush.isEmpty()) {
			throw new RuntimeException();
		}else if(stackPop.isEmpty()) {
			while(!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
	

}
