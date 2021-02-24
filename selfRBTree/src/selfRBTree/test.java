package selfRBTree;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		insertOpt();
	}
	public static void insertOpt() {
		Scanner scanner=new Scanner(System.in);
		RBTree rbt=new RBTree();
		int arr[]= {1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<arr.length;i++) {
			rbt.put(arr[i],null);
		}
		show(rbt.getRoot());
		
	}
	public static void show(RBTree.RBNode node) {
		if(node==null) {
			return;
		}
		show(node.left);
		System.out.print("("+node.key+node.color+")"+"   ");
		show(node.right);
	}

}
