package Demo03;

import java.util.Stack;

public class traversalAllApproaches {
	public static void main(String[] args) {
		int[]arr={4,2,6,1,3,5,7};
		CeatTree tree=new CeatTree(arr);
		preOrderRecur(tree.root);
		inOrderRecur(tree.root);
		prosOrderRecur(tree.root);
		preOrderUnrecur(tree.root);
		inOrderUnrecur(tree.root);
		inOrderUnrecur1(tree.root);
		prosOrderUnrecur1(tree.root);
		prosOrderUnrecur2(tree.root);
				
	}

	public static void prosOrderUnrecur2(Node root) {
		System.out.println("\n后续单栈非递归");
		Stack<Node>stack=new Stack();
		Node c=null;
		Node h=root;
		stack.push(h);
		while(!stack.isEmpty()) {
			c=stack.peek();
			if(c.left!=null&&h!=c.left&&h!=c.right) {
				stack.push(c.left);
			}else if(h==c.left&&c.right!=null) {
				stack.push(c.right);
			}else {
				System.out.print(stack.pop().value+" ");
				h=c;
			}
		}
	}

	private static void prosOrderUnrecur1(Node root) {
		System.out.println("\n后续非递归(双栈)");
		Stack<Node>stack1=new Stack();
		Stack<Node>stack2=new Stack();
		stack1.push(root);
		while(!stack1.isEmpty()) {
			root=stack1.pop();
			stack2.push(root);
			if(root.left!=null) {
				stack1.push(root.left);
			}
			if(root.right!=null) {
				stack1.push(root.right);
			}
		}
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop().value+" ");
		}
		
	}

	public static void inOrderUnrecur1(Node root) {
		System.out.println("\nself中序非递归");
		Stack<Node>stack=new Stack();
		while(!stack.isEmpty()||root!=null) {
			if(root!=null) {
				stack.push(root);
				root=root.left;
			}else {
				root=stack.pop();
				System.out.print(root.value+" ");
				root=root.right;
			}
		}
	}

	private static void inOrderUnrecur(Node root) {
		System.out.println("\n非递归中序遍历");
		Stack<Node>stack=new Stack();
		while(!stack.isEmpty()||root!=null) {
			if(root!=null) {
				stack.push(root);
				root=root.left;
			}else {
				root=stack.pop();
				System.out.print(root.value+" ");
				root=root.right;
			}
		}
	}

	private static void preOrderUnrecur(Node root) {
		System.out.println("\n非递归先序");
		Stack<Node>stack=new Stack();
		stack.add(root);
		while(!stack.isEmpty()) {
			root=stack.pop();
			System.out.print(root.value+" ");
			if(root.right!=null) {
				stack.push(root.right);
			}
			if(root.left!=null) {
				stack.push(root.left);
			}
		}
	}

	private static void prosOrderRecur(Node root) {
		if(root==null) {
			return;
		}
		prosOrderRecur(root.left);
		prosOrderRecur(root.right);
		System.out.print(root.value+" ");
	}

	private static void inOrderRecur(Node root) {
		inOrderRecur1(root);
		System.out.println();
		
	}

	private static void inOrderRecur1(Node root) {
		if(root==null) {
			return;
		}
		inOrderRecur1(root.left);
		System.out.print(root.value+" ");
		inOrderRecur1(root.right);
	}
	
	public static void preOrderRecur(Node root) {
		preOrderRecur1(root);
		System.out.println();
	}

	public static void preOrderRecur1(Node root) {
		if(root==null) {
			return;
		}
		System.out.print(root.value+" ");
		preOrderRecur1(root.left);
		preOrderRecur1(root.right);
	}

}
class Node{
	public int value;
	public Node left;
	public Node right;
	public Node(int value) {
		super();
		this.value = value;
	}
	public void add(Node node) {
		if(node==null) {
			return;
		}
		if(this.value>node.value) {
			if(this.left==null) {
				this.left=node;
			}else {
				this.left.add(node);
			}
		}else {
			if(this.right==null) {
				this.right=node;
			}else {
				this.right.add(node);
			}
		}
	}
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}	
	
	
}
class CeatTree{
	public int[] arr;
	public Node root;

	public CeatTree(int[] arr) {
		super();
		this.arr = arr;
		root=new Node(arr[0]);
		for(int i=1;i<arr.length;i++) {
			root.add(new Node(arr[i]));
		}
	}
}