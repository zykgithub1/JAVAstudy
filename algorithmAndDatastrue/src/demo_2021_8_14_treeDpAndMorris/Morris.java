package demo_2021_8_14_treeDpAndMorris;

import demo_2021_8_14_treeDpAndMorris.treeDpMaxtDistance.Node;

/*
 * 假设来到当前节点cur 
 * - 1>如果cur没有左孩子，cur向右移动
 * - 2>如果cur有左孩子，找到左子树上最右的节点mostRight
 * 		a.如果mostRight的右指针为空，让其指向cur，然后cur向左移动
 *      b.如果mostRight的右指针指向cur，让其指向null，然后cur向右移动（cur=cur.right)
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
					// 第一次来到cur
					System.out.println(cur.value);
					mostRight.right = cur;
					cur = cur.left;
					continue;
				} else {
					mostRight.right = null;
				}
			} else {
				// 没有左子树的情况 只会来到一次
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
				// 第一次来到cur
				// 中序只打第二次回到的时候
				// 因为第一次来到时continue掉了 所以不打 第二次和只到一次的节点才打
				if (mostRight.right == null) {
					mostRight.right = cur;
					cur = cur.left;
					continue;
				} else {
					mostRight.right = null;
				}
			}
			// 没有左树直接跳过if 直接打印向右移动
			// 有左树直接打
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
				// 第一次来到cur
				// 中序只打第二次回到的时候
				// 因为第一次来到时continue掉了 所以不打 第二次和只到一次的节点才打
				if (mostRight.right == null) {
					mostRight.right = cur;
					cur = cur.left;
					continue;
				} else {
					mostRight.right = null;
				}
			}
			// 没有左树直接跳过if 直接打印向右移动
			// 有左树直接打
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
					// 后续就是第二次来到这个点时 逆序打印它左孩子的右边界
					mostRight.right = null;
					printEdge(cur.left);
				}
			}
			cur = cur.right;
		}
		// 最后再逆序整棵树的右边界
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
