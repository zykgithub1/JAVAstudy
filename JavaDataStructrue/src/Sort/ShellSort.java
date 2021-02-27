package Sort;
import java.util.Stack;

public class ShellSort {
	public static void ShellSort(int arr[]) {
		Sort so = new Sort();
		int i, j, k, tmp;
		for (k = arr.length / 2; k > 0; k /= 2) {
			for (i = k; i < arr.length; i++) {
				tmp = arr[i];
				j = i;
				while (j - k >= 0 && arr[j - k] > tmp) {
					arr[j] = arr[j - k];
					j -= k;
				}
				arr[j] = tmp;
			}
			// so.disPlay(arr);
		}
	}

//	public static void mergeSort(int arr[]) {
//		int i,j,mid;
//		mid=arr.length/2;
//		i=0;j=mid+1;
//		int[] temp=new int[arr.length];
//		int t=0;
//		while(i<=mid&&j<arr.length) {
//			if(arr[i]>arr[j]) {
//				temp[t++]=arr[j++];
//			}
//			else if(arr[i]<arr[j]) {
//				temp[t++]=arr[i++];
//			}
//			else {
//				arr[t++]=arr[i++];
//				arr[t++]=arr[j++];
//			}
//		}
//		while(i<=mid)
//			temp[t++]=arr[i++];
//		while(j<arr.length)
//			temp[t++]=arr[j++];
//		Sort so=new Sort();
//		so.disPlay(temp);
//	}
//	public static void mergeSort(int arr1[],int arr2[]) {
//		int i,j,t;
//		int[] temp=new int[arr1.length+arr2.length];
//		i=0;j=0;t=0;
//		while(i<=arr1.length-1&&j<=arr2.length-1) {
//			if(arr1[i]<=arr2[j]) {
//				temp[t++]=arr1[i++];
//			}
//			else {
//				temp[t++]=arr2[j++];
//			}
//		}
//		while(i<arr1.length)
//			temp[t++]=arr1[i++];
//		while(j<arr2.length)
//			temp[t++]=arr2[j++];
//		Sort so=new Sort();
//		so.disPlay(arr1);
//		so.disPlay(arr2);
//		so.disPlay(temp);
//	}
	public static void sort(int arr[],int left,int right) {
		if(left==right||left>=right||left<0||right<0) {
			return;
		}
		
		int mid=(left+right)/2;
		sort(arr,0,mid);
		sort(arr,mid+1,right);
		merge(arr, left, mid+1, right);
	}
	public static void merge(int arr[],int left,int right,int rightbound) {
		int i, j, mid;
		mid = right-1;
		i = left;
		j = right;
		int[] temp = new int[rightbound-left+1];
		int t = 0;
		while (i <= mid && j <=rightbound) {
			if (arr[i] > arr[j]) {
				temp[t++] = arr[j++];
			} else if (arr[i] < arr[j]) {
				temp[t++] = arr[i++];
			} else {
				arr[t++] = arr[i++];
				arr[t++] = arr[j++];
			}
		}
		while (i <= mid)
			temp[t++] = arr[i++];
		while (j <= rightbound)
			temp[t++] = arr[j++];
		for(int m=0;m<temp.length;m++) {
			arr[m+left]=temp[m];
		}
		//Sort.disPlay(temp);
	}
}
