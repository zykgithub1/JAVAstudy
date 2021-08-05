package demo_2021_8_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class traversal {
	public static class Node {
		public Node left;
		public Node right;
		public int value;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

	public static void inorder(Node root) {
		Stack<Node> stack = new Stack();
		while(root!=null||!stack.isEmpty()) {
			if(root==null) {
				root=stack.pop();
				System.out.println(root.value);
				root=root.right;
			}else {
				stack.push(root);
				root=root.left;
			}
		}
	}
	
	public static void bfd(Node root) {
		Queue<Node>que=new LinkedList();
		que.add(root);
		while(!que.isEmpty()) {
			root=que.poll();
			System.out.println(root.value);
			if(root.left!=null) {
				que.offer(root.left);
			}
			if(root.right!=null) {
				que.offer(root.right);
			}
		}
	}

	public static void preOrderNorecursion(Node root) {
		Stack<Node> stack = new Stack();
		stack.push(root);
		Node cur = null;
		while (!stack.isEmpty()) {
			cur = stack.pop();
			System.out.println(cur.value);
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
	}

}
