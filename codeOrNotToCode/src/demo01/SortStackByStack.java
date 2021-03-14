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
		//��stack������ȫ����help���ź���help�Ǵ������ϵݼ��Ĳ���
		//���cur��help.peek Ҫ����cur�������ȫ������stack��Ȼ���ٽ�curѹ��help
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
