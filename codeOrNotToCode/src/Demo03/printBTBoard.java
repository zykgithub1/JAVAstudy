package Demo03;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import Demo03.traversalAllApproaches;
public class printBTBoard {
	public static void main(String[] args) {
		CeatTree BT=new CeatTree(new int[] {1});
		BT.root.left=new Node(2);
		BT.root.right=new Node(3);
		BT.root.left.right=new Node(4);
		BT.root.left.right.left=new Node(7);
		BT.root.left.right.right=new Node(8);
		BT.root.left.right.right.right=new Node(11);
		BT.root.left.right.right.right.left=new Node(13);
		BT.root.left.right.right.right.right=new Node(14);
		
		
		
		BT.root.right=new Node(3);
		BT.root.right.right=new Node(6);
		BT.root.right.left=new Node(5);
		BT.root.right.left.right=new Node(10);
		BT.root.right.left.left=new Node(9);
		BT.root.right.left.left.left=new Node(12);
		BT.root.right.left.left.left.left=new Node(15);
		BT.root.right.left.left.left.right=new Node(16);
		traversalAllApproaches.preOrderRecur1(BT.root);
		printEdges1(BT.root);
		System.out.println("\n解法二");
		printEdges2(BT.root);
		Set<Integer>set=new HashSet<>();
		HashMap<Integer,Integer>map=new HashMap<>();
		map.getOrDefault(map, null);
	}

	private static void printEdges2(Node head) {
		if(head==null) {
			return;
		}
		if(head.left!=null&&head.right!=null) {
			printLeftEdge(head.left,true);
			printRightEdge(head.right,true);
		}else {
			printEdges2(head.left!=null?head.left:head.right);
		}
		System.out.println();
		
	}

	private static void printRightEdge(Node head, boolean print) {
		if(head==null) {
			return;
		}
		printRightEdge(head.left, print&&head.right==null?true:false);
		printRightEdge(head.right, print);
		if(print||(head.left==null&&head.right==null)) {
			System.out.print(head.value+" ");
		}
		
		
	}

	private static void printLeftEdge(Node head, boolean print) {
		if(head==null) {
			return;
		}
		if(print||(head.left==null&&head.right==null)) {
			System.out.print(head.value+" ");
		}
		printLeftEdge(head.left, print);
		printLeftEdge(head.right, print&&head.left==null?true:false);
		
	}

	public static void printEdges1(Node head) {
		if(head==null) {
			return;
		}
		int height=getHeight(head,0);
		System.out.println("\n树高度为"+height);
		Node[][]edgeMap=new Node[height][2];
		setEdgeMap(head,0,edgeMap);
		//打印左边界：
		for(int i=0;i<height;i++) {
			System.out.print(edgeMap[i][0].value+" ");
		}
		//打印既不是左边界，也不是右边界的叶子节点:
		printLeafNotInMap(head,0,edgeMap);
		//打印右边界,并且不是左边界的数字
		for(int i=height-1;i>=0;i--) {
			if(edgeMap[i][0].value!=edgeMap[i][1].value) {
				System.out.print(edgeMap[i][1].value+" ");
			}
		}
	}

	private static void printLeafNotInMap(Node head, int i, Node[][] edgeMap) {
		if(head==null) {
			return;
		}
		if(head.left==null&&head.right==null&&head!=edgeMap[i][0]&&head!=edgeMap[i][1]) {
			System.out.print(head.value+" ");
		}
		printLeafNotInMap(head.left, i+1, edgeMap);
		printLeafNotInMap(head.right, i+1, edgeMap);
		
	}

	private static void setEdgeMap(Node head, int i, Node[][] edgeMap) {
		if(head==null) {
			return;
		}
		edgeMap[i][0]=edgeMap[i][0]==null?head:edgeMap[i][0];
		edgeMap[i][1]=head;
		setEdgeMap(head.left, i+1, edgeMap);
		setEdgeMap(head.right, i+1, edgeMap);
	}

	private static int getHeight(Node head, int i) {
		if(head==null) {
			return i;
		}
		return Math.max(getHeight(head.left, i+1), getHeight(head.right, i+1));
	}
}
