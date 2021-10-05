package demo_2021_9_27_leetcode;

import java.util.Stack;

public class profixExpress {
	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack();
		for (String str : tokens) {
			if (!isOp(str)) {
				stack.push(str);
			} else {
				int v2 = Integer.valueOf(stack.pop());
				int v1 = Integer.valueOf(stack.pop());
				int ans = caculate(v1, v2, str);
				stack.push(String.valueOf(ans));
			}
		}
		return Integer.valueOf(stack.pop());

	}

	public boolean isOp(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
			return true;
		}
		return false;
	}

	public int caculate(int v1, int v2, String s) {
		switch (s) {
		case "+":
			return v1 + v2;
		case "-":
			return v1 - v2;
		case "*":
			return v1 * v2;
		case "/":
			return v1 / v2;
		default:
			return 0;
		}
	}

}
