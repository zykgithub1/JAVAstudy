package Tree.avlTree;
public class AVLTreeDemo {

	public static void main(String[] args) {
		//int arr[]= {4,3,6,5,7,8};
		//int arr[]= {1,2,3,4,5};
//		int arr[]= {10,12,8,9,7,6};
		int arr[]= {10,11,7,6,8,9};
		//int arr[]= {1,2,3,4,5,6,7,8,9,10};
		AVLTree avlTree=new AVLTree();
		for(int i:arr) {
			avlTree.add(new Node(i));
		}
		Node root=avlTree.getRoot();
		System.out.println("���ĸ߶�Ϊ    "+avlTree.getRoot().height());
		System.out.println("�������ĸ߶�Ϊ    "+avlTree.getRoot().leftHeight());
		System.out.println("�����ĸ߶�Ϊ    "+avlTree.getRoot().rightHeight());
		System.out.println(root);
		System.out.println(root.left);
		System.out.println(root.right);
//		System.out.println(root.right.left);
//		System.out.println(root.right.right);
		
		
	}
}

class AVLTree {
	private Node root;
	
	public Node search(int val) {
		if (root == null) {
			return null;
		} else {
			return root.search(val);
		}
	}

	public Node searchParent(int val) {
		if (root == null) {
			return null;
		} else {
			return root.searchParent(val);
		}
	}

	public void deletNode(int value) {
		if (root == null) {
			return;
		} else {
			Node targetNode = search(value);
			// ����һ��������߼� ��target!=null ˵���ҵ���Ŀ���
			// root�Ǹ����ڵ� ˵��target==root,Ҫɾ�� ֱ��ɾroot ��OK
			if (targetNode == null) {
				return;
			}
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			Node parent = searchParent(value);
			// ɾ��Ҷ�ӽڵ�
			if (targetNode.left == null && targetNode.right == null) {
				if (parent.left != null && parent.left.value == value) {
					parent.left = null;
				} else if (parent.right != null && parent.right.value == value) {
					parent.right = null;
				}
			} else if (targetNode.left != null && targetNode.right != null) {
				Node leftMax = findLeftMax(targetNode);
				int temp = leftMax.value;
				deletNode(temp);
				targetNode.value = temp;
			} else {
				Node child = targetNode.left != null ? targetNode.left : targetNode.right;
				// һ��BUG ֻ��root��root.left Ҫɾ��root ��root��parent=null
				if (parent == null) {
					root = child;
				} else {
					if (parent.left != null && parent.left.value == value) {
						parent.left = child;
					} else if (parent.right != null && parent.right.value == value) {
						parent.right = child;
					}
				}
			}
		}
	}

	public Node findLeftMax(Node node) {
		Node cur = node.left;
		while (cur.right != null) {
			cur = cur.right;
		}
		return cur;
	}

	public void add(Node node) {
		if (root == null) {
			this.setRoot(node);
		} else {
			root.add(node);
		}
	}

	public void infixOrder() {
		if (root != null) {
			root.infixOrder();
		} else {
			System.out.println("Empty");
		}
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

}

class Node {
	public int value;
	public Node left;
	public Node right;

	public Node(int value) {
		super();
		this.value = value;
	}
	
	/**
	 * ����  �½����ڵ�
	 */
	public void leftRatate() {
		Node head=new Node(value);
		head.left=this.left;
		head.right=this.right.left;
		this.value=right.value;
		this.right=right.right;
		this.left=head;
	}
	
	/**
	 * ����
	 */
	public void rightRatate() {
		Node head=new Node(value);
		head.right=this.right;
		head.left=this.left.right;
		this.value=this.left.value;
		this.left=this.left.left;
		this.right=head;
	}

	public int height() {
		return Math.max(this.left == null ? 0 : this.left.height(), this.right == null ? 0 : this.right.height()) + 1;
	}

	public int leftHeight() {
		if (left == null) {
			return 0;
		} else {
			return this.left.height();
		}
	}

	public int rightHeight() {
		if (this.right == null) {
			return 0;
		} else {
			return this.right.height();
		}
	}

	public Node search(int val) {
		if (this.value == val) {
			return this;
		} else if (this.value > val && this.left != null) {
			return this.left.search(val);
		} else if (this.value < val && this.right != null) {
			return this.right.search(val);
		} else {
			return null;
		}
	}

	public Node searchParent(int val) {
		if ((this.left != null && this.left.value == val) || (this.right != null && this.right.value == val)) {
			return this;
		} else {
			if (this.value <= val && this.right != null) {
				return this.right.searchParent(val);
			} else if (this.value > val && this.left != null) {
				return this.left.searchParent(val);
			} else {
				return null;
			}
		}
	}

	public void add(Node node) {
		if (node == null) {
			return;
		}
		if (node.value < this.value) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.add(node);
			}
		} else {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}
		}
		//�������һ���ڵ�����������-��>1     �ұ߶����� ��������
		if(rightHeight()-leftHeight()>1) {
			if(this.right!=null&&this.right.leftHeight()>this.right.rightHeight()) {
				this.right.rightRatate();
			}
			leftRatate();
			return;
		}
		//����
		if(leftHeight()-rightHeight()>1) {
			if(this.left!=null&&this.left.rightHeight()>this.left.leftHeight()) {
				this.left.leftRatate();
			}
			rightRatate();
		}
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
}