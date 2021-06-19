package DataStructure;

public class mergerSort {
	public static void meger(int arr[],int low,int mid,int high) {
		int len1=mid-low+1;
		int len2=high-mid;
		int L[]=new int[len1];
		int R[]=new int[len2];
		for(int i=0;i<len1;i++) {
			L[i]=arr[low+i];
		}
		for(int h=0;h<len2;h++) {
			R[h]=arr[mid+1+h];
		}
		int i=0,j=0;
		int k=low;
		while(i<len1&&j<len2) {
			if(L[i]<=R[j]) {
				arr[k]=L[i++];
			}else {
				arr[k]=R[j++];
			}
			k++;
		}
		while(i<len1) {
			arr[k++]=arr[i++];
		}
		while(j<len2)
			arr[k++]=arr[j++];
		
	}
	
	public static void mergeSort(int arr[],int low,int high) {
		if(low<high) {
			int mid=(low+high)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			meger(arr, low, mid, high);
		}
	}
	
	public static void sort(int arr[],int left,int right,int temp[]) {
		if(left<right) {
			int mid=left+(right-left)/2;
			sort(arr,left,mid,temp);
			sort(arr,mid+1,right,temp);
			merge(arr,left,mid,right,temp);
		}
	}
	public static void merge(int arr[],int left,int mid,int right,int temp[]) {
		int i=left;int j=mid+1;int t=0;
		while(i<=mid&&j<=right) {
			if(arr[i]>=arr[j]) {
				temp[t++]=arr[j++];
			}
			else {
				temp[t++]=arr[i++];
			}
		}
		while(i<=mid) temp[t++]=arr[i++];
		while(j<=right) temp[t++]=arr[j++];
		for(int m=0;m<=right-left;m++) {
			arr[m+left]=temp[m];
		}
	}

}
