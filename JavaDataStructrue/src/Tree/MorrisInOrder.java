package Tree;

import selfTest.selfTestTree;
import selfTest.selfTestTree.*;

public class MorrisInOrder {
	public static void main(String[] args) {
		Node tree=selfTestTree.creatTree();
		morris(tree);
		System.out.println();
		preOrder(tree);
		
	}
	
	public static void morris(Node x) {
		if(x==null) {
			return;
		}
		Node cur=x;
		Node pre=null;
		while(cur!=null) {
			pre=cur.left;
			if(pre==null) {
				System.out.print(cur.value+" ");
				cur=cur.right;
			}
			else {
				while(pre.right!=null&&pre.right!=cur) {
					pre=pre.right;
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
	}
	public static void preOrder(Node x) {
		if(x==null) {
			return;
		}
		Node cur=x;
		Node mostRight=null;
		while(cur!=null) {
			mostRight=cur.left;
			if(mostRight!=null) {
				while(mostRight.right!=null&&mostRight.right!=cur) {
					mostRight=mostRight.right;
				}
				if(mostRight.right==null) {
					mostRight.right=cur;
					System.out.print(cur.value+" ");
					cur=cur.left;
					continue;
				}else {
					mostRight.right=null;
				}
			}else {
				System.out.print(cur.value+" ");
			}
			
			cur=cur.right;
		}
	}

}
