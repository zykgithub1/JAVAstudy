package Tree.BST;

/**
 * 有一个要点！！！！
 * 在删除节点时，最后只剩root和一个叶子节点 要删除root的时候  parent=null
 * 这个时候将儿子变为root
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
	 * 删除节点的思路： 1，首先找到有无这个节点 而后找它的父节点 而后修改 2，删除的几种情况： （1），目标节点只有一个子节点，直接父节点连上它的儿子
	 * （2），两个节点 找左Max 递归删
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
			//这是一个巧妙的逻辑 ：target!=null   说明找到了目标点
			//root是个单节点 说明target==root,要删它 直接删root 就OK
			if (targetNode == null) {
				return;
			}
			if (root.left == null && root.right == null) {
				root = null;
				return;
			}
			Node parent = searchParent(value);
			//删除叶子节点
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
				//一个BUG  只有root和root.left  要删除root ，root的parent=null
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