package com.cn.RBT;

public class RBTree<K extends Comparable<K>,V>{
	private static final boolean RED=false;
	private static final boolean BLACK=true;
	private  RBNode root;
	
	//�ҵ�ǰ���ڵ�
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
		//Ѱ�Ҳ���λ�ã�����һ��˫��ָ�룺
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
		//��parent�����
		if(cmp<0) {
			parent.left=e;
		}else {
			parent.right=e;
		}
		//����:
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
	
	
	/*1:         2,3,4�� 2�ڵ�ϲ�==��������Ϻ��º죬������
	 *2��        2��3��4��  �½ڵ���3�ڵ�ϲ� 4�����
	 *   1            3       2          3         1
	 *    \          /       / \        /           \
	 *     2        2       1   3      2             2
	 *      \      /                    \           /
	 *       3    1                      2.5      1.5
	 *3:        2,3,4���½ڵ����Ľڵ㣨3Ԫ�أ��ϲ���  ��������Ľڵ��м�Ԫ������Ϊ���׽ڵ㡣����үүΪ��ɫ
	 *                                                    ���׺�����Ϊ��ɫ���¶���Ϊ��ɫ
	 * 
	 * 
	 */
	
	private void fixAfterPut(RBNode x)
	{
		x.color=RED;
		while(x!=null&&x!=root&&x.parent.color==RED) {
			//����3б����x.parent��үү������
			/*     3
			 *    / \
			 *   2   y
			 *  /
			 * 1��x) 
			 */
			if(parentOf(x)==leftOf(parentOf(parentOf(x)))) {
				RBNode y=rightOf(parentOf(parentOf(x)));
				if(colorOf(y)==RED)    //����Ҫ������ֻ��Ҫ��ɫ     ���������ɫ 
				{       //                                   ����Ϊ��y��ɫΪ��ɫ����ɫ֤��������
					setColor(y, BLACK);                 //   �������ֻ��Ҫ��ɫ��û�������Ҫ����
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)),RED);
					x=parentOf(parentOf(x));  //�ݹ飬��Ϊ��֪�����滹�м���
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
			else {           //�������������  һ�������岻��ת��һ��û������ת
				RBNode l=leftOf(parentOf(parentOf(x)));
				if(colorOf(l)==RED) {       //������ڵ������  ���õ���
					setColor(l, BLACK);
					setColor(parentOf(parentOf(x)), RED);
					setColor(parentOf(x), BLACK);
					x=parentOf(parentOf(x));
				}
				else {                     //û����Ҳ���������������б�������� ����
					if(x==leftOf(parentOf(x))) { //��������ת
						x=parentOf(x);
						rightRotate(x);
					}
					setColor(parentOf(x), BLACK);
					setColor(parentOf(parentOf(x)), RED);
					leftRotate(parentOf(parentOf(x)));
				}
			}
		}
		root.color=BLACK;   //���ڵ�����Ǻ�ɫ��
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
	/*ɾ���ڵ㣺1��Ҷ��
	 *         2������
	 *         3��˫��
	 * 
	 */
	private void deleteNode(RBNode node) {
		RBNode p=node.parent;
		//˫�������
		if(node.left!=null&&node.right!=null) {
			RBNode successor=sucessor(node);
			node.key=successor.key;
			node.value=successor.value;
			node=successor;
		}
		RBNode replacement=node.left!=null?node.left:node.right;
		//����ڵ㲻Ϊ��
		if(replacement!=null) {
			replacement.parent=node.parent;
			//node�Ǹ��ڵ㣺
			if(node.parent==null) {
				root=replacement;
			}//node�������
			else if(node==node.parent.left) {
				node.parent.left=replacement;
			}
			else {
				node.parent.right=replacement;
			}
			//�Ͽ�node������ָ�룬������jvm���գ�
			node.left=node.right=node.parent=null;
			//�滻��֮����Ҫ����ƽ��:  ����Ǻ�ɫ�ڵ㲻�ܣ��Ǻ�ɫ����Ҫ����
			if(node.color==BLACK) {
				//����ڵ�һ���Ǻ�ɫ����Ҫ��ɫ
				fixAfterRemove(replacement);
			}
		}//���ڵ�
		else if(node.parent==null) {
			root=null;
		}//node��Ҷ�ӽڵ� �ȵ�����ɾ����
		else {
			if(node.color==BLACK) {
				fixAfterRemove(node);
			}
			//ɾ����
			if(node.parent.left==node) {
				node.parent.left=null;
			}
			else {
				node.parent.right=null;
			}
			node.parent=null;
		}
	}
	//���������
	/*1���Լ��ܸ㶨�� ��Ӧ2��3��4���൱��ɾ��3��4�ڵ㣨�����Ǻ�Ҳ�����Ǻڣ��ǺڵĻ����Ӷ����ɫ��
	 *2���Լ��㲻�����Ҹ��׽裬�ֵ���ȥ���游��
	 *3.�ֵ�Ҳ��費����
	 * 
	 */
	private void fixAfterRemove(RBNode x) {
		while(x!=root&&colorOf(x)==BLACK) {
			//x�����ӵ������
			if(x==leftOf(parentOf(x))) {
				RBNode rnode=rightOf(parentOf(x));//��ʱ����ֵܲ�һ�������ֵܣ���Ϊ�������Ӧ��������
			                                //2��3��4�����ֵܿ�����2��3��4�ڵ㣬ת��Ϊ��������β�ͬ
				//�ж��ǲ������ֵܣ�
				if(colorOf(rnode)==RED) {
					setColor(rnode, BLACK);
					setColor(parentOf(x), RED);
					leftRotate(parentOf(x));
					rnode=rightOf(parentOf(x));
				}
				//���3���ֵ�Ҳ� 
				//����ֵ��к��ӣ����ĺ��ӿ϶��Ǻ�ɫ��
				if(colorOf(leftOf(rnode))==BLACK&&colorOf(rightOf(rnode))==BLACK) {
					setColor(rnode, RED);
					x=parentOf(x);
				}
				//���2�����ֵܽ��ֵ��еý� 
				else {
					//�ֵܽڵ���3��4�ڵ�������
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
				//�ж��ǲ������ֵܣ�
				if(colorOf(lnode)==RED) {
					setColor(lnode, BLACK);
					setColor(parentOf(x), RED);
					rightOf(parentOf(x));
					lnode=leftOf(parentOf(x));
				}
				//���3���ֵ�Ҳ� 
				//�ֵ�û����                                              ����ֵ��к��ӣ����ĺ��ӿ϶��Ǻ�ɫ��
				if(colorOf(leftOf(lnode))==BLACK&&colorOf(rightOf(lnode))==BLACK) {
					setColor(lnode, RED);
					x=parentOf(x);
				}
				//���2�����ֵܽ��ֵ��еý� 
				else {
					//�ֵܽڵ���3��4�ڵ�������
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
		//���1���Լ��ܸ㶨   ����ڵ��Ǻ�ɫ��ֱ��Ⱦ��
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
