package Tree.huffmanTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HuffmanCode {
    static StringBuilder sb=new StringBuilder();
	static Map<Byte,String>huffumanCodes=new HashMap();
	public static Map<Byte,String> getCodes(CNode head){
		if(head==null) {
			return null;
		}
		getCodes(head.left,"0",sb);
		getCodes(head.right,"1",sb);
		return huffumanCodes;
		
	}
	/**
	 * 
	 * @param bytes   ԭʼ�ַ�����Ӧ��Byte����
	 * @param huffumanCodes  ���ɵ�huffman�����
	 * @return    ���غշ������봦����  bytes[]
	 *   0010101010101011011010   ����
	 *   ��8λ��Ӧһ��byte������
	 */
	private static byte[] zip(byte[]bytes,Map<Byte,String> huffumanCodes) {
		//����huffmanCode ��bytes ת��huffman�����Ӧ���ַ���
		StringBuilder sb=new StringBuilder();
		//����bytes����
		for(byte b:bytes) {
			sb.append(huffumanCodes.get(b));
		}
		//��2���Ʊ���ת��Ϊbyte����
		//1��ͳ�Ʒ��صĳ���
		int len=sb.length()%8==0?sb.length()/8:sb.length()/8+1;
		//�ȼ���len=(sb.length+7)/8
		byte[] ans=new byte[len];
		int index=0;
		for(int i=0;i<sb.length();i+=8) {
			String strByte;
			if(i+8<=sb.length()) {
				strByte=sb.substring(i, i+8);
			}else {
				strByte=sb.substring(i);
			}
			ans[index++]=(byte)Integer.parseInt(strByte,10);
		}
		return ans;
		
		
	}
	
	
	
	/**
	 * �������head������Ҷ�ӽڵ��huffuman����õ������뵽huffumanCodes������
	 * @param head  ͷ�ڵ�
	 * @param code  ·�� ��0����1
	 * @param sb    ����ƴ��·��
	 */
	private static void getCodes(CNode head,String code,StringBuilder sb) {
		StringBuilder sb2=new StringBuilder(sb);
		sb2.append(code);
		if(head!=null) {
			if(head.data==null) {
				getCodes(head.left, "0", sb2);
				getCodes(head.right, "1", sb2);
			}else {
				huffumanCodes.put(head.data, sb2.toString());
			}
		}
	}
//	private static void getCodes(CNode head,String code,StringBuilder sb) {
//		StringBuilder sb2=new StringBuilder(sb);
//		sb2.append(code);
//		if(head!=null) {
//			if(head.data==null) {
//				getCodes(head.left, "0", sb2);
//				getCodes(head.right, "1", sb2);
//			}else {
//				huffumanCodes.put(head.data, sb2.toString());
//			}
//		}
//	}
	
	
	public static void main(String[] args) {
		String str = "i like like like java do you like a java";
		byte[] strBytes = str.getBytes();
		List<CNode> nodes = getNodes(strBytes);
		System.out.println(nodes);
		CNode node=creatHuffumanTree(nodes);
		node.preOrder();
		Map<Byte,String> huffmanCodes1=getCodes(node);
		System.out.println(huffmanCodes1);
		byte[] ans= zip(strBytes, huffmanCodes1);
		System.out.println("ѹ�����byte����λ"+Arrays.toString(ans));
		System.out.println("ѹ����Ϊ"+(double)(strBytes.length-ans.length)/strBytes.length*100+"%");
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
			CNode parent=new CNode(null, left.weight+right.weight);
			parent.left=left;
			parent.right=right;
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}

//	public static List<CNode> getNodes(byte[] bytes) {
//		ArrayList<CNode> nodes = new ArrayList<CNode>();
//		Map<Byte, Integer> counts = new HashMap();
//		for (byte b : bytes) {
//			Integer count = counts.get(b);
//			if (count == null) {
//				counts.put(b, 1);
//			} else {
//				counts.put(b, count + 1);
//			}
//		}
//		for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
//			nodes.add(new CNode(entry.getKey(), entry.getValue()));
//		}
//		return nodes;
//	}
	public static List<CNode> getNodes(byte[] bytes) {
		ArrayList<CNode> nodes = new ArrayList<CNode>();
		Map<Byte,Integer>map=new HashMap();
		for(Byte b:bytes) {
			Integer count=map.get(b);
			if(count==null) {
				map.put(b, 1);
			}else {
				map.put(b, count+1);
			}
//			if(map.containsKey(b)) {
//				map.put(b, map.get(b)+1);
//			}else {
//				map.put(b, 1);
//			}
		}
		for(Map.Entry<Byte,Integer> set:map.entrySet()) {
			nodes.add(new CNode(set.getKey(),set.getValue()));
		}
		return nodes;
	}

}

class CNode implements Comparable<CNode> {
	Byte data;// asc��ֵ
	int weight;// Ȩֵ
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
