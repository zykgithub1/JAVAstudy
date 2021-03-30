package Tree.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HuffmanCode {
	public static void main(String[] args) {
		String str = "i like like like java do you like a java";
		byte[] strBytes = str.getBytes();
		System.out.println(strBytes.length);
		List<CNode> nodes = getNodes(strBytes);
		CNode node=creatHuffumanTree(nodes);
		node.preOrder();

	}
	
	public static void preOrder(CNode node) {
		if(node==null) {
			System.out.println("empty");
			return;
		}else {
			node.preOrder();
		}
		
	}

	public static CNode creatHuffumanTree(List<CNode> nodes) {
		while(nodes.size()>1) {
			Collections.sort(nodes);
			CNode left=nodes.get(0);
			CNode right=nodes.get(1);
			CNode parent=new CNode(null,left.weight+right.weight);
			parent.left=left;
			parent.right=right;
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}

	public static List<CNode> getNodes(byte[] bytes) {
		ArrayList<CNode> nodes = new ArrayList<CNode>();
		Map<Byte, Integer> counts = new HashMap();
		for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			} else {
				counts.put(b, count + 1);
			}
		}
		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new CNode(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}

}

class CNode implements Comparable<CNode> {
	Byte data;// asc¬Î÷µ
	int weight;// »®÷µ
	CNode left;
	CNode right;

	public void preOrder() {
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	public CNode(Byte data, int weight) {
		super();
		this.data = data;
		this.weight = weight;
	}

	@Override
	public int compareTo(CNode o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}

	@Override
	public String toString() {
		return "CNode [data=" + data + ", weight=" + weight + "]";
	}
}
