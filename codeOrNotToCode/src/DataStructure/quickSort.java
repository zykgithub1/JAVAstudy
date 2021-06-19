package DataStructure;

public class quickSort {
	public static void quick1(int arr[],int left,int right) {
		if(left<right) {
			int pos=position(arr,left,right);
			quick1(arr, left,pos-1 );
			quick1(arr,pos+1,right);
		}
	}

	private static int position(int[] arr, int left, int right) {
		int i=left,j=right;
		while(i<j) {
			while(i<j&&arr[i]<=arr[j]) {
				j--;
			}
			if(i<j) {
				insertSort.swap(arr, i, j);
				i++;
			}
			while(i<j&&arr[i]<=arr[j]) {
				i++;
			}
			if(i<j) {
				insertSort.swap(arr, i, j);
				j--;
			}
		}
		return i;
	}
	
	public static void quick2(int arr[],int left,int right) {
		int i=left,j=right;
		int temp=arr[left];
		if(left<right) {
			while(i<j) {
				while(i<j&&temp<arr[j])
					j--;
				if(i<j) {
					insertSort.swap(arr, i, j);
					i++;
				}
				while(i<j&&temp>arr[i]) {
					i++;
				}
				if(i<j) {
					insertSort.swap(arr, i, j);
					j--;
				}
			}
			arr[i]=temp;
			quick2(arr, left, i-1);
			quick2(arr, i+1, right);
		}
	}
	

}
