package dataStructure;

public class RBTree<K extends Comparable<K>,V>{
	private static final boolean RED=false;
	private static final boolean BLACK=true;
	private RBNode root;
	
	
	public void put(K key,V value)
	{
		RBNode t=this.root;
		if(t==null) {
			root=new RBNode<>(key,value==null?key:value,null);
			return;
		}
		//寻找插入位置，定义一个双亲指针：
		RBNode parent;
		int cmp;
		if(key==null)
			throw new NullPointerException();
		do
		{
			parent=t;
			cmp=key.compareTo((K)t.key);
			if(cmp<0)
				t=t.left;
			else if(cmp>0)
				t=t.right;
			else
			{
				t.setValue(value==null?key:value);
				return;
			}
		}while(t!=null);
		RBNode<K,Object> e=new RBNode<>(key,value==null?key:value,parent);
		//在parent后插入
		if(cmp<0) {
			parent.left=e;
		}else {
			parent.right=e;
		}
		//调整:
	}
	
	private void setColor(RBNode node,boolean color) {
		if(node!=null) {
			node.color=color;
		}
	}
	private RBNode parentOf(RBNode node)
	{
		return node!=null?node.parent:null;
	}
	private RBNode leftOf(RBNode node)
	{
		return node!=null?node.left:null;
	}
	private RBNode rightOf(RBNode node)
	{
		return node!=null?node.right:null;
	}
	private boolean colorOf(RBNode node) {
		return node==null?BLACK:node.color;
	}
	
	
	/*1:         2,3,4树 2节点合并==红黑树：上黑下红，不调整
	 *2：        2，3，4树  新节点与3节点合并 4种情况
	 *   1            3       2          3         1
	 *    \          /       / \        /           \
	 *     2        2       1   3      2             2
	 *      \      /                    \           /
	 *       3    1                      2.5      1.5
	 *3:        2,3,4树新节点与四节点（3元素）合并。  红黑树：四节点中间元素升级为父亲节点。新增爷爷为红色
	 *                                                    父亲和叔叔为黑色，新儿子为红色
	 * 
	 * 
	 */
	
	private void fixAfterPut(RBNode x)
	{
		x.color=RED;
		while(x!=null&&x!=root&&x.parent.color==RED) {
			//左倾3斜树：x.parent是爷爷的左孩子
			/*     3
			 *    / \
			 *   2   y
			 *  /
			 * 1（x) 
			 */
			if(parentOf(x)==leftOf(parentOf(parentOf(x)))) {
				RBNode y=rightOf(parentOf(parentOf(x)));
				if(colorOf(y)==RED)    //不需要调整，只需要变色     看叔叔的颜色 
				{       //                                   叔叔为空y颜色为黑色，红色证明有叔叔
					setColor(y, BLACK);                 //   有叔叔就只需要变色，没叔叔就需要右旋
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)),RED);
					x=parentOf(parentOf(x));  //递归，因为不知道上面还有几层
				}
				else {
					if(x==rightOf(parentOf(x))) { //   3         3
						x=parentOf(x);            //  /         /
						leftRotate(x);          //   2        2.5
					}                             //  \        /
					                           //     2.5(x)  2 
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					rightRotate(parentOf(parentOf(x)));
				}
			}
			else {           //右三：两种情况  一种有叔叔不旋转，一种没叔叔旋转
				RBNode l=leftOf(parentOf(parentOf(x)));
				if(colorOf(l)==RED) {       //有叔叔节点的右三  不用调整
					setColor(l, BLACK);
					setColor(parentOf(parentOf(x)), RED);
					setColor(parentOf(x), BLACK);
					x=parentOf(parentOf(x));
				}
				else {                     //没叔叔也有两种情况：右三斜树，右三 折树
					if(x==leftOf(parentOf(x))) { //折树先旋转
						x=parentOf(x);
						rightRotate(x);
					}
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					leftRotate(parentOf(parentOf(x)));
				}
			}
		}
		root.color=BLACK;
	}
	private void leftRotate(RBNode p)
	{
		if(p!=null)
		{
			RBNode r=p.right;                 //         p                   pr(r)
			p.right=r.left;                   //        /  \                /  \
			if(r.left!=null)                  //       pl   pr(r)          p    prr
				r.left.parent=p;              //           /  \           / \
			r.parent=p.parent;                //         prl   prr       pl  prl
			if(p.parent==null) {              //
				root=r;
			}
			else if(p.parent.left==p)
			{
				p.parent.left=r;
			}
			else
				p.parent.right=r;
			r.left=p;
			p.parent=r;
		}
	}
	private void rightRotate(RBNode p)
	{
		if(p!=null) {
			RBNode r=p.left;
			p.left=r.right;
			if(r.right!=null) {
				r.right.parent=p;
			}
			if(p.parent==null) {
				root=r;
			}
			else if(p.parent.left==p) {
				p.parent.left=r;
			}
			else
				p.parent.right=r;
			r.parent=p.parent;
			r.right=p;
			p.parent=r;
		}
	}
	static class RBNode<K extends Comparable<K>,V>
	{
		private RBNode parent;
		private RBNode left;
		private RBNode right;
		private K key;
		private V value;
		private boolean color;
		public RBNode() {
		}
		public RBNode(K key, V value,RBNode parent) {
			super();
			this.parent = parent;
			this.key = key;
			this.value = value;
			this.color = BLACK;
		}
		public RBNode(RBNode parent, RBNode left, RBNode right, K data, V value, boolean color) {
			super();
			this.parent = parent;
			this.left = left;
			this.right = right;
			this.key = data;
			this.value = value;
			this.color = color;
		}
		public RBNode getParent() {
			return parent;
		}
		public void setParent(RBNode parent) {
			this.parent = parent;
		}
		public RBNode getLeft() {
			return left;
		}
		public void setLeft(RBNode left) {
			this.left = left;
		}
		public RBNode getRight() {
			return right;
		}
		public void setRight(RBNode right) {
			this.right = right;
		}
		public K getData() {
			return key;
		}
		public void setData(K data) {
			this.key = data;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
		public boolean isColor() {
			return color;
		}
		public void setColor(boolean color) {
			this.color = color;
		}
	}
}
