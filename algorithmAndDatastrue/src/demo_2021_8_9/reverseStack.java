package demo_2021_8_9;

import java.util.Stack;

public class reverseStack {
	public static void main(String[] args) {
		Stack<Integer>stack=new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		for(int in:stack) {
			System.out.printf("%d  ",in);
		}
		System.out.println();
		System.out.println(stack.peek());
		System.out.println(getDownOfStack(stack));
		for(int in:stack) {
			System.out.printf("%d  ",in);
		}
		System.out.println();
		System.out.println(stack.size());
		
	}
	
	public static int getDownOfStack(Stack<Integer>stack) {
		if(stack.size()==1) {
			return stack.pop();
		}else {
			int temp=stack.pop();
			int last=getDownOfStack(stack);
			stack.push(temp);
			return last;
		}
	}
	
	public static void revserStack(Stack<Integer>stack) {
		if(stack.isEmpty()) {
			return;
		}
		int temp=getDownOfStack(stack);
		revserStack(stack);
		stack.push(temp);
		
	}

}
