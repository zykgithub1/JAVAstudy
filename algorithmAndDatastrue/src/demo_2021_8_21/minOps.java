package demo_2021_8_21;

public class minOps {
	public static void main(String[] args) {
		System.out.println(Math.pow(8, 1.0/2));
		System.out.println(Math.sqrt(8));
		System.out.println(isPrim(8));
	}
	public static int minOp(int n) {
		if(n<2) {
			return 0;
		}
		if(isPrim(n)) {
			return n-1;
		}
		int[]arr=divSumAndCount(n);
		return arr[0]-arr[1];
	}

	private static boolean isPrim(int n) {
		for(int i=2;i<Math.pow(n, 1.0/2);i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}

	private static int[] divSumAndCount(int n) {
		int sum=0;
		int count=0;
		for(int i=2;i<=n;i++) {
			while(n%i==0) {
				count++;
				sum+=i;
				n/=i;
			}
		}
		return new int[] {sum,count};
	}

}
