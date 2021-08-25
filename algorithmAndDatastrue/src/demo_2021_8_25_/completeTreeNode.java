package demo_2021_8_25_;

public class completeTreeNode {
	public static class Node {
		public int val;
		public Node left;
		public Node right;

		public Node(int val) {
			super();
			this.val = val;
		}
	}
	
	public static int nodeNum(Node head) {
		if(head==null) {
			return 0;
		}
		return bs(head,1,mostLeftLevel(head,1));
	}
	
	/*
	 * node在level层，totalHeight是总深度，
	 * 以node为头的完全二叉树，节点个数
	 */
	private static int bs(Node head, int curLevel, int totalHeight) {
		if(curLevel==totalHeight) {
			return 1;
		}
		if(mostLeftLevel(head.right, curLevel+1)==totalHeight) {
			return 1<<(totalHeight-curLevel)+bs(head.right, curLevel+1, totalHeight);
		}else {
			return 1<<(totalHeight-curLevel-1)+bs(head.left,curLevel+1,totalHeight);
		}
		
	}
	
	private static int mostLeftLevel(Node head, int i) {
		while(head!=null) {
			i++;
			head=head.left;
		}
		return i-1;
	}

	

}
