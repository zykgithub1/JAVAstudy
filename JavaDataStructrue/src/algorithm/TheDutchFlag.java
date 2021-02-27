package algorithm;

import Sort.Sort;

public class TheDutchFlag {
	public static void main(String[] args) {
		int arr[]= {5,7,3,2,2,8,1};
		int result[]=dutch(arr,0,arr.length-1,2);
		Sort.disPlay(result);
		Sort.disPlay(arr);
	}
	
	public static int[] dutch(int arr[],int left,int right,int p) {
		int less=left-1;
		int more=right+1;
		int cur=0;
		while(cur<more) {
			if(arr[cur]<p) {
				Sort.swap(arr, ++less, cur++);
			}
			else if(arr[cur]>p) {
				Sort.swap(arr, --more, cur);
			}
			else {
				cur++;
			}
		}
		return new int[] {less+1,more-1};
	}
}
