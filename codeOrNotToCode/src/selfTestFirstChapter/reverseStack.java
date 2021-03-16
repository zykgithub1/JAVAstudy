package selfTestFirstChapter;

import java.util.Stack;

public class reverseStack {
	public static void main(String[] args) {
		Stack<Integer>stack=new Stack<>();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		for(int i:stack) {
			System.out.print(i+" ");
		}
		reverse(stack);
		for(int i:stack) {
			System.out.print(i+" ");
		}
		
	}
	
	public static int process(Stack<Integer> stack) {
		int res=stack.pop();
		if(stack.isEmpty()) {
			return res;
		}else {
			int el=process(stack);
			stack.push(res);
			return el;
		}
	}
	
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int num=process(stack);
		reverse(stack);
		stack.push(num);
	}

}
