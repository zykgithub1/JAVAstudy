package demo_2021_8_6;

import demo_2021_8_6.isBinarySearchTree.Node;

public class isBlancedTree {
	public static class Node {
		public Node left;
		public Node right;
		public int value;

		public Node(int value) {
			super();
			this.value = value;
		}
	}

	public static class Info {
		public boolean isBlanced;
		public int height;

		public Info(boolean isBlanced, int height) {
			this.isBlanced = isBlanced;
			this.height = height;
		}
	}

	public static Info process(Node head) {
		if (head == null) {
			return new Info(true, 0);
		}
		Info leftInfo = process(head.left);
		Info rightInfo = process(head.right);
		
		int height=Math.max(leftInfo.height, rightInfo.height)+1;
		boolean isBST = leftInfo.isBlanced&&rightInfo.isBlanced&&(Math.abs(leftInfo.height-rightInfo.height)<2);
		return new Info(isBST, height);
		
	}

}
