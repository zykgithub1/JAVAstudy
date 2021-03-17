package class1;

public class josephCircle {
	public static void main(String[] args) {
		JosepyCir jc=new JosepyCir();
		jc.addBoys(125);
		//jc.traversal();
		jc.countBoy(10, 20, 50);
	}

}


class JCNode{
	public int data;
	public JCNode next;
	public JCNode(int data) {
		super();
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public JCNode getNext() {
		return next;
	}
	public void setNext(JCNode next) {
		this.next = next;
	}
	
}

class JosepyCir{
	public JCNode first=null;
	
	public void addBoys(int nums) {
		if(nums<2) {
			return;
		}
		JCNode cur=null;
		for(int i=1;i<=nums;i++) {
			JCNode node=new JCNode(i);
			if(i==1) {
				first=node;
				first.setNext(first);
				cur=first;
			}else {
				cur.setNext(node);
				node.setNext(first);
				cur=node;;
			}
		}
	}
	
	public void traversal() {
		if(first==null) {
			System.out.println("环为空");
			return;
		}
		JCNode cur=first;
		while(true) {
			System.out.printf("小孩的编号为：%d\n",cur.data);
			if(cur.next==first) {
				break;
			}
			cur=cur.next;
		}
	}
	/**
	 * 
	 * @param startNo   第几个小孩开始数数
	 * @param countNums 数几下
	 * @param nums      最初多少个小孩在圈中
	 */
	public void countBoy(int startNo,int countNums,int nums) {
		if(first==null||startNo<1||startNo>nums) {
			System.out.println("参数输入有误");
			return;
		}
		JCNode helper=first;
		while(true) {
			if(helper.next==first) {
				break;
			}
			helper=helper.next;
		}
		for(int i=0;i<startNo-1;i++) {
			helper=helper.next;
			first=first.next;
		}
		while(first!=helper) {
			for(int i=0;i<countNums-1;i++) {
				helper=helper.next;
				first=first.next;
			}
			System.out.printf("%d号小孩出圈\n",first.data);
			first=first.next;
			helper.next=first;
		}
		System.out.printf("剩下的小孩是%d",helper.getData());
		
		
		
	}
	
	
	
	
}