package KMP;

import java.util.Arrays;

public class findKthNum {
	public static void main(String[] args) {
		int[] arr= {1,7,9,5,4,7,4,3,2,9,10,11};
		Arrays.sort(arr);
		for(int c:arr) {
			System.out.print(c+" ");
		}
		System.out.println();
		System.out.println(process2(arr, 0, arr.length-1, 4));
	}
	
	public static int process2(int[] arr,int L,int R,int index) {
		if(L==R) {
			return arr[L];
		}
		int pivol=arr[L+(int)(Math.random()*(R-L+1))];
		int[] range=partition(arr,L,R,pivol);         //ºÉÀ¼¹úÆìÎÊÌâ
		if(index>=range[0]&&index<=range[1]) {
			return arr[index];
		}else if(index<range[0]) {
			return process2(arr,L,range[0]-1, index);
		}
		else {
			return process2(arr, range[0]+1, R, index);
		}
	}

	private static int[] partition(int[] arr, int l, int r, int pivol) {
		int less=l-1;
		int more=r+1;
		int cur=l;
		while(cur<more) {
			if(arr[cur]<pivol) {
				swap(arr,++less,cur++);
			}else if(arr[cur]>pivol) {
				swap(arr,--more,cur);
			}
			else {
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
