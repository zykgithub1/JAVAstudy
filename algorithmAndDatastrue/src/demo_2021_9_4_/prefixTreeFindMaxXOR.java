package demo_2021_9_4_;

public class prefixTreeFindMaxXOR {
	public static class Node{
		public Node[]nexts=new Node[2];
	}
	public static class NumTrie{
		public Node head=new Node();
		
		public void add(int num) {
			Node cur=head;
			for(int i=31;i>=0;i--) {
				int path=(num>>i)&1;
				cur.nexts[path]=cur.nexts[path]!=null?cur.nexts[path]:new Node();
				cur=cur.nexts[path];
			}
		}
		
		public int maxXor(int num) {
			Node cur=head;
			int res=0;
			for(int i=31;i>=0;i--) {
				int path=(num>>i)&1;
				int best=i==31?path:path^1;
				best=cur.nexts[best]!=null?best:best^1;
				res=res|((path^best)<<i);
				cur=cur.nexts[best];
			}
			return res;
		}
	}

}
