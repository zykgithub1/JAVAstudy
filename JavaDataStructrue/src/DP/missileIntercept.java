package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class missileIntercept {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int d=sc.nextInt();
		
		while(d!=0) {
			int arr[]=new int[d];
			for(int i=0;i<d;i++) {
				arr[i]=sc.nextInt();
			}
			System.out.println(dp(arr));
		}
	}

	private static int dp(int[] arr) {
		int n=arr.length;
		int res=1;
		ArrayList<Integer>list=new ArrayList();
		for(int i=0;i<n-1;i++) {
			if(arr[i+1]>arr[i]&&!judge(list, arr[i+1])) {
				res++;
				list.add(arr[i+1]);
			}
		}
		return res;
	}
	public static boolean judge(ArrayList<Integer>list,int num) {
		for(int cur:list) {
			if(cur>num) {
				cur--;
				return true;
			}
		}
		return false;
	}
}
