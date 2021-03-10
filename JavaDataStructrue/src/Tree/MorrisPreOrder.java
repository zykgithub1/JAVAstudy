package Tree;

import selfTest.selfTestTree;
import selfTest.selfTestTree.Node;

public class MorrisPreOrder {
	public static void main(String[] args) {
		Node tree=selfTestTree.creatTree();
		morris(tree);
		System.out.println();
		selfTestTree.show(tree);
		System.out.println();
		morrisSelf(tree);
		morrisCVersion(tree);
	}
	
	public static void morrisCVersion(Node x) {
		System.out.println("C°æ±¾");
		if(x==null) {
			return;
		}
		Node cur=x;
		Node pre=null;
		while(cur!=null) {
			if(cur.left==null) {
				System.out.print(cur.value+" ");
				cur=cur.right;
			}else {
				pre=cur.left;
				while(pre.right!=null&&pre.right!=cur) {
					pre=pre.right;
				}
				if(pre.right==null) {
					pre.right=cur;
					cur=cur.left;
				}
				else {
					pre.right=null;
					System.out.print(cur.value+" ");
					cur=cur.right;
				}
			}
		}
	}
	
	public static void morrisSelf(Node x) {
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
				}
			}
			System.out.print(cur.value+" ");
			cur=cur.right;
		}
	}
	

	public static void morris(Node x) {
		if (x == null) {
			return;
		}
		Node cur = x;
		Node pre=null;
		while (cur != null) {
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
				}
			}
			System.out.print(cur.value+" ");
			cur=cur.right;
		}
	}
}
