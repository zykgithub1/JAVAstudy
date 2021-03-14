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
		}//hashMap����Node���ң��ߵ�һ���������ֵ
		HashMap<Node,Node>lbigMap=new HashMap();
		HashMap<Node,Node>rbigMap=new HashMap();
		Stack<Node>stack=new Stack();
		for(i=0;i<arr.length;i++) {
			Node cur=nArr[i];
			//��3��1��2��:������ѭ��  ѹ������1ֱ��ѹ�룬2�ٽ�ջ ����ѭ��
			//��1����������ջ��ͬʱ��1��3ѹ��HashMap ��ӦMap.put(pop,stack.peek);
			while(!stack.isEmpty()&&stack.peek().value<cur.value) {
				stackPopHashMap(stack,lbigMap);
			}
			stack.push(cur);
		}
		//��3��1��2��1�ѵ�����ĿǰջΪ 2^3��  ����2��Mapѹ��2��3
		//ѹ��3��null
		while(!stack.isEmpty()) {
			stackPopHashMap(stack, lbigMap);
		}
		for(i=arr.length-1;i!=-1;i--) {
			Node cur=nArr[i];
			//[5,1,2]ѹ��2��1��5 ��ջ
			//   ����5   ����1��Map��ѹ��1��2
			//| |      ����2��map��ѹ��2��null
			//|1|      ջ��ֻ����
			//|2|      Ȼ��ѹ��5��null
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
