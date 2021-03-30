package Tree.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffumanTree {

	public static void main(String[] args) {
		int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
		creatHuffmanTree(arr).preOrder();
	}

	public static Node creatHuffmanTree(int arr[]) {
		List<Node> list = new ArrayList<Node>();
		for (int i = 0; i < arr.length; i++) {
			list.add(new Node(arr[i]));
		}
		while (list.size() > 1) {
			// 排序
			Collections.sort(list);
			// 取出根节点权值最小的两个节点
			Node left = list.get(0);
			Node right = list.get(1);
			Node parent = new Node(left.value + right.value);
			parent.left=left;
			parent.right=right;
			list.remove(right);
			list.remove(left);
			list.add(parent);
		}
		return list.get(0);
	}
}

class Node implements Comparable<Node> {
	public int value;
	public Node left;
	public Node right;

	
	public void preOrder() {
		if(this==null) {
			return;
		}
		System.out.println(this);
		if(this.left!=null) {
			this.left.preOrder();
		}
		if(this.right!=null) {
			this.right.preOrder();
		}
	}
	public Node(int value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}

}
