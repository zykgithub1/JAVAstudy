package recursion;

public class TestNqueen {
	public static void main(String[] args) {
		System.out.println(nums(8));
		System.out.println(nums2(8));
	}

	private static int nums2(int n) {
		if(n<1||n>32) {
			return 0;
		}
		int limit=n==32?-1:(1<<n)-1;
		return process2(limit,0,0,0);
	}

	private static int process2(int limit, int colLim, int leftLim, int rightLim) {
		if(colLim==limit) {//递归结束条件就是全盘填满
			return 1;
		}//列限制就是|mostRightOne
		int res=0;
		//                 总限制
		int pos=limit&(~(colLim|leftLim|rightLim));
		int mostRightOne=0;
		while(pos!=0) {
			mostRightOne=pos&(~pos+1);
			pos=pos-mostRightOne;
			res+=process2(limit, colLim|mostRightOne, (leftLim|mostRightOne)<<1, (rightLim|mostRightOne)>>1);
		}
		return res;
	}

	private static int nums(int n) {
		if(n<1||n>32) {
			return 0;
		}
		int[] record=new int[n];
		return process(0,record,n);
	}

	private static int process(int i, int[] record, int n) {
		if(i==n) {
			return 1;
		}
		//i是行  j是列  record[i]=j  就是第i行的皇后放在j位置
		int res=0;
		for(int j=0;j<n;j++) {
			if(isValid(record,i,j)) {
				record[i]=j;
				res+=process(i+1, record, n);
			}
		}
		return res;
	}

	private static boolean isValid(int[] record, int i, int j) {
		for(int k=0;k<i;k++) {
			if(record[k]==j||Math.abs(k-i)==Math.abs(record[k]-j)) {
				return false;
			}
		}
		return true;
	}

}
