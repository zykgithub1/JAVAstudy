package Tree;

import java.util.LinkedList;
import java.util.Queue;
import selfTest.selfTestTree;
import selfTest.selfTestTree.Node;

public class isCompleteBinaryTree {
	public static void main(String[] args) {
		Node tree=selfTestTree.creatTree();
//		System.out.println(isCompleteBT(tree));
//		selfTestTree.show(tree);
		int maxLevel=5;
		int maxValue=100;
		int testTimes=100000;
		for(int i=0;i<testTimes;i++) {
			Node head=generateRandomBT(maxLevel,maxValue);
			if(isCompleteBT(head)!=isCBT2(head).isCBT) {
				System.out.println("Oops!!!");
			}
		}
		Node headX=generateRandomBT(maxLevel, maxValue);
		selfTestTree.show(headX);
		System.out.println("end!!");
	}
	private static Node generateRandomBT(int maxLevel, int maxValue) {
		return generate(1,maxLevel,maxValue);
	}
	private static Node generate(int i, int maxLevel, int maxValue) {
		if(i>maxLevel) {
			return null;
		}
		Node head=new Node((int)(Math.random()*maxValue));
		head.left=generate(i+1, maxLevel, maxValue);
		head.right=generate(i+1, maxLevel, maxValue);
		return head;
	}
	public static boolean isCompleteBT(Node x) {
		if(x==null) {//��������Ľڵ�ֱ��pass
			return true;
		}
		boolean leaf=false; //�ж��Ƿ���ֲ���ȫ�Ľڵ㣺�������ҵĽڵ������ֵ�Ҫȫ����Ҷ�ӽڵ㣻
		Node l=null;
		Node r=null;
		Queue<Node> queue=new LinkedList<>();
		queue.add(x);
		while(!queue.isEmpty()) {
			x=queue.poll();
			l=x.left;r=x.right;
			//��������ֱ��pass ||һ�����ֲ�˫ȫ�ڵ���Ƿ�����Ľڵ�ȫ��Ҷ�ӽڵ�
			if((l==null&&r!=null)||(leaf&&!(l==null&&r==null))) {
				return false;
			}
			if(l!=null) {
				queue.add(l);
			}
			if(r!=null) {
				queue.add(r);
			}
			if(l==null||r==null) {
				leaf=true;
			}
		}
		return true;
	}
	static class info{
		boolean isFull;
		boolean isCBT;
		int height;
		public info(boolean isFull, boolean isCBT, int height) {
			super();
			this.isFull = isFull;
			this.isCBT = isCBT;
			this.height = height;
		}
	}
	
	public static info isCBT2(Node x) {
		if(x==null) {
			return new info(true, true, 0);
		}
		info leftInfo=isCBT2(x.left);
		info rightInfo=isCBT2(x.right);
		int height=Math.max(leftInfo.height, rightInfo.height)+1;
		boolean isFull=leftInfo.isFull&&rightInfo.isFull&&leftInfo.height==rightInfo.height;
		boolean isCBT=false;
		if(isFull) {
			isCBT=true;
		}else {
			if(leftInfo.isCBT&&rightInfo.isFull&&leftInfo.height-rightInfo.height==1) {
				isCBT=true;
			}
			if(leftInfo.isFull&&rightInfo.isCBT&&leftInfo.height==rightInfo.height) {
				isCBT=true;
			}
			if(leftInfo.isFull&&rightInfo.isFull&&leftInfo.height==rightInfo.height+1) {
				isCBT=true;
			}
		}
		return new info(isFull, isCBT, height);
	}
}
