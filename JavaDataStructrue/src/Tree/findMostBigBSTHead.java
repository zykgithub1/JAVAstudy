package Tree;

import selfTest.selfTestTree;
import selfTest.selfTestTree.Node;

public class findMostBigBSTHead {
	public static void main(String[] args) {
		Node tree=selfTestTree.creatTree();
		System.out.println(bigestBST(tree));
	}
	public static class info{
		public Node maxSubBSTHead;
		public int maxSubBSTSize;
		public int min;
		public int max;
		public info(Node maxSubBSTHead, int maxSubBSTSize, int min, int max) {
			this.maxSubBSTHead = maxSubBSTHead;
			this.maxSubBSTSize = maxSubBSTSize;
			this.min = min;
			this.max = max;
		}
	}
	public static int bigestBST(Node x) {
		if(x==null) {
			return 0;
		}
		return process(x).maxSubBSTHead.value;
	}
	
	public static info process(Node x) {
		if(x==null) {
			return null;
		}
		info leftInfo=process(x.left);
		info rightInfo=process(x.right);
		int maxSubBSTsize=0;
		Node maxSubBSTHead=null;
		int min=x.value;
		int max=x.value;
		//maxSubBSTsize=Math.max(leftInfo.maxSubBSTSize, rightInfo.maxSubBSTSize);
		if(leftInfo!=null) {
			maxSubBSTHead=leftInfo.maxSubBSTHead;
			maxSubBSTsize=leftInfo.maxSubBSTSize;
			min=Math.min(min, leftInfo.min);
			max=Math.max(max, leftInfo.max);
		}
		if(rightInfo!=null) {
			if(rightInfo.maxSubBSTSize>maxSubBSTsize) {
				maxSubBSTHead=rightInfo.maxSubBSTHead;
				maxSubBSTsize=rightInfo.maxSubBSTSize;
			}
			min=Math.min(min, rightInfo.min);
			max=Math.max(max, rightInfo.max);
		}
		if(
				(leftInfo==null?true:(leftInfo.maxSubBSTHead==x.left))&&
				(leftInfo==null?true:leftInfo.max<x.value)&&
				(rightInfo==null?true:(rightInfo.maxSubBSTHead==x.right))&&
				(rightInfo==null?true:rightInfo.min>x.value)
				) {
			maxSubBSTHead=x;
			maxSubBSTsize=leftInfo==null?0:(leftInfo.maxSubBSTSize)+(rightInfo==null?0:rightInfo.maxSubBSTSize)+1;
		}
		return new info(maxSubBSTHead, maxSubBSTsize, min, max);
	}

}
