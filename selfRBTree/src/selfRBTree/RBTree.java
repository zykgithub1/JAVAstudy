package selfRBTree;





public class RBTree<K extends Comparable<K>,V>{
	private static final boolean BLACK=true;
	private static final boolean RED=false;
	private RBNode root;
	
	public RBNode getRoot() {
		return root;
	}
	
	private boolean colorOf(RBNode node) {
		return node==null?BLACK:node.color;
	}
	
	private RBNode leftOf(RBNode node) {
		return node==null?null:node.left;
	}
	private RBNode rightOf(RBNode node) {
		return node==null?null:node.right;
	}
	private RBNode paentOf(RBNode node) {
		return node==null?null:node.parent;
	}
	
	private RBNode getNode(K key) {
		RBNode t=root;
		while(t!=null) {
			int cmp=key.compareTo((K)t.key);
			if(cmp>0) {
				t=t.right;
			}
			else if(cmp<0) {
				t=t.left;
			}
			else {
				return t;
			}
		}
		return null;
	}
	
	private void leftRotate(RBNode node) {
		if(node==null) {
			return;
		}
		RBNode r=node.right;
		node.right=r.left;
		if(r.left!=null) {
			r.left.parent=node;
		}
		r.parent=node.parent;
		if(node.parent==null) {
			root=r;
		}
		else {
			if(node==node.parent.left) {
				node.parent.left=r;
			}
			else {
				node.parent.right=r;
			}
		}
		r.left=node;
		node.parent=r;
	}
	private void rightRotate(RBNode p) {
		if(p!=null) {
			RBNode l=p.left;
			p.left=l.right;
			if(l.right!=null) {
				l.right.parent=p;
			}
			l.parent=p.parent;
			if(p.parent==null) {
				root=l;
			}
			else if(p.parent.left==p) {
				p.parent.left=l;
			}
			else {
				p.parent.right=l;
			}
			p.parent=l;
			l.right=p;
		}
	}
	public void put(K key,V value) {
		RBNode t=root;
		if(t==null) {
			root=new RBNode(key,value==null?key:value,null);
			return;
		}
		RBNode parent;
		int cmp;
		if (key == null) {
            throw new NullPointerException();
        }
		do {
			parent=t;
			cmp=key.compareTo((K)t.key);
			if(cmp>0) {
				t=t.right;
			}
			else if(cmp<0) {
				t=t.left;
			}
			else {
				t.setValue(value==null?key:value);
				return;
			}
		}while(t!=null);
		RBNode e=new RBNode(key,value==null?key:value,parent);
		if(cmp>0) {
			parent.right=e;
		}
		else {
			parent.left=e;
		}
		//调整：
		fixAfterPut(e);
	}
	
	private void fixAfterPut(RBNode x) {
		x.color=RED;
		while(x!=null&&x!=root&&colorOf(paentOf(x))==RED) {
			if(x.parent==paentOf(paentOf(x)).left) {
				RBNode y=rightOf(paentOf(paentOf(x)));
				if(colorOf(y)==RED) {//有叔叔  只变色
					setColor(y, BLACK);
					setColor(paentOf(x), BLACK);
					setColor(paentOf(paentOf(x)), RED);
					x=paentOf(paentOf(x));
				}
				else {
					if(x==rightOf(paentOf(x))) {
						x=paentOf(x);
						leftRotate(x);
						
					}
					setColor(paentOf(x), BLACK);
					setColor(paentOf(paentOf(x)), RED);
					rightRotate(paentOf(paentOf(x)));
				}
			}
			else {
				RBNode l=leftOf(paentOf(paentOf(x)));
				if(colorOf(l)==RED) {
					setColor(l, BLACK);
					setColor(paentOf(x), BLACK);
					setColor(paentOf(paentOf(x)), RED);
					x=paentOf(paentOf(x));
				}
				else {
					if(x==leftOf(paentOf(x))) {
						x=paentOf(x);
						rightRotate(x);
					}
					setColor(paentOf(x), BLACK);
					setColor(paentOf(paentOf(x)), RED);
					leftRotate(paentOf(paentOf(x)));
				}
			}
		}
		root.color=BLACK;
	}
	
	
	private void deleteNode(RBNode node) {
		//双子情况：找前驱，用前驱的值替代后 node变为前驱节点，删前驱就行
		if(node.left!=null&&node.right!=null) {
			RBNode processor=getProcessor(node);
			node.key=processor.key;
			node.value=processor.value;
			node=processor;
		}
		RBNode replacement=node.left!=null?node.left:node.right;
		if(replacement!=null) {
			replacement.parent=node.parent;
			if(node.parent==null) {
				root=replacement;
			}else if(node==leftOf(paentOf(node))) {
				node.parent.left=replacement;
			}
			else {
				node.parent.right=replacement;
			}
			node.parent=node.left=node.right=null;
			if(node.color==BLACK) {
				fixAfterRemove(replacement);
			}
		}
		else if(node.parent==null) {//根节点删除
			root=null;
		}
		else {//叶子节点删除：
			if(node.color==BLACK) {
				fixAfterRemove(node);
			}
			if(node==node.parent.left) {
				node.parent.left=null;
			}
			else {
				node.parent.right=null;
			}
			node.parent=null;
		}
	}
	
	
	private void fixAfterRemove(RBNode node) {
		
		
	}

	private RBNode getProcessor(RBNode x) {
		if(x==null) {
			return null;
		}else {
			RBNode l=leftOf(x);
			if(l!=null) {
				while(rightOf(l)!=null) {
					l=rightOf(l);
				}
				return l;
			}else {
				RBNode pre=paentOf(x);
				l=x;
				while(leftOf(pre)==l&&pre!=null) {
					l=pre;
					pre=paentOf(pre);
				}
				return pre;
			}
		}
	}
	private RBNode getSuccessor(RBNode node) {
		if(node==null) {
			return null;
		}else if(node.right!=null){
			RBNode r=node.right;
			while(leftOf(r)!=null) {
				r=r.left;
			}
			return r;
		}else {
			RBNode pre=paentOf(node);
			RBNode ch=node;
			while(pre.right==ch&&pre!=null) {
				ch=pre;
				pre=pre.parent;
			}
			return pre;
		}
	}
	private void setColor(RBNode node,boolean color) {
		if(node!=null) {
			node.color=color;
		}
	}
	static class RBNode<K extends Comparable<K>,V>{
		boolean color;
		K key;
		V value;
		RBNode left;
		RBNode right;
		RBNode parent;
		
		public RBNode() {
			// TODO Auto-generated constructor stub
		}

		public RBNode(K key, V value, RBNode parent) {
			super();
			this.key = key;
			this.value = value;
			this.parent = parent;
			this.color=BLACK;
		}

		public boolean isColor() {
			return color;
		}

		public void setColor(boolean color) {
			this.color = color;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
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

		public RBNode getParent() {
			return parent;
		}

		public void setParent(RBNode parent) {
			this.parent = parent;
		}
	}
}
