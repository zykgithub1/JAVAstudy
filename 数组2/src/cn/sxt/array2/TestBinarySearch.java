package cn.sxt.array2;

import java.util.Arrays;

//Import java.util.Scanner;

public class TestBinarySearch {
	public static void main(String[]args) {
		int[] arr= {30,20,50,10,80,9,7,12,100,40,8};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int value=10;
		System.out.println(myBinarySearch(arr, 12));
	}
	public static int myBinarySearch(int[] arr,int value) {
		int right=arr.length-1;
		int left=0;
		
		while(left<=right) {
			int mid=(right+left)/2;
			if(value==arr[mid])
				return mid;
			if(value>arr[mid]) {
				left=mid+1;
			}
			if(value<arr[mid]) {
				right=mid-1;
			}
		}
		
		return -1;
	}

}
