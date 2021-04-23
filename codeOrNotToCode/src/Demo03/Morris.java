package Demo03;

public class Morris {
	public static void main(String[] args) {
		Node root=printBTreeDirectly.creatTree();
		traversalAllApproaches.preOrderRecur(root);
		printBTreeDirectly.printTree(root);
		morrisPreOrder(root);
		morrisInOrder(root);
		printBTreeDirectly.printTree(root);
		traversalAllApproaches.prosOrderUnrecur1(root);
		morrisProsOrder(root);
		traversalAllApproaches.prosOrderUnrecur2(root);
		printBTreeDirectly.printTree(root);
	}

	private static void morrisProsOrder(Node root) {
		System.out.println("\n手写后续");
		if(root==null) {
			return;
		}
		Node pre=null;
		Node cur=root;
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
		printEdge(root);
		System.out.println();
	}

	private static void printEdge(Node head) {
		Node tail=reverse(head);
		Node cur=tail;
		while(cur!=null) {
			System.out.print(cur.value+" ");
			cur=cur.right;
		}
		head=reverse(tail);
	}

	private static Node reverse(Node head) {
		Node cur,next,newNode;
		cur=head;
		newNode=null;
		while(cur!=null) {
			next=cur.right;
			cur.right=newNode;
			newNode=cur;
			cur=next;
		}
		return newNode;
	}

	private static void morrisInOrder(Node root) {
		System.out.println("\nmorris中序");
		if(root==null) {
			return;
		}
		Node cur=root;
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

	private static void morrisPreOrder(Node root) {
		if(root==null) {
			return;
		}
		Node cur=root;
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
				}else {
					pre.right=null;
				}
				
			}else {
				System.out.print(cur.value+" ");
			}
			cur=cur.right;
		}
	}

}
