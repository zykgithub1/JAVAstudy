package algorithm;

public class nQueens {
	public static void main(String[] args) {
		System.out.println(num2(14));
		//System.out.println(num1(14));
		
	}
	
	public static int num1(int n) {
		if(n==1||n==2) {
			return 0;
		}
		int[] record=new int[n];
		int a=process1(0, record, n);
		return a;
	}
	
	public static int num2(int n) {
		if(n<1||n>32) {
			return 0;
		}
		int limit=n==32?-1:(1<<n)-1;
		return process2(limit,0,0,0);
	}
	
	
	private static int process2(int limit, int colLim, int leftLim, int rightLim) {
		if(colLim==limit) {
			return 1;
		}
		int pos=limit&(~(colLim|leftLim|rightLim));
		int mostRightOne=0;
		int res=0;
		while(pos!=0) {
			mostRightOne=pos&(~pos+1);
			pos=pos-mostRightOne;
			res+=process2(limit, colLim|mostRightOne, (leftLim|mostRightOne)<<1, (rightLim|mostRightOne)>>1);
			
		}
		return res;
	}

	public static int process1(int i,int[] record,int n) {
		if(i==n) {
			return 1;
		}
		int res=0;
		for(int j=0;j<n;j++) {
			if(isValid(record,i,j)) {
				record[i]=j;
				res+=process1(i+1, record, n);
			}
		}
		return res;
	}

	public static boolean isValid(int[] record, int i, int j) {
		for(int k=0;k<i;k++) {
			if(record[k]==j||Math.abs(k-i)==Math.abs(record[k]-j)) {
				return false;
			}
		}
		return true;
	}
}
