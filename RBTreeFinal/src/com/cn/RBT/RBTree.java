package com.cn.RBT;

public class RBTree<K extends Comparable<K>,V>{
	private static final boolean RED=false;
	private static final boolean BLACK=true;
	private  RBNode root;
	
	//找到前驱节点
	private RBNode predecessor(RBNode node) {
		
		if(node==null)
			return null;
		else if(node.left!=null) {
			RBNode x=node.left;
			while(x.right!=null) {
				x=x.right;
			}
			return x;
		}
		else {
			RBNode p=node.parent;
			RBNode ch=node;
			while(p!=null&&ch==p.left) {
				ch=p;
				p=p.parent;
			}
			return p;
		}
	}
	
	private RBNode sucessor(RBNode node) {
		if(node==null)
			return null;
		else if(node.right!=null) {
			RBNode r=node.right;
			while(r.left!=null) {
				r=r.left;
			}
			return r;
		}
		else {
			RBNode p=node.parent;
			RBNode ch=node;
			while(p!=null&&p.right==ch){
				ch=p;
				p=p.parent;
			}
			return p;
		}
	}
	
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
		root.color=BLACK;   //根节点必须是黑色；
	}
	
	public V remove(K key) {
		RBNode node=getNode(key);
		if(node==null) {
			return null;
		}
		V oldValue=(V) node.value;
		deleteNode(node);
		return oldValue;
	}
	/*删除节点：1，叶子
	 *         2，单子
	 *         3，双子
	 * 
	 */
	private void deleteNode(RBNode node) {
		RBNode p=node.parent;
		//双子情况：
		if(node.left!=null&&node.right!=null) {
			RBNode successor=sucessor(node);
			node.key=successor.key;
			node.value=successor.value;
			node=successor;
		}
		RBNode replacement=node.left!=null?node.left:node.right;
		//替代节点不为空
		if(replacement!=null) {
			replacement.parent=node.parent;
			//node是根节点：
			if(node.parent==null) {
				root=replacement;
			}//node是左儿子
			else if(node==node.parent.left) {
				node.parent.left=replacement;
			}
			else {
				node.parent.right=replacement;
			}
			//断开node的所有指针，让它被jvm回收：
			node.left=node.right=node.parent=null;
			//替换完之后需要调整平衡:  如果是红色节点不管，是黑色就需要调整
			if(node.color==BLACK) {
				//替代节点一定是红色，需要变色
				fixAfterRemove(replacement);
			}
		}//根节点
		else if(node.parent==null) {
			root=null;
		}//node是叶子节点 先调整再删除：
		else {
			if(node.color==BLACK) {
				fixAfterRemove(node);
			}
			//删除：
			if(node.parent.left==node) {
				node.parent.left=null;
			}
			else {
				node.parent.right=null;
			}
			node.parent=null;
		}
	}
	//三种情况：
	/*1，自己能搞定， 对应2，3，4树相当于删除3，4节点（可以是红也可以是黑，是黑的话儿子顶替变色）
	 *2，自己搞不定，找父亲借，兄弟再去顶替父亲
	 *3.兄弟也穷借不出来
	 * 
	 */
	private void fixAfterRemove(RBNode x) {
		while(x!=root&&colorOf(x)==BLACK) {
			//x是左孩子的情况：
			if(x==leftOf(parentOf(x))) {
				RBNode rnode=rightOf(parentOf(x));//此时这个兄弟不一定是真兄弟，因为红黑树对应二三四树
			                                //2，3，4树的兄弟可能是2，3，4节点，转化为红黑树后层次不同
				//判断是不是真兄弟：
				if(colorOf(rnode)==RED) {
					setColor(rnode, BLACK);
					setColor(parentOf(x), RED);
					leftRotate(parentOf(x));
					rnode=rightOf(parentOf(x));
				}
				//情况3，兄弟也穷： 
				//如果兄弟有孩子，他的孩子肯定是红色。
				if(colorOf(leftOf(rnode))==BLACK&&colorOf(rightOf(rnode))==BLACK) {
					setColor(rnode, RED);
					x=parentOf(x);
				}
				//情况2，找兄弟借兄弟有得借 
				else {
					//兄弟节点是3，4节点的情况：
					if(colorOf(rightOf(rnode))==BLACK) {
						setColor(rnode, RED);
						setColor(leftOf(rnode), BLACK);
						rightRotate(rnode);
						rnode=rightOf(parentOf(x));
					}
					setColor(rnode, colorOf(parentOf(x)));
					setColor(parentOf(x), BLACK);
					setColor(rightOf(rnode), BLACK);
					leftRotate(parentOf(x));
					x=root;
				}
			}
			else {
				RBNode lnode=leftOf(parentOf(x));
				//判断是不是真兄弟：
				if(colorOf(lnode)==RED) {
					setColor(lnode, BLACK);
					setColor(parentOf(x), RED);
					rightOf(parentOf(x));
					lnode=leftOf(parentOf(x));
				}
				//情况3，兄弟也穷： 
				//兄弟没孩子                                              如果兄弟有孩子，他的孩子肯定是红色。
				if(colorOf(leftOf(lnode))==BLACK&&colorOf(rightOf(lnode))==BLACK) {
					setColor(lnode, RED);
					x=parentOf(x);
				}
				//情况2，找兄弟借兄弟有得借 
				else {
					//兄弟节点是3，4节点的情况：
					if(colorOf(leftOf(lnode))==BLACK) {
						setColor(lnode, RED);
						setColor(rightOf(lnode), BLACK);
						leftRotate(lnode);
						lnode=leftOf(parentOf(x));
					}
					setColor(lnode, colorOf(parentOf(x)));
					setColor(parentOf(x), BLACK);
					setColor(leftOf(lnode), BLACK);
					rightRotate(parentOf(x));
					x=root;
				}
			}
		}
		//情况1，自己能搞定   替代节点是红色，直接染黑
		setColor(x, BLACK);
	}
	private RBNode getNode(K key) {
		RBNode node=root;
		while(node!=null) {
			int cmp=key.compareTo((K)node.key);
			if(cmp<0)
				node=node.left;
			else if(cmp>0) {
				node=node.right;
			}
			else
				return node;
		}
		return null;
	}
	private void leftRotate(RBNode p)
	{
//		if(p!=null)
//		{
//			RBNode r=p.right;                 //         p                   pr(r)
//			p.right=r.left;                   //        /  \                /  \
//			if(r.left!=null)                  //       pl   pr(r)          p    prr
//				r.left.parent=p;              //           /  \           / \
//			r.parent=p.parent;                //         prl   prr       pl  prl
//			if(p.parent==null) {              //
//				root=r;
//			}
//			else if(p.parent.left==p)
//			{
//				p.parent.left=r;
//			}
//			else
//				p.parent.right=r;
//			r.left=p;
//			p.parent=r;
//		}
		if(p==null) {
			return;
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
	public  RBNode getRoot() {
		return root;
	}
}
