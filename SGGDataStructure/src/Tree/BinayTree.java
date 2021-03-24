package Tree;

public class BinayTree {
	public static void main(String[] args) {
		BinaryTree BT=new BinaryTree();
		HeroNode root=new HeroNode(1, "宋江");
		HeroNode node2=new HeroNode(2, "吴用");
		HeroNode node3=new HeroNode(3, "卢俊义");
		HeroNode node4=new HeroNode(4, "林冲");
		BT.setRoot(root);
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
//		BT.preOder();
//		BT.infixOrder();
		HeroNode cur=BT.infixOrderSearch(4);
		System.out.println(cur);
		
		
		
	}
}
class BinaryTree{
	private HeroNode root;

	public HeroNode getRoot() {
		return root;
	}

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	public void preOder() {
		if(this.root!=null) {
			root.preOrder();
		}else {
			System.out.println("empty Tree");
		}
	}
	public void infixOrder() {
		if(root!=null) {
			root.infixOrder();
		}else {
			System.out.println("empty");
		}
	}
	
	public void prosOrder() {
		if(root!=null) {
			root.prosOder();
		}else {
			System.out.println("empty");
		}
	}
	public HeroNode preOrderSearch(int no) {
		if(root!=null) {
			return this.root.preOrderSearch(no);
		}else {
			System.out.println("empty");
			return null;
		}
	}
	public HeroNode infixOrderSearch(int no) {
		if(root!=null) {
			return this.root.infixOrderSearch(no);
		}else {
			System.out.println("empty");
			return null;
		}
	}

	
	
}
class HeroNode{
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
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
		System.out.println(this);
		if(this.left!=null) {
			this.left.preOrder();
		}
		if(this.right!=null) {
			this.right.preOrder();
		}
	}
	public void infixOrder() {
		if(this.left!=null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if(this.right!=null) {
			this.right.infixOrder();
		}
	}
	
	public void prosOder() {
		if(this.left!=null) {
			this.left.preOrder();
		}
		if(this.right!=null) {
			this.right.preOrder();
		}
		System.out.println(this);
	}
	
	public HeroNode preOrderSearch(int no) {
		if(this.no==no) {
			return this;
		}
		HeroNode cur=null;
		if(this.left!=null) {
			cur= this.left.preOrderSearch(no);
		}
		if(cur!=null) {
			return cur;
		}
		if(this.right!=null) {
			cur=this.right.preOrderSearch(no);
		}
		return cur;
	}
	
	public HeroNode infixOrderSearch(int no) {
		HeroNode cur=null;
		if(this.left!=null) {
			cur=this.left.infixOrderSearch(no);
		}
		if(cur!=null) {
			return cur;
		}
		if(this.no==no) {
			return this;
		}else {
			if(this.right!=null) {
				cur=this.right.infixOrderSearch(no);
			}
		}
		return cur;
	}
	public void delNode(int no) {
		if(this.left!=null&&left.no==no) {
			left=null;
			return;
		}
		if(this.right!=null&&this.right.no==no) {
			this.right=null;
			return;
		}
		if(this.left!=null) {
			this.left.delNode(no);
		}
		if(this.right!=null) {
			this.right.delNode(no);
		}
		
		
	}
	
	
}
