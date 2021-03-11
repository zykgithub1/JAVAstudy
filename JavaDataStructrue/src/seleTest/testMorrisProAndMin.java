package selfTest;


import selfTest.selfTestTree.Node;

public class testMorrisProAndMin {
	public static void main(String[] args) {
		Node tree=selfTestTree.creatTree();
		
		selfTest.morriSelfTest.morrisPosOrder(tree);
		morrisPros(tree);
		System.out.println(findMinLeavf(tree));
		
	}
	
	public static void preOrder(Node x) {
		if(x==null) {
			return;
		}
		Node cur=x;
		Node pre=null;
		while(cur!=null) {
			
		}
	}
	
	public static int findMinLeavf(Node x) {
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
				int righBoardSize=1;
				while(mostRight.right!=null&&mostRight.right!=cur) {
					righBoardSize++;
					mostRight=mostRight.right;
				}if(mostRight.right==null) {
					mostRight.right=cur;
					cur=cur.left;
					curLevel++;
					continue;
				}else {
					if(mostRight.left==null) {
						minHeight=Math.min(curLevel, minHeight);
					}
					curLevel-=righBoardSize;
					mostRight.right=null;
				}
			}else {
				curLevel++;
			}
			cur=cur.right;
		}
		int firstRight=1;
		cur=x;
		while(cur.right!=null) {
			firstRight++;
			cur=cur.right;
		}
		if(cur.left==null) {
			minHeight=Math.min(minHeight, firstRight);
		}
		return minHeight;
		
	}
	
	
	public static void morrisPros(Node x) {
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
		Node tail=reverse(head);
		Node cur=tail;
		while(cur!=null) {
			System.out.print(cur.value+" ");
			cur=cur.right;
		}
		reverse(tail);
	}


	private static Node reverse(Node head) {
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

}
