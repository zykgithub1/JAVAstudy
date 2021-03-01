package algorithm;

import java.util.Iterator;
import java.util.Stack;
//µİ¹éÄæĞòÒ»¸öÕ»£»
public class ReverseStack {
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		traversal(stack);
		reverse(stack);
		traversal(stack);
	}
	
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int i=f(stack);
		reverse(stack);
		stack.push(i);
	}
	
	
	
	public static int f(Stack<Integer> stack) {
		int result=stack.pop();
		if(stack.isEmpty()) {
			return result;
		}
		else {
			int last=f(stack);
			stack.push(result);
			return last;
		}
	}
	
	public  static void traversal(Stack<Integer> stack) {
		Iterator<Integer> it=stack.iterator();
		while(it.hasNext()) {
			System.out.print(it.next());
		}
		System.out.println();
	}
	
	

}
