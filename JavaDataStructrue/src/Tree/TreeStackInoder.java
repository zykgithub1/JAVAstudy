package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import selfTest.selfTestTree;
import selfTest.selfTestTree.Node;

public class TreeStackInoder {
	public static void main(String[] args) {
		Node tree = selfTestTree.creatTree();
		selfTestTree.show(tree);
		System.out.println();
		preOrder(tree);
		preRightLeft(tree);
		prosOrder(tree);
		pro2Order(tree);
		inOrder(tree);
		level(tree);
		System.out.println(maxWidthMap(tree)+"  "+maxWidthMap(tree));
	}

	public static void preOrder(Node x) {
		if (x == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.add(x);
		while (!stack.isEmpty()) {
			Node tmp = stack.pop();
			System.out.print(tmp.value + " ");
			if (tmp.right != null) {
				stack.add(tmp.right);
			}
			if (tmp.left != null) {
				stack.add(tmp.left);
			}
		}
		System.out.println();
	}

	public static void preRightLeft(Node x) {
		if (x == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.add(x);
		while (!stack.isEmpty()) {
			Node tmp = stack.pop();
			System.out.print(tmp.value + " ");
			if (tmp.left != null) {
				stack.add(tmp.left);
			}
			if (tmp.right != null) {
				stack.add(tmp.right);
			}
		}
		System.out.println();
	}

	public static void prosOrder(Node x) {
		if (x == null) {
			return;
		}
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.add(x);
		while (!stack1.isEmpty()) {
			Node tmp = stack1.pop();
			stack2.add(tmp);
			if (tmp.left != null) {
				stack1.push(tmp.left);
			}
			if (tmp.right != null) {
				stack1.push(tmp.right);
			}
		}
		while (!stack2.isEmpty()) {
			Node tmp = stack2.pop();
			System.out.print(tmp.value + " ");
		}
		System.out.println();
	}

	public static void inOrder(Node x) {
		if (x != null) {
			Stack<Node> s1 = new Stack<>();
			while (!s1.isEmpty() || x != null) {
				if (x != null) {
					s1.push(x);
					x = x.left;
				} else {
					x = s1.pop();
					System.out.print(x.value + " ");
					x = x.right;
				}
			}
		}
		System.out.println();
	}

	public static void pro2Order(Node h) {
		if (h != null) {
			Stack<Node> s = new Stack<>();
			s.push(h);
			Node c = null;
			while (!s.isEmpty()) {
				c = s.peek();
				if (c.left != null && h != c.left && h != c.right) {
					s.push(c.left);
				} else if (c.right != null && c.right != h) {
					s.push(c.right);
				} else {
					System.out.print(s.pop().value + " ");
					h = c;
				}
			}
		}
		System.out.println();
	}

	public static void level(Node x) {
		if (x == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(x);
		while (!queue.isEmpty()) {
			Node tmp = queue.poll();
			System.out.print(tmp.value + " ");
			if (tmp.left != null) {
				queue.add(tmp.left);
			}
			if (tmp.right != null) {
				queue.add(tmp.right);
			}
		}
		System.out.println();
	}

	public static int maxWidthMap(Node x) {
		if (x == null) {
			return 0;
		}
		Queue<Node> queue = new LinkedList<>();
		HashMap<Node, Integer> levelMap = new HashMap<>();
		levelMap.put(x, 1);
		queue.add(x);
		int max = 0;
		int curLevel = 1;
		int curLevelNodes = 0;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int curNodelevels = levelMap.get(cur);
			if (cur.left != null) {
				queue.add(cur.left);
				levelMap.put(cur.left, curNodelevels + 1);
			}
			if (cur.right != null) {
				queue.add(cur.right);
				levelMap.put(cur.right, curNodelevels + 1);
			}
			if (curLevel == curNodelevels) {
				curLevelNodes++;
			} else {
				max = Math.max(max, curLevelNodes);
				curLevel++;
				curLevelNodes = 1;
			}
		}
		max = Math.max(max, curLevelNodes);
		return max;
	}
	
	public static int maxWidth(Node x) {
		if(x==null) {
			return 0;
		}
		Queue<Node> queue=new LinkedList<>();
		queue.add(x);
		Node curEnd=x;
		Node nextEnd=null;
		int max=0;
		int curLevelNodes=0;
		while(!queue.isEmpty()) {
			Node cur=queue.poll();
			if(cur.left!=null) {
				queue.add(cur.left);
				nextEnd=cur.left;
			}
			if(cur.right!=null) {
				queue.add(cur.right);
				nextEnd=cur.right;
			}
			curLevelNodes++;
			if(cur==curEnd) {
				max=Math.max(max, curLevelNodes);
				curEnd=nextEnd;
				curLevelNodes=0;
			}
		}
		return max;
	}
}
