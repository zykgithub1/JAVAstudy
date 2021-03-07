package Tree;

import java.util.LinkedList;
import java.util.Queue;

import selfTest.selfTestTree;
import selfTest.selfTestTree.Node;

public class serializeTree {
	public static void main(String[] args) {
		Queue<String> preList=new LinkedList<String>();
		preList.add("4");
		preList.add("2");
		preList.add("1");
		preList.add(null);
		preList.add(null);
		preList.add("3");
		preList.add(null);
		preList.add(null);
		preList.add("7");
		preList.add("6");
		preList.add(null);
		preList.add(null);
		preList.add("8");
		preList.add(null);
		preList.add(null);
		Node tree=buildByPreQueue(preList);
		selfTestTree.show(tree);
		Queue<String> serialization=new LinkedList<String>();
		serialization=proSerial(tree);
		System.out.println();
		for(String c:serialization) {
			System.out.print(c+" ");
		}
		System.out.println();
		serialization=levelSerial(tree);
		for(String c:serialization) {
			System.out.print(c+" ");
		}
	}
	
	public static Queue<String> proSerial(Node x){
		Queue<String> ans=new LinkedList<>();
		if(x==null) {
			ans.add(null);
		}
		preOrder(x,ans);
		return ans;
	}

	private static void preOrder(Node x, Queue<String> ans) {
		if(x==null) {
			ans.add(null);
		}else {
			ans.add(String.valueOf(x.value));
			preOrder(x.left, ans);
			preOrder(x.right, ans);
		}
	}
	public static Node buildByPreQueue(Queue<String> preList) {
		if(preList==null||preList.size()==0) {
			return null;
		}
		return preBuild(preList);
	}

	private static Node preBuild(Queue<String> preList) {
		String value=preList.poll();
		if(value==null) {
			return null;
		}
		Node head=new Node(Integer.valueOf(value));
		head.left=preBuild(preList);
		head.right=preBuild(preList);
		return head;
	}
	
	public static Queue<String> levelSerial(Node head){
		Queue<String> ans=new LinkedList<>();
		if(head==null) {
			ans.add(null);
		}else {
			ans.add(String.valueOf(head.value));
			Queue<Node> queue=new LinkedList<selfTestTree.Node>();
			queue.add(head);
			while(!queue.isEmpty()) {
				head=queue.poll();
				if(head.left!=null) {
					ans.add(String.valueOf(head.left.value));
					queue.add(head.left);
				}
				else {
					ans.add(null);
				}
				if(head.right!=null) {
					ans.add(String.valueOf(head.right.value));
					queue.add(head.right);
				}
				else {
					ans.add(null);
				}
			}
		}
		return ans;
	}
	
	public static Node buildByLevelQueue(Queue<String> levelList) {
		if(levelList==null||levelList.size()==0) {
			return null;
		}
		Node head=generateNode(levelList.poll());
		Queue<Node> queue=new LinkedList<>();
		if(head!=null) {
			queue.add(head);
		}
		Node node=null;
		while(!queue.isEmpty()) {
			node=queue.poll();
			node.left=generateNode(levelList.poll());
			node.right=generateNode(levelList.poll());
			if(node.left!=null) {
				queue.add(node.left);
			}
			if(node.right!=null) {
				queue.add(node.right);
			}
		}
		return head;
	}
	
	public static Node generateNode(String val) {
		if(val==null) {
			return null;
		}
		return new Node(Integer.valueOf(val));
	}
	
}
