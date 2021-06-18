package DataStructure;

import java.util.Arrays;

public class insertSort {
	public static void main(String[] args) {
		int arr[]= {5,3,6,2,7,9,1,0,8};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void insertSort(int arr[]) {
		int temp=0;
		for(int i=1;i<arr.length;i++) {
			int j=i-1;temp=arr[i];
			while(j>=0&&arr[j]>temp) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[++j]=temp;
		}
	}
	
	public static void swap(int arr[],int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}
