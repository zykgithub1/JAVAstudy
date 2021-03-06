package Tree;

public class findMaxBSTHead {
	
	
	public static class Info{
		private boolean isAllBST;
		private int maxSubBSTSize;
		private int min;
		private int max;
		public Info(boolean isAllBST, int maxSubBSTSize, int min, int max) {
			this.isAllBST = isAllBST;
			this.maxSubBSTSize = maxSubBSTSize;
			this.min = min;
			this.max = max;
		}
	}
	
	public static int getBSTHead(isBlanceTree.Node node) {
		return process(node).maxSubBSTSize;
	}
	
	public static Info process(isBlanceTree.Node x) {
		if(x==null) {
			return null;
		}
		Info leftInfo=process(x.left);
		Info rightInfo=process(x.right);
		boolean isAllBST=false;
		int maxSubBSTSize=0;
		if(leftInfo!=null) {
			maxSubBSTSize=leftInfo.maxSubBSTSize;
		}
		if(rightInfo!=null) {
			maxSubBSTSize=Math.max(rightInfo.maxSubBSTSize, maxSubBSTSize);
		}
		int min=x.value;
		int max=x.getValue();
		if(leftInfo!=null) {
			max=Math.max(leftInfo.max, max);
			min=Math.min(leftInfo.min, min);
		}
		if(rightInfo!=null) {
			max=Math.max(max, rightInfo.max);
			min=Math.min(min, rightInfo.min);
		}
		if(     (leftInfo==null?true:leftInfo.isAllBST)&&
				(rightInfo==null?true:rightInfo.isAllBST)&&
				(leftInfo==null?true:x.value>leftInfo.max)&&
				(rightInfo==null?true:x.value<rightInfo.min)) {
			isAllBST=true;
			maxSubBSTSize=(leftInfo==null?0:leftInfo.maxSubBSTSize)+(rightInfo==null?0:rightInfo.maxSubBSTSize)+1;
		}
		
		
		return new Info(isAllBST,maxSubBSTSize,min,max);
	}
}
