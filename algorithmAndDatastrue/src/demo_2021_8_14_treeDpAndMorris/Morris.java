package demo_2021_8_14_treeDpAndMorris;

import demo_2021_8_14_treeDpAndMorris.treeDpMaxtDistance.Node;

/*
 * ����������ǰ�ڵ�cur 
 * - 1>���curû�����ӣ�cur�����ƶ�
 * - 2>���cur�����ӣ��ҵ������������ҵĽڵ�mostRight
 * 		a.���mostRight����ָ��Ϊ�գ�����ָ��cur��Ȼ��cur�����ƶ�
 *      b.���mostRight����ָ��ָ��cur������ָ��null��Ȼ��cur�����ƶ���cur=cur.right)
 * - 3> cease in cur ==null
 */
public class Morris {
	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		long value=Long.MIN_VALUE+Integer.MAX_VALUE;
		System.out.println(value);
	}
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

	public static void morris(Node root) {
		if (root == null) {
			return;
		}
		Node cur = root;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {
				while (mostRight.right != null && mostRight.right != cur) {
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) {
					mostRight.right = cur;
					cur = cur.left;
					continue;
				} else {
					mostRight.right = null;
				}
			}
			cur = cur.right;
		}
	}

	public static void morrisPreorder(Node root) {
		if (root == null) {
			return;
		}
		Node cur = root;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {
				while (mostRight.right != null && mostRight.right != cur) {
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) {
					// ��һ������cur
					System.out.println(cur.value);
					mostRight.right = cur;
					cur = cur.left;
					continue;
				} else {
					mostRight.right = null;
				}
			} else {
				// û������������� ֻ������һ��
				System.out.println(cur.value);
			}
			cur = cur.right;
		}
	}

	public static void morrisInorder(Node root) {
		if (root == null) {
			return;
		}
		Node cur = root;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {
				while (mostRight.right != null && mostRight.right != cur) {
					mostRight = mostRight.right;
				}
				// ��һ������cur
				// ����ֻ��ڶ��λص���ʱ��
				// ��Ϊ��һ������ʱcontinue���� ���Բ��� �ڶ��κ�ֻ��һ�εĽڵ�Ŵ�
				if (mostRight.right == null) {
					mostRight.right = cur;
					cur = cur.left;
					continue;
				} else {
					mostRight.right = null;
				}
			}
			// û������ֱ������if ֱ�Ӵ�ӡ�����ƶ�
			// ������ֱ�Ӵ�
			System.out.println(cur.value);
			cur = cur.right;
		}
	}

	public static boolean morrisInorderJudgeIsBST(Node root) {
		if (root == null) {
			return true;
		}
		Node cur = root;
		Node mostRight = null;
		int preValue = Integer.MIN_VALUE;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {
				while (mostRight.right != null && mostRight.right != cur) {
					mostRight = mostRight.right;
				}
				// ��һ������cur
				// ����ֻ��ڶ��λص���ʱ��
				// ��Ϊ��һ������ʱcontinue���� ���Բ��� �ڶ��κ�ֻ��һ�εĽڵ�Ŵ�
				if (mostRight.right == null) {
					mostRight.right = cur;
					cur = cur.left;
					continue;
				} else {
					mostRight.right = null;
				}
			}
			// û������ֱ������if ֱ�Ӵ�ӡ�����ƶ�
			// ������ֱ�Ӵ�
			if (preValue >= cur.value) {
				return false;
			}
			preValue = cur.value;
			cur = cur.right;
		}
		return true;
	}

	public static void morrisPostOrder(Node root) {
		if (root == null) {
			return;
		}
		Node cur = root;
		Node mostRight = null;
		while (cur != null) {
			mostRight = cur.left;
			if (mostRight != null) {
				while (mostRight.right != null && mostRight.right != cur) {
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) {
					mostRight.right = cur;
					cur = cur.left;
					continue;
				} else {
					// �������ǵڶ������������ʱ �����ӡ�����ӵ��ұ߽�
					mostRight.right = null;
					printEdge(cur.left);
				}
			}
			cur = cur.right;
		}
		// ������������������ұ߽�
		printEdge(root);
		System.out.println();
	}

	public static void printEdge(Node X) {
		Node tail = reverseEdge(X);
		Node cur = tail;
		while (cur != null) {
			System.out.println(cur.value);
			cur = cur.right;
		}
		reverseEdge(tail);
	}

	private static Node reverseEdge(Node x) {
		Node cur = x;
		Node temp = null;
		Node next = null;
		while (cur != null) {
			next = cur.right;
			cur.right = temp;
			temp = cur;
			cur = next;
		}
		return temp;
	}
}
