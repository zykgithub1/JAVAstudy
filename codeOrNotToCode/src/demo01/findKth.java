package demo01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class findKth {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt();
		int[] arr=new int[n];
		int i=0;
		while(i<n) {
			arr[i++]=sc.nextInt();
		}
//		Arrays.sort(arr);
////		System.out.println(arr[arr.length-k]);
//		System.out.println(ans(arr,5));
	}
	
	public static int ans(int arr[],int k) {
		return bfptr(arr, 0, arr.length-1, k-1);
	}
	
	public static int bfptr(int arr[],int L,int R,int index) {
		if(arr.length==0||arr==null) {
			return 0;
		}
		int pivol=arr[L+(int)(Math.random()*(R-L+1))];
		int[] range=position(arr,L,R,arr[1]);
		if(arr[index]>=range[0]&&arr[index]<=range[1]) {
			return arr[index];
		}else if(arr[index]<range[0]) {
			return bfptr(arr, L, range[0]-1, index);
		}else {
			return bfptr(arr, range[1]+1, R, index);
		}
	}

	private static int[] position(int[] arr, int l, int r, int pivol) {
		int less=l-1;
		int more=r+1;
		int cur=l;
		while(cur<more) {
			if(arr[cur]<pivol) {
				swap(arr,++less,cur++);
			}else if(arr[cur]>pivol) {
				swap(arr,--more,cur);
			}{
				cur++;
			}
		}
		return new int[] {less+1,more-1};
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}

	

}
