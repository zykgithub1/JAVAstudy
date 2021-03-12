package Tree;

import selfTest.*;
import selfTest.selfTestTree.Node;

public class isFullBineryTree {
	public static void main(String[] args) {
		Node tree=selfTestTree.creatTree();
		System.out.println(isFull(tree));
	}
	
	public static class info{
		int height;
		int nodes;
		public info(int height, int nodes) {
			super();
			this.height = height;
			this.nodes = nodes;
		}
	}
	
	public static boolean isFull(Node head) {
		if(head==null) {
			return true;
		}
		info all=process(head);
		return (1<<all.height)-1==all.nodes?true:false;
	}
	
	public static info process(Node head) {
		if(head==null) {
			return new info(0,0);
		}
		info leftInfo=process(head.left);
		info rightInfo=process(head.right);
		int height=Math.max(leftInfo.height, rightInfo.height)+1;
		int nodes=leftInfo.nodes+rightInfo.nodes+1;
		return new info(height, nodes);
	}
}
