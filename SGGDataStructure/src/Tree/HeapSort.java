package Tree;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int arr[]= {4,6,8,5,9,-1,999,-888};
		heapSort2(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	public static void heapSort(int arr[]) {
		int tmp=0;
		for(int j=arr.length/2-1;j>=0;j--) {
			adjustHeap(arr, j, arr.length);;
		}
		for(int j=arr.length-1;j>0;j--) {
			tmp=arr[j];
			arr[j]=arr[0];
			arr[0]=tmp;
			adjustHeap(arr, 0,j );
		}
		
	}
	/**
	 * 
	 * @param arr
	 * @param i   表示非叶子节点在数组中的索引
	 * @param length  表示对数组中多少个元素进行调整
	 */
	public static void adjustHeap(int arr[],int i,int length) {
		int tmp=arr[i];
		for(int k=2*i+1;k<length;k=k*2+1) {
			if(k+1<length&&arr[k]<arr[k+1]) {
				k++;
			}
			if(tmp<arr[k]) {
				arr[i]=arr[k];
				i=k;
			}else {
				break;
			}
		}
		arr[i]=tmp;
	}
	
	public static void heapSort2(int arr[]) {
		for(int j=arr.length/2-1;j>=0;j--) {
			sift(arr, j, arr.length);
		}
		for(int j=arr.length-1;j>0;j--) {
			int tmp=arr[j];
			arr[j]=arr[0];
			arr[0]=tmp;
			sift(arr, 0, j);
		}
		
	}
	
	public static void sift(int arr[],int start,int end) {
		int i=start;int j=2*i+1;
		while(j<end) {
			if(j+1<end&&arr[j]<arr[j+1]) {
				j++;
			}
			if(arr[i]<arr[j]) {
				int tmp=arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;
			}
			i=j;
			j=2*j+1;
		}
	}
}
