package Tree.ThreadBinaryTree;

public class ThreadedBinaryTree {
	public static void main(String[] args) {
		HeroNode root = new HeroNode(1, "tom");
		HeroNode node2 = new HeroNode(3, "jack");
		HeroNode node3 = new HeroNode(6, "smith");
		HeroNode node4 = new HeroNode(8, "marry");
		HeroNode node5 = new HeroNode(10, "kim");
		HeroNode node6 = new HeroNode(14, "dim");
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		BinaryTree TT = new BinaryTree();
		TT.setRoot(root);
		TT.prosOrder();
		TT.prosThreadNodes(root);
		System.out.println("---");
		System.out.println(node5.getRight());
//		System.out.println("前序线索化");
//		TT.preThreadNodes();
//		TT.preThreadList();
//		TT.infixOrder();
//		TT.threadNodes();
//		System.out.println("线索化");
//		TT.ThreadList();
	}

}

class BinaryTree {
	private HeroNode root;
	private HeroNode pre = null;

	public void ThreadList() {
		if (root == null) {
			return;
		}
		HeroNode cur = root;
		while (cur != null) {
			while (cur.getLeftType() == 0) {
				cur = cur.getLeft();
			}
			System.out.println(cur);
			while (cur.getRight() != null && cur.getRightType() == 1) {
				cur = cur.getRight();
				System.out.println(cur);
			}
			cur = cur.getRight();
		}
	}

	public HeroNode getRoot() {
		return root;
	}

	public void threadNodes() {
		this.threadNodes(root);
	}

	public void preThreadNodes() {
		this.preThreadNodes(root);
	}

	public void prosThreadNodes(HeroNode node) {
		if (node == null) {
			return;
		}
		if (node.getLeft() != null && node.getLeft().getRightType() == 0) {
			prosThreadNodes(node.getLeft());
		}
		if (node.getRight() != null && node.getRight().getRightType() == 0) {
			prosThreadNodes(node.getRight());
		}
		if (node.getLeft() == null) {
			node.setLeftType(1);
			node.setLeft(pre);
		}
		if (pre != null && pre.getRight() != null) {
			pre.setRightType(1);
			pre.setRight(node);
		}
		pre = node;
	}

	public void preThreadNodes(HeroNode node) {
		if (node == null) {
			return;
		}
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		if (pre != null && pre.getRight() == null) {
			pre.setRightType(1);
			pre.setRight(node);
		}
		pre = node;
		if (node.getLeftType() == 0) {
			preThreadNodes(node.getLeft());
		}
		if (node.getRightType() == 0) {
			preThreadNodes(node.getRight());
		}
	}

	public void preThreadList() {
		if (root == null) {
			return;
		}
		HeroNode cur = root;
		while (cur != null) {
			System.out.println(cur);
			if (cur.getLeftType() == 0) {
				cur = cur.getLeft();
			} else {
				cur = cur.getRight();
			}
		}
	}

	public void threadNodes(HeroNode node) {
		if (node == null) {
			return;
		}
		// 线索化左子树
		threadNodes(node.getLeft());
		// 左子树为空，就让左子树指向pre，并设置flag
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		// pre的右子树为空，就让它的右子树指向后继为node，并设置flag
		if (pre != null && pre.getRight() == null) {
			pre.setRight(node);
			pre.setRightType(1);
		}
		// pre和node进行迭代
		pre = node;
		// 递归线索化右子树
		threadNodes(node.getRight());

	}

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	public void preOder() {
		if (this.root != null) {
			root.preOrder();
		} else {
			System.out.println("empty Tree");
		}
	}

	public void infixOrder() {
		if (root != null) {
			root.infixOrder();
		} else {
			System.out.println("empty");
		}
	}

	public void prosOrder() {
		if (root != null) {
			root.prosOder();
		} else {
			System.out.println("empty");
		}
	}

	public HeroNode preOrderSearch(int no) {
		if (root != null) {
			return this.root.preOrderSearch(no);
		} else {
			System.out.println("empty");
			return null;
		}
	}

	public HeroNode infixOrderSearch(int no) {
		if (root != null) {
			return this.root.infixOrderSearch(no);
		} else {
			System.out.println("empty");
			return null;
		}
	}
}

class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	// leftType==0表示指向的是左子树，1表示指向前驱节点
	// rightType==0表示指向右子树，1表示后继节点
	private int leftType = 0;
	private int rightType = 0;

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	};

	public void preOrder() {
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
		System.out.println(this);
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

	public void prosOder() {
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
		System.out.println(this);
	}

	public HeroNode preOrderSearch(int no) {
		if (this.no == no) {
			return this;
		}
		HeroNode cur = null;
		if (this.left != null) {
			cur = this.left.preOrderSearch(no);
		}
		if (cur != null) {
			return cur;
		}
		if (this.right != null) {
			cur = this.right.preOrderSearch(no);
		}
		return cur;
	}

	public HeroNode infixOrderSearch(int no) {
		HeroNode cur = null;
		if (this.left != null) {
			cur = this.left.infixOrderSearch(no);
		}
		if (cur != null) {
			return cur;
		}
		if (this.no == no) {
			return this;
		} else {
			if (this.right != null) {
				cur = this.right.infixOrderSearch(no);
			}
		}
		return cur;
	}

	public void delNode(int no) {
		if (this.left != null && left.no == no) {
			left = null;
			return;
		}
		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		if (this.left != null) {
			this.left.delNode(no);
		}
		if (this.right != null) {
			this.right.delNode(no);
		}
	}
}