package demo_2021_8_22_;

import java.util.Stack;

public class stackAndQueConvert {
	public static class twoStackQueue {
		private Stack<Integer> pushStack;
		private Stack<Integer> popStack;

		public twoStackQueue() {
			pushStack = new Stack<>();
			popStack = new Stack<Integer>();
		}

		public void push(int pushInt) {
			pushStack.push(pushInt);
			dao();
		}

		public int poll() {
			if (pushStack.isEmpty() && popStack.isEmpty()) {
				throw new RuntimeException("que is empty!");
			}
			dao();
			return popStack.pop();
		}

		private void dao() {
			if (popStack.isEmpty()) {
				while (!pushStack.isEmpty()) {
					popStack.push(pushStack.pop());
				}
			}
		}

	}

}
