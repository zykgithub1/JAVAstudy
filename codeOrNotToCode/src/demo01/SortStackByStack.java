package demo01;

import java.util.Stack;

public class SortStackByStack {
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack();
		stack.add(5);
		stack.add(7);
		stack.add(3);
		stack.add(9);
		stack.add(8);
		stack.add(2);
		for(int i:stack) {
			System.out.print(i+" ");
		}
		sortStack(stack);
		System.out.println();
		for(int i:stack) {
			System.out.print(i+" ");
		}
	}

	private static void sortStack(Stack<Integer> stack) {
		Stack<Integer> help=new Stack();
		//将stack的数字全部再help中排好序：help是从下往上递减的才行
		//如果cur》help.peek 要将比cur大的数字全部弹回stack，然后再将cur压入help
		while(!stack.isEmpty()) {
			int cur=stack.pop();
			while(!help.isEmpty()&&cur>help.peek()) {
				stack.add(help.pop());
			}
			help.push(cur);
		}
		while(!help.isEmpty()) {
			stack.add(help.pop());
		}
		
	}

}
