package demo08_NumsAndMatrix;

public class unRangArrFindLongestLength {
	public static void main(String[] args) {
		int arr[]= {1,2,2,2,1,1};
		int ans=getMaxLength(arr,3);
		System.out.println(ans);
	}

	public static int getMaxLength(int[] arr, int k) {
		int left=0,right=0,len=0;
		int sum=arr[0];
		while(right<arr.length) {
			if(sum<k) {
				if(right+1<arr.length) {
					right++;
					sum+=arr[right];
				}else {
					break;
				}
			}else if(sum==k){
				len=Math.max(len, right-left+1);
				sum-=arr[left++];
			}else {
				sum-=arr[left];
				left++;
			}
		}
		return len;
	}

}
