package demo01;

import java.util.Scanner;

public class BiggestSub {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();int i=0;
		int[] arr=new int[n];
		for(i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(process(arr, 0, n-1));	
	}
	
	public static int process(int arr[],int left,int right) {
		if(left==right) {
			return arr[left]>0?arr[left]:0;
		}
		int mid=left+(right-left)/2;
		int leftSum=process(arr, left, mid);
		int rightSum=process(arr, mid+1, right);
		
		int leftBoradSum=0;
		int leftMaxSum=0;
		for(int i=mid;i>=left;i--) {
			leftBoradSum+=arr[i];
			if(leftBoradSum>leftMaxSum) {
				leftMaxSum=leftBoradSum;
			}
		}
		int rightBoradSum=0;
		int rightMaxSum=0;
		for(int i=mid+1;i<=right;i++) {
			rightBoradSum+=arr[i];
			if(rightBoradSum>rightMaxSum) {
				rightMaxSum=rightBoradSum;
			}
		}
		return Math.max(Math.max(leftSum, rightSum), leftMaxSum+rightMaxSum);
	}
//	private static int MaxSubseqSum2(int[] a, int k) {
//		int cout ,Max = 0;
//		for (int i = 0; i < k; i++) {		
//			cout = 0;							
//			for (int j = i; j < k; j++) {	
//				cout += a[j];
//				if (cout > Max ) {
//					Max = cout;				
//				}
//			}
//		}
//		return Max;
//	}
}
