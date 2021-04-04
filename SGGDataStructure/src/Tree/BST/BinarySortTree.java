package Tree.BST;

/**
 * ��һ��Ҫ�㣡������
 * ��ɾ���ڵ�ʱ�����ֻʣroot��һ��Ҷ�ӽڵ� Ҫɾ��root��ʱ��  parent=null
 * ���ʱ�򽫶��ӱ�Ϊroot
 * @author admin11
 *
 */
public class BinarySortTree {
	public static void main(String[] args) {
		int arr[] = { 7, 3, 10, 12, 5, 1, 9,2 };
		BST bt = new BST();
		for (int i : arr) {
			bt.add(new Node(i));
		}
		bt.infixOrder();
		System.out.println("~~~~~~~~~~~~~");
		bt.deletNode(2);bt.deletNode(5);bt.deletNode(9);bt.deletNode(12);bt.deletNode(7);
		bt.deletNode(3);//bt.deletNode(10);bt.deletNode(1);
		bt.deletNode(1);
		bt.infixOrder();
		System.out.println(bt.getRoot());
	}
}

class BST {
	private Node root;

	/**
	 * ɾ���ڵ��˼·�� 1�������ҵ���������ڵ� ���������ĸ��ڵ� �����޸� 2��ɾ���ļ�������� ��1����Ŀ��ڵ�ֻ��һ���ӽڵ㣬ֱ�Ӹ��ڵ��������Ķ���
	 * ��2���������ڵ� ����Max �ݹ�ɾ
	 * 
	 * @param node
	 */

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
			//����һ��������߼� ��target!=null   ˵���ҵ���Ŀ���
			//root�Ǹ����ڵ� ˵��target==root,Ҫɾ�� ֱ��ɾroot ��OK
			if (targetNode == null) {
				return;
			}
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			Node parent = searchParent(value);
			//ɾ��Ҷ�ӽڵ�
			if (targetNode.left == null && targetNode.right == null) {
				if (parent.left != null && parent.left.value == value) {
					parent.left = null;
				} else if (parent.right != null && parent.right.value == value) {
					parent.right = null;
				}
			}else if(targetNode.left!=null&&targetNode.right!=null) {
				Node leftMax=findLeftMax(targetNode);
				int temp=leftMax.value;
				deletNode(temp);
				targetNode.value=temp;
			}else {
				Node child=targetNode.left!=null?targetNode.left:targetNode.right;
				//һ��BUG  ֻ��root��root.left  Ҫɾ��root ��root��parent=null
				if(parent==null) {
					root=child;
				}else {
					if(parent.left!=null&&parent.left.value==value) {
						parent.left=child;
					}else if(parent.right!=null&&parent.right.value==value) {
						parent.right=child;
					}
				}
				
			}
		}
	}
	
	public Node findLeftMax(Node node) {
		Node cur=node.left;
		while(cur.right!=null) {
			cur=cur.right;
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