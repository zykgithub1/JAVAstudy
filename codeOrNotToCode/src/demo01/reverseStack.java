package demo01;

import java.util.Stack;

public class reverseStack {
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		for(int i:stack) {
			System.out.print(i+" ");
		}
		System.out.println();
		reverse(stack);
		for(int i:stack) {
			System.out.print(i+" ");
		}
	}

	private static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			//System.out.println("stack is empty");
			return;
		}
		int result=process(stack);
		reverse(stack);
		stack.push(result);
	}
	
	public static int process(Stack<Integer> stack) {
		int res=stack.pop();
		if(stack.isEmpty()) {
			return res;
		}else {
			int num=process(stack);
			stack.push(res);
			return num;
		}
	}

}
