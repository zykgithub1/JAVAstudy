package search;

import java.util.Arrays;
//��ֵ�����㷨Ҫ����������
public class InsertValueSearch {
	public static void main(String[] args) {
		int arr[]=new int[100];
		for(int i=0;i<100;i++) {
			arr[i]=i+1;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(insertValueSearch(arr, 0, arr.length-1, 100)+"  ");
		
	}
	
	public static int insertValueSearch(int[]arr,int left,int right,int value) {
		System.out.println("���Ҵ���");
		int mid=left+(right-left)*(value-arr[left])/(arr[right]-arr[left]);
		if(left>right||value<arr[left]||value>arr[arr.length-1]) {
			return -1;
		}
		if(arr[mid]>value) {
			return insertValueSearch(arr, left, mid-1, value);
		}else if(arr[mid]<value) {
			return insertValueSearch(arr, mid+1, right, value);
		}else {
			return mid;
		}
	}
}
