package Demo03;

public class Morris {
	public static void main(String[] args) {
		Node root=printBTreeDirectly.creatTree();
		traversalAllApproaches.preOrderRecur(root);
		morrisPreOrder(root);
		morrisInOrder(root);
	}

	private static void morrisInOrder(Node root) {
		System.out.println("\nmorris÷––Ú");
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
