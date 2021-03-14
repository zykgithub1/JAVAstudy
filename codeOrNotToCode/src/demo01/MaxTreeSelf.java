package demo01;

import java.util.HashMap;
import java.util.Stack;

import demo01.MaxTree.Node;

public class MaxTreeSelf {
	public static void main(String[] args) {
		int[] arr= {3,4,5,1,2};
		Node tree=generateTree(arr);
		MaxTree.show(tree);
	}

	private static Node generateTree(int[] arr) {
		if(arr.length==0||arr==null) {
			throw new RuntimeException("ERROR");
		}
		int i=0;
		Node[]nArr=new Node[arr.length];
		for(i=0;i<arr.length;i++) {
			nArr[i]=new Node(arr[i]);
		}//hashMap保存Node左（右）边第一个比它大的值
		HashMap<Node,Node>lbigMap=new HashMap();
		HashMap<Node,Node>rbigMap=new HashMap();
		Stack<Node>stack=new Stack();
		for(i=0;i<arr.length;i++) {
			Node cur=nArr[i];
			//【3，1，2】:不进入循环  压入三，1直接压入，2再进栈 进入循环
			//将1弹出，再入栈，同时将1和3压入HashMap 对应Map.put(pop,stack.peek);
			while(!stack.isEmpty()&&stack.peek().value<cur.value) {
				stackPopHashMap(stack,lbigMap);
			}
			stack.push(cur);
		}
		//【3，1，2】1已弹出，目前栈为 2^3下  弹出2，Map压入2，3
		//压入3，null
		while(!stack.isEmpty()) {
			stackPopHashMap(stack, lbigMap);
		}
		for(i=arr.length-1;i!=-1;i--) {
			Node cur=nArr[i];
			//[5,1,2]压入2，1后5 入栈
			//   ←←5   弹出1，Map中压入1，2
			//| |      弹出2，map中压入2，null
			//|1|      栈中只有五
			//|2|      然后压入5，null
			while(!stack.isEmpty()&&stack.peek().value<cur.value) {
				stackPopHashMap(stack, rbigMap);
			}
			stack.push(cur);
		}
		while(!stack.isEmpty()) {
			stackPopHashMap(stack, rbigMap);
		}
		Node head=null;
		for(i=0;i<arr.length;i++) {
			Node cur=nArr[i];
			Node left=lbigMap.get(cur);
			//System.out.print(left==null?0:left.value);
			Node right=rbigMap.get(cur);
			//System.out.print(right==null?0:right.value);
			if(left==null&&right==null) {
				head=cur;
			}else if(left==null) {
				if(right.left==null) {
					right.left=cur;
				}else {
					right.right=cur;
				}
			}else if(right==null) {
				if(left.left==null) {
					left.left=cur;
				}else {
					left.right=cur;
				}
			}else {
				Node parent=left.value<right.value?left:right;
				if(parent.left==null) {
					parent.left=cur;
				}else {
					parent.right=cur;
				}
			}
		}
		return head;
		
	}

	private static void stackPopHashMap(Stack<Node> stack, HashMap<Node, Node> Map) {
		Node stackPop=stack.pop();
		if(stack.isEmpty()) {
			Map.put(stackPop, null);
		}else {
			Map.put(stackPop, stack.peek());
		}
	}

}
