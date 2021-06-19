package DataStructure;

public class complicSort {
	public static void shellSort(int arr[]) {
		for(int k=arr.length/2;k>=1;k/=2) {
			for(int i=k;i<arr.length;i++) {
				int j=i-k;int temp=arr[i];
				while(j>=0&&temp<arr[j]) {
					arr[j+k]=arr[j];
					j-=k;
				}
				arr[j+k]=temp;
			}
		}
	}
	
	public static void shift(int arr[],int start,int end) {
		int i=start;
		int j=2*start+1;
		while(j<end) {
			if(j+1<end&&arr[j]<arr[j+1]) {
				j++;
			}
			if(arr[j]>arr[i]) {
				insertSort.swap(arr, i, j);
			}
			i=j;j=2*j+1;
		}
	}
	
	public static void heapSort(int arr[],int start,int end) {
		for(int k=arr.length/2-1;k>=0;k--) {
			shift(arr, k, end);
		}
		for(int i=arr.length-1;i>=0;i--) {
			insertSort.swap(arr, 0, i);
			shift(arr,0,i);
		}
	}
}
