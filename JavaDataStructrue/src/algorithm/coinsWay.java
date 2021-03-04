package algorithm;
//’“¡„«Æ
public class coinsWay {
	public static void main(String[] args) {
		int arr[]= {5,10,50,100};
		int sum=1000;
		System.out.println(recursionProcess(arr, 0, sum)+"   "+dpCoins(arr, sum)+"   "+ways3(arr, sum));
	}
	
	public static int recursionWay(int arr[],int index,int rest) {
		if(arr==null||arr.length==0||rest<0) {
			return 0;
		}
		return recursionProcess(arr,index,rest);
	}

	private static int recursionProcess(int[] arr, int index, int rest) {
		if(index==arr.length) {
			return rest==0?1:0;
		}
		int ways=0;
		for(int zhang=0;zhang*arr[index]<=rest;zhang++) {
			ways+=recursionProcess(arr, index+1, rest-zhang*arr[index]);
		}
		return ways;
	}

	public static int dpCoins(int arr[],int rest) {
		if(arr==null||arr.length==0||rest<0) {
			return 0;
		}
		int[][] dp=new int[arr.length+1][rest+1];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j]=-1;
			}
		}
		return processDp(arr,0,rest,dp);
	}

	private static int processDp(int[] arr, int index, int rest, int[][] dp) {
		if(dp[index][rest]!=-1) {
			return dp[index][rest];
		}
		if(index==arr.length) {
			dp[index][rest]=rest==0?1:0;
			return dp[index][rest];
		}
		int ways=0;
		for(int zhang=0;zhang*arr[index]<=rest;zhang++) {
			ways+=processDp(arr, index+1, rest-zhang*arr[index],dp);
		}
		dp[index][rest]=ways;
		return ways;
	}

	public static int ways3(int arr[],int aim) {
		if(arr==null||arr.length==0||aim<0) {
			return 0;
		}
		int N=arr.length;
		int[][] dp=new int [N+1][aim+1];
		dp[N][0]=1;
		for(int index=N-1;index>=0;index--) {
			for(int rest=0;rest<=aim;rest++) {
				int ways=0;
				for(int zhang=0;zhang*arr[index]<=rest;zhang++) {
					ways+=dp[index+1][rest-(zhang*arr[index])];
				}
				dp[index][rest]=ways;
			}
		}
		return dp[0][aim];
	}

}
