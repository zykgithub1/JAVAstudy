package demo_2021_8_24_;

import java.util.TreeMap;

public class prefix {
	public static void main(String[] args) {
		String[]folder= {"a\\b\\c","a\\d\\e","b\\g\\f","a\\b\\c\\z\\x"};
		print(folder);

	}

	public static class Node {
		public String name;
		public TreeMap<String, Node> nextMap;

		public Node(String name) {
			this.name = name;
			this.nextMap = new TreeMap<>();
		}
	}

	public static void print(String[] folderPaths) {
		if (folderPaths == null || folderPaths.length == 0) {
			return;
		}
		Node head = generateFolder(folderPaths);
		printProcess(head, 0);
	}

	private static void printProcess(Node head, int level) {
		if(level!=0) {
			System.out.println(generateSpace(level)+head.name);
		}
		for(Node next:head.nextMap.values()) {
			printProcess(next, level+1);
		}
	}

	private static String generateSpace(int level) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<2*(level-1);i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	public static Node generateFolder(String[] test) {
		Node head = new Node("");
		for (String foldPath : test) {
			String[] paths = foldPath.split("\\\\");
			Node cur = head;
			for (int i = 0; i < paths.length; i++) {
				if (!cur.nextMap.containsKey(paths[i])) {
					cur.nextMap.put(paths[i], new Node(paths[i]));
				}
				cur = cur.nextMap.get(paths[i]);
			}
		}
		return head;
	}

}
