package Tree;

import java.util.ArrayList;
import java.util.List;

import selfTest.selfTestTree;
import selfTest.selfTestTree.Node;

public class BSTToGst {
	public static void main(String[] args) {
		Node tree=selfTestTree.creatTree();
		selfTestTree.show(tree);
		List<Integer> list=new ArrayList<>();
		System.out.println();
	}
	public static void dfs(Node x,List<Integer> list) {
		if(x==null) {
			return;
		}
		list.add(x.value);
		dfs(x.left,list);
		dfs(x.right,list);
	}
	public static int countRightNum(Node x,List<Integer> list) {
		if(x==null) {
			return 0;
		}
		int count=0;
		for(int num:list) {
			if(num>=x.value) {
				count+=num;
			}
		}
		return count;
	}
	
	
	public static class Info{
		public int bigThanNum;
		public int smallThanNum;
		public Info(int bigThanNum, int smallThanNum) {
			super();
			this.bigThanNum = bigThanNum;
			this.smallThanNum = smallThanNum;
		}
	}
	
	public static Info process(Node x) {
		if(x==null) {
			return new Info(0,0);
		}
		Info leftInfo=process(x.left);
		Info rightInfo=process(x.right);
		int bigThan=0;
		int smallThan=0;
		
		return new Info(bigThan, smallThan);
		
	}


}
