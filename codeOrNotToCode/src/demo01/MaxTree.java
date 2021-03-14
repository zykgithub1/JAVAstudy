package demo01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class MaxTree {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 1, 2 };
		Node tree = getMaxTree(arr);
		show(tree);
	}
	
	public static void show(Node x) {
		if(x==null) {
			return;
		}
		show(x.left);
		System.out.print(x.value+"");
		show(x.right);
	}

	private static Node getMaxTree(int[] arr) {
		if (arr.length == 0 || arr == null) {
			throw new RuntimeException("empty arr!");
		}
		Node[] nArr = new Node[arr.length];
		for(int i=0;i<arr.length;i++) {
			nArr[i]=new Node(arr[i]);
		}
		HashMap<Node, Node> lbigMap = new HashMap<>();
		HashMap<Node, Node> rbigMap = new HashMap<>();
		Stack<Node> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			Node cur = nArr[i];
			while(!stack.isEmpty() && stack.peek().value < cur.value) {
				stackPopHashMap(stack, lbigMap);
			}
			stack.push(cur);
		}
		while (!stack.isEmpty()) {
			stackPopHashMap(stack, lbigMap);
		}
		for (int i = nArr.length-1; i!=-1; i--) {
			Node cur = nArr[i];
			while (!stack.isEmpty() && stack.peek().value < cur.value) {
				stackPopHashMap(stack, rbigMap);
			}
			stack.push(cur);
		}
		while (!stack.isEmpty()) {
			stackPopHashMap(stack, rbigMap);
		}
		Node head = null;
		for (int i = 0; i < arr.length; i++) {
			Node cur = nArr[i];
			Node left = lbigMap.get(cur);
			//System.out.print(left==null?0:left.value);
			Node right = rbigMap.get(cur);
			//System.out.print(right==null?0:right.value);
			if (left == null && right == null) {
				head = cur;
			} else if (left == null) {
				if (right.left == null) {
					right.left = cur;
				} else {
					right.right = cur;
				}
			} else if (right == null) {
				if (left.left == null) {
					left.left = cur;
				} else {
					left.right = cur;
				}
			} else {
				Node parent = left.value < right.value ? left : right;
				if (parent.left == null) {
					parent.left = cur;
				} else {
					parent.right = cur;
				}
			}
		}
		return head;
	}

	private static void stackPopHashMap(Stack<Node> stack, HashMap<Node, Node> lbigMap) {
		Node pobNode = stack.pop();
		if (stack.isEmpty()) {
			lbigMap.put(pobNode, null);
		} else {
			lbigMap.put(pobNode, stack.peek());
		}
	}

}
