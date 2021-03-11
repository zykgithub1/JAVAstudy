package selfTest;

import selfTest.selfTestTree.*;

public class morriSelfTest {
	public static void main(String[] args) {
		Node tree = selfTest.selfTestTree.creatTree();
		System.out.println(isBST(tree));
		//selfTestTree.show(tree);
		morrisInorder(tree);
		morrisInCVersion(tree);
		morrisPreOrder(tree);
		morrisPosOrder(tree);
		System.out.println(minHeight(tree));
	}
	
	public static int minHeight(Node x) {
		if(x==null) {
			return 0;
		}
		Node cur=x;
		Node mostRight=null;
		int curLevel=0;
		int minHeight=Integer.MAX_VALUE;
		while(cur!=null) {
			mostRight=cur.left;
			if(mostRight!=null) {
				int rightBoardSize=1;
				while(mostRight.right!=null&&mostRight.right!=cur) {
					rightBoardSize++;
					mostRight=mostRight.right;
				}
				if(mostRight.right==null) {
					mostRight.right=cur;
					cur=cur.left;
					curLevel++;
					continue;
				}else {
					if(mostRight.left==null) {
						minHeight=Math.min(curLevel, minHeight);
					}
					curLevel-=rightBoardSize;
					mostRight.right=null;
				}
			}else {
				curLevel++;
			}
			cur=cur.right;
		}
		int finalRight=1;
		cur=x;
		while(cur.right!=null) {
			cur=cur.right;
			finalRight++;
		}
		if(cur.left==null&&cur.right==null) {
			minHeight=Math.min(finalRight, minHeight);
		}
		return minHeight;
	}
	
	
	
	
	
	public static void morrisPosOrder(Node x) {
		if(x==null) {
			return;
		}
		Node cur=x;
		Node pre=null;
		while(cur!=null) {
			pre=cur.left;
			if(pre!=null) {
				while(pre.right!=null&&pre.right!=cur) {
					pre=pre.right;
				}
				if(pre.right==null) {
					pre.right=cur;
					cur=cur.left;
					continue;
				}else {
					pre.right=null;
					printEdge(cur.left);
				}
			}
			cur=cur.right;
		}
		printEdge(x);
		System.out.println();
	}
	
	private static void printEdge(Node head) {
		Node tail=reverseEdge(head);
		Node cur=tail;
		while(cur!=null) {
			System.out.print(cur.value+" ");
			cur=cur.right;
		}
		reverseEdge(tail);
	}

	private static Node reverseEdge(Node head) {
		Node node=null;
		Node newNode=null;
		while(head!=null) {
			node=head;
			head=head.right;
			node.right=newNode;
			newNode=node;
		}
		return newNode;
	}
	
	public static boolean isBST(Node head) {
		if(head==null) {
			return true;
		}
		Node cur=head;
		Node mostRight=null;
		boolean flag=true;
		Integer pre=null;
		while(cur!=null) {
			mostRight=cur.left;
			if(mostRight!=null) {
				while(mostRight.right!=null&&mostRight.right!=cur) {
					mostRight=mostRight.right;
				}
				if(mostRight.right==null) {
					mostRight.right=cur;
					cur=cur.left;
					continue;
				}else {
					mostRight.right=null;
				}
			}
			if(pre!=null&&pre>=cur.value) {
				flag=false;
			}
			pre=cur.value;
			cur=cur.right;
		}
		return flag;
	}

	public static void morrisPreOrder(Node x) {
		if(x==null) {
			return;
		}
		Node cur=x;
		Node pre=null;
		while(cur!=null) {
			pre=cur.left;
			if(pre!=null) {
				while(pre.right!=null&&pre.right!=cur) {
					pre=pre.right;
				}
				if(pre.right==null) {
					pre.right=cur;
					System.out.print(cur.value+" ");
					cur=cur.left;
					continue;
				}
				else {
					pre.right=null;
				}
			}else {
				System.out.print(cur.value+" ");
			}
			cur=cur.right;
		}
		System.out.println();
	}

	public static void morrisInCVersion(Node x) {
		if (x == null) {
			return;
		}
		Node cur = x;
		Node pre = null;
		while (cur != null) {
			pre = cur.left;
			if (pre == null) {
				System.out.print(cur.value+" ");
				cur=cur.right;
			} else {
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				if(pre.right==null) {
					pre.right=cur;
					cur=cur.left;
				}else {
					pre.right=null;
					System.out.print(cur.value+" ");
					cur=cur.right;
				}
			}
		}
		System.out.println();
	}

	public static void morrisInorder(Node x) {
		if (x == null) {
			return;
		}
		Node cur = x;
		Node pre = null;
		while (cur != null) {
			pre = cur.left;
			if (pre != null) {
				while (pre.right != null && pre.right != cur) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = cur;
					cur = cur.left;
					continue;
				} else {
					pre.right = null;
				}
			}
			System.out.print(cur.value + " ");
			cur = cur.right;
		}
		System.out.println();
	}

}
