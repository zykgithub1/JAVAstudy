package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
	public static void main(String[] args) {
		int arr[]= {1,8,10,89,89,89,89,1000,1000,1000,1234};
		int res=binarysearch(arr,0,arr.length-1,89);
		ArrayList<Integer>res2=binarysearch1(arr, 0, arr.length-1,0);
		//System.out.println(res);
		System.out.println(res2);
		System.out.println();
		int[] que=ditchFlag(arr, 0, arr.length-1, 0);
		for(int j:que) {
			System.out.print(j+" ");
		}
	}
	
	public static int[] ditchFlag(int[]arr,int left,int right,int pivol) {
		int less=left-1;
		int more=right+1;
		int cur=left;
		while(cur<more) {
			if(arr[cur]<pivol) {
				swap(arr,++less,cur++);
			}else if(arr[cur]>pivol) {
				swap(arr,--more,cur);
			}else {
				cur++;
			}
		}
		int i=less+1;int j=more-1;
		int size=j-i+1;int t=0;
		int[]res=new int[size];
		for(int h=i;h<=j;h++) {
			res[t++]=h;
		}
		return res;
		
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp=0;
		tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
		
	}

	private static int binarysearch(int[] arr, int i, int j, int k) {
		int left=i;int right=j;
		int mid=i+(j-i)/2;
		while(left<=right) {
			mid=i+(j-i)/2;
			if(arr[mid]==k) {
				return mid;
			}else if(arr[mid]>k) {
				return binarysearch(arr, i, mid-1, k);
			}else {
				return binarysearch(arr, mid+1, j, k);
			}
		}
		return -1;
	}
	private static ArrayList<Integer> binarysearch1(int[] arr, int i, int j, int k) {
		
		if(i>j) {
			return new ArrayList<Integer>();
		}
		int mid=i+(j-i)/2;
		int ans=arr[mid];
		if(ans>k) {
			return binarysearch1(arr, i, mid-1, k);
		}else if(ans<k) {
			return binarysearch1(arr, mid+1, j, k);
		}else{
			ArrayList<Integer>list=new ArrayList();
			int tmp=mid-1;
			while(tmp>0&&arr[tmp]==k) {
				list.add(tmp);
				tmp=tmp-1;
			}
			list.add(mid);
			tmp=mid+1;
			while(tmp<arr.length-1&&arr[tmp]==k) {
				list.add(tmp);
				tmp++;
			}
			return list;
		}
	}
}
