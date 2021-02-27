package Sort;

import Sort.Sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr= {6,1,8,10,4,2,9,5,7};
		Sort.disPlay(arr);
		quickSort(arr, 0, arr.length-1);
		Sort.disPlay(arr);
		Sort.check();
	}
	
	public static void quickSort(int arr[],int left,int right) {
		if(left<right) {
			int pos=postion(arr,left,right);
			quickSort(arr, left, pos);
			quickSort(arr, pos+1, right);
		}
	}
	public static int postion(int arr[],int first,int last) {
		int i=first;int j=last;
		while(i<j) {
			while(i<j&&arr[i]<=arr[j]) {
				j--;
			}
			if(i<j) {
				Sort.swap(arr, i, j);
				i++;
			}
			while(i<j&&arr[i]<=arr[j]) {
				i++;
			}
			if(i<j) {
				Sort.swap(arr, i, j);
				j--;
			}
		}
		//Sort.disPlay(arr);
		return i;
	}

}
