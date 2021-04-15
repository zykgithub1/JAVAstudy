package DP;

public class robber1 {
	public static void main(String[] args) {
//		int arr[]= {1,2,3,1};
		int arr[]= {2,7,9,3,1};
		int[]arr1= {114,117,207,117,235,82,90,67,143,146,53
		            ,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,
		            199,114,235,197,187,69,129,64,214,228,7,
		            8,188,67,205,94,205,169,241,202,144,240};
		int ans=rober1(arr);
		int ans2=process2(arr1);
		System.out.println(ans+"   "+ans2);
	}

	private static int process2(int[] arr) {
		if(arr==null||arr.length<1) {
			return 0;
		}
		if(arr.length==2) {
			return Math.max(arr[0],arr[1]);
		}
		int dp[]=new int[arr.length+1];
		dp[0]=arr[0];
		dp[1]=Math.max(arr[0],arr[1]);
		for(int i=2;i<arr.length;i++) {
			dp[i]=Math.max(dp[i-1],arr[i]+dp[i-2]);
		}
		return dp[arr.length-1];
	}

	private static int rober1(int[] arr) {
		if(arr==null||arr.length<1) {
			return 0;
		}
		if(arr.length==2) {
			return Math.max(arr[0],arr[1]);
		}
		return process(arr,arr.length-1);
	}

	private static int process(int[] nums, int i) {
		if(i<0) {
			return 0;
		}
		return Math.max(process(nums, i-1), nums[i]+process(nums, i-2));
	}
	
	

	

}
