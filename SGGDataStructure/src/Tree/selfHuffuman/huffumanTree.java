package Tree.selfHuffuman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * decode �Ȱ�zipedbytes convert to binaryString
 * 1001010101011111110101010101010101001010101010
 * 
 * @author admin11
 *
 */
public class huffumanTree {
	static StringBuilder sb = new StringBuilder();
	static Map<Byte, String> huffman = new HashMap();

	public static void main(String[] args) {
		//!!!!ѹ���ļ�
//		String srcFile="e://src.bmp";
//		String destFile="e://dis.zip";
//		zipFile(srcFile, destFile);
//		System.out.println("ѹ���ɹ�");
		//��ѹ�ļ�
		String zipFile="e://dis.zip";
		String destFile="e://src2.bmp";
		unZipFile(zipFile, destFile);
		System.out.println("ok");
		
		
//		String str = "i like like like java do you like a java";
//		byte[] strBytes = str.getBytes();
//		List<Node> nodes = getNodes(strBytes);
//		//System.out.println(nodes);
//		Node huffmanRoot = creatHuffmanTree(nodes);
//		// �õ���huffuman codes
//		Map<Byte, String> huffmanCodes = getCodes(huffmanRoot);
//		// ��ԭstr conver to binaryCodes like0110101010101010101010(it is ezsy)
//		// than: split binaryCodes each 8 to 1 byte like 100000000=256
//		// store it in byte[]zipedBytes
//		byte[] zipedBytes = zip(strBytes, huffmanCodes);
//		// then decode
//		// need huffmanCodes and zipedBytes
//		byte[] decodedStr = decode(huffmanCodes, zipedBytes);
//		//System.out.println(new String(decodedStr));
	}
	
	/**
	 * 
	 * @param zipFile   ׼����ѹ���ļ�
	 * @param destFile  ���ļ���ѹ���ĸ�·��
	 */
	
	public static void unZipFile(String zipFile,String destFile) {
		//�����ļ�������
		InputStream is=null;
		//�������������
		ObjectInputStream ois=null;
		//�ļ������
		OutputStream os=null;
		try {
			//�����ļ�������
			is=new FileInputStream(zipFile);
			//����һ����is�����Ķ���������
			ois=new ObjectInputStream(is);
			//��ȡbyte����
			byte[]huffumanBytes=(byte[]) ois.readObject();
			Map<Byte,String>huffumanCodes=(Map<Byte, String>) ois.readObject();
			//����
			byte[]bytes=decode(huffumanCodes, huffumanBytes);
			//��bytesд���ļ�
			os=new FileOutputStream(destFile);
			os.write(bytes);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				os.close();
				ois.close();
				is.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
	}
	

	public static byte[] huffmanZip(byte[]strBytes) {
		List<Node> nodes = getNodes(strBytes);
		Node huffmanRoot = creatHuffmanTree(nodes);
		Map<Byte, String> huffmanCodes = getCodes(huffmanRoot);
		byte[] zipedBytes = zip(strBytes, huffmanCodes);
		return zipedBytes;
	}

	public static void zipFile(String srcFile, String destFile) {
		
		//����������
		//�����ļ������
		FileInputStream is = null;
		FileOutputStream os = null;
		ObjectOutputStream oos=null;
		
		try {
			is = new FileInputStream(srcFile);
			//����һ����Դ�ļ�һ����С��byte[]����
			byte[] b = new byte[is.available()];
			is.read(b);
			//ֱ�ӽ�b�ļ�ѹ��
			byte[]huffmanBytes=huffmanZip(b);
			//�����ļ�����������ѹ���ļ�
			os=new FileOutputStream(destFile);
			//�������ļ������������ObjectOutputStream
			oos=new ObjectOutputStream(os);
			//�Զ������ķ�ʽд��huffman������byte����
			oos.writeObject(huffmanBytes);
			//�Զ������ķ�ʽд��huffman���룬Ϊ�˻ָ��ļ�ʱʹ��(���룩
			oos.writeObject(huffman);
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				oos.close();
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] zipedBytes) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < zipedBytes.length; i++) {
			boolean flag = i == zipedBytes.length - 1;
			sb.append(byteToByteStr(!flag, zipedBytes[i]));
		}
		// System.out.println(sb.toString());
		Map<String, Byte> map = new HashMap();
		for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		List<Byte> list = new ArrayList();
		for (int i = 0; i < sb.length();) {
			int count = 1;
			boolean flag = true;
			Byte b = null;
			while (flag) {
				String key = sb.substring(i, i + count);
				b = map.get(key);
				if (b == null) {
					count++;
				} else {
					// System.out.print(b+" "+(char)b.intValue()+"\n");
					i += count;
					list.add(b);
					flag = false;
				}
			}
		}
		byte[] ans = new byte[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		return ans;
	}

	// byte conver binanry String
	public static String byteToByteStr(boolean flag, byte b) {
		int temp = b;
		if (flag) {
			temp |= 256;
		}
		String str = Integer.toBinaryString(temp);
		if (flag) {
			return str.substring(str.length() - 8);
		} else {
			return str;
		}
	}

//	private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] zipedBytes) {
//		
//	}
	private static byte[] zip(byte[] strBytes, Map<Byte, String> huffmanCodes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : strBytes) {
			sb.append(huffmanCodes.get(b));
		}
		//System.out.println(sb.toString());
		int len = (sb.length() + 7) / 8;
		byte[] ans = new byte[len];
		int index = 0;
		for (int i = 0; i < sb.length(); i += 8) {
			String strByte = "";
			if (i + 8 <= sb.length()) {
				strByte = sb.substring(i, i + 8);
			} else {
				strByte = sb.substring(i);
			}
			ans[index++] = (byte) Integer.parseInt(strByte, 2);
		}
		return ans;
	}

	public static Map<Byte, String> getCodes(Node head) {
		if (head == null) {
			return null;
		} else {
			getCodes(head.left, "0", sb);
			getCodes(head.right, "1", sb);
		}
		return huffman;
	}

	public static void getCodes(Node head, String code, StringBuilder sb) {
		StringBuilder sb2 = new StringBuilder(sb);
		sb2.append(code);
		if (head == null) {
			return;
		} else {
			if (head.data == null) {
				getCodes(head.left, "0", sb2);
				getCodes(head.right, "1", sb2);
			} else {
				huffman.put(head.data, sb2.toString());
			}
		}
	}

	private static Node creatHuffmanTree(List<Node> nodes) {
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			Node left = nodes.get(0);
			Node right = nodes.get(1);
			Node parent = new Node(null, left.weight + right.weight);
			parent.left = left;
			parent.right = right;
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}

	private static List<Node> getNodes(byte[] strBytes) {
		List<Node> ans = new ArrayList();
		Map<Byte, Integer> map = new HashMap<>();
		for (byte b : strBytes) {
			if (map.containsKey(b)) {
				map.put(b, map.get(b) + 1);
			} else {
				map.put(b, 1);
			}
		}
		for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
			ans.add(new Node(entry.getKey(), entry.getValue()));
		}
		return ans;
	}

}

class Node implements Comparable<Node> {
	public Byte data;
	public int weight;
	public Node left;
	public Node right;

	public Node(Byte data, int weight) {
		super();
		this.data = data;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}

}
