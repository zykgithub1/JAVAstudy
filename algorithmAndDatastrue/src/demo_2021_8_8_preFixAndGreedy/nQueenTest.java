package demo_2021_8_8_preFixAndGreedy;

public class nQueenTest {
	public static void main(String[] args) {
		System.out.println(num1(8));
	}
	
	public static int num1(int n) {
		if(n==1||n==2) {
			return 0;
		}
		int[] record=new int[n];
		int a=process1(0, record, n);
		return a;
	}
	public static int process1(int i,int[] record,int n) {
		if(i==n) {
			return 1;
		}
		int res=0;
		for(int j=0;j<n;j++) {
			if(isValid(record,i,j)) {//当前在i行，尝试i行所有的列的位置，->j
				record[i]=j;
				res+=process1(i+1, record, n);
			}
		}
		return res;
	}

	//(i,j)  和（k,record[k]） 斜率 
	public static boolean isValid(int[] record, int i, int j) {
		for(int k=0;k<i;k++) {
			if(record[k]==j||Math.abs(k-i)==Math.abs(record[k]-j)) {
				return false;
			}
		}
		return true;
	}

}
