package Sort;

public class MergeSort {
	public static void main(String[] args) {
		int arr[]=Sort.getRandomArr();
		disPlay(arr);
		int[] temp=new int[arr.length];
		sort(arr,0,arr.length-1,temp);
		disPlay(arr);
		//Sort.Sort.check();
		
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
	
	public static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void disPlay(int arr[]) {
		int i;
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

}
