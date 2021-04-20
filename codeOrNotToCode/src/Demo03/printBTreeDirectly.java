package Demo03;

public class printBTreeDirectly {
	public static void main(String[] args) {
		Node root=creatTree();
		traversalAllApproaches.preOrderRecur(root);
		printTree(root);
		
	}
	
	private static void printTree(Node root) {
		System.out.println("BinaryTree");
		printTreeInorder(root,0,"H",13);
		System.out.println();
		
	}

	private static void printTreeInorder(Node root, int height, String to, int len) {
		if(root==null) {
			return;
		}
		printTreeInorder(root.right, height+1, "¡ý", len);
		String val=to+root.value+to;
		int lenM=val.length();
		int lenL=(len-lenM)/2;
		int lenR=len-lenM-lenL;
		val=getSpace(lenL)+val+getSpace(lenR);
		System.out.println(getSpace(len*height)+val);
		printTreeInorder(root.left, height+1, "¡ü", len);
		
	}

	private static String getSpace(int lenL) {
		String space=" ";
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<lenL;i++) {
			sb.append(space);
		}
		return sb.toString();
	}

	public static Node creatTree() {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.right.left=new Node(5);
		root.right.right=new Node(6);
		root.left.left=new Node(4);
		root.left.left.right=new Node(7);
		return root;
	}

}
