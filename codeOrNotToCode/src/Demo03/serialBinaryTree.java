package Demo03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class serialBinaryTree {
	public static void main(String[] args) {
		Node root=printBTreeDirectly.creatTree();
		String str="1!2!4!#!#!#!3!#!5!#!#!";
		Node root3=reconByPreString(str);
		System.out.println("root3:");
		traversalAllApproaches.preOrderRecur(root3);
		Node root2=reconByPreString(str);
		traversalAllApproaches.preOrderRecur(root2);
		String levelStr=serialBTByLevel(root2);
		System.out.println(levelStr+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~```");
		Node head=reconByLevelStr(levelStr);
		traversalAllApproaches.preOrderRecur(head);
		
	}

	private static Node reconByLevelStr(String levelStr) {
		int index=0;
		String[]str=levelStr.split("!");
		Node head=getNodeByString(str[index++]);
		Queue<Node>que=new LinkedList();
		if(head!=null) {
			que.add(head);
		}
		Node node=null;
		while(!que.isEmpty()) {
			node=que.poll();
			node.left=getNodeByString(str[index++]);
			node.right=getNodeByString(str[index++]);
			if(node.left!=null) {
				que.add(node.left);
			}
			if(node.right!=null) {
				que.add(node.right);
			}
		}
		return head;
	}

	private static Node getNodeByString(String string) {
		if(string.equals("#")) {
			return null;
		}
		return new Node(Integer.valueOf(string));
	}

	private static String serialBTByLevel(Node root2) {
		if(root2==null) {
			return "#!";
		}
		String ans="";
		Queue<Node>que=new LinkedList();
		que.add(root2);
		ans=root2.value+"!";
		while(!que.isEmpty()) {
			root2=que.poll();
			if(root2.left!=null) {
				ans+=root2.left.value+"!";
				que.offer(root2.left);
			}else {
				ans+="#!";
			}
			if(root2.right!=null) {
				ans+=root2.right.value+"!";
				que.add(root2.right);
			}else {
				ans+="#!";
			}
		}
		return ans;
	}

	private static Node reconByPreString(String preSerial) {
		String[]nodes=preSerial.split("!");
		Queue<String>que=new LinkedList();
		for(int i=0;i<nodes.length;i++) {
			que.add(nodes[i]);
		}
		return reconPreOrder(que);
	}

	private static Node reconPreOrder(Queue<String> que) {
		String value=que.poll();
		if(value.equals("#")) {
			return null;
		}
		Node root=new Node(Integer.valueOf(value));
		root.left=reconPreOrder(que);
		root.right=reconPreOrder(que);
		return root;
	}

	private static String serialByPre(Node root) {
		String ans="";
		if(root==null) {
			return "#!";
		}
		ans=root.value+"!";
		ans+=serialByPre(root.left);
		ans+=serialByPre(root.right);
		return ans;
	}
}
