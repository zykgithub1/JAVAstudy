package Sort;

public class BinaryInsert {
	public static void main(String[] args) {
		int arr[] = { 11,9,8,7,6,5,4,3,2,1};
		Sort.disPlay(arr);
		binaryInsert(arr);
		Sort.disPlay(arr);
		Sort.check();
	}

	public static void binaryInsert(int arr[]) {
		int i, j, tmp;
		for (i = 1; i < arr.length; i++) {
			tmp = arr[i];
			int left = 0;
			int right = i - 1;
			while (left <=right) {
				int mid = left + (right - left) / 2;
				if (arr[mid] > tmp) {
					right = mid - 1;
				}
				else  {
					left = mid + 1;
				}
			}
			for(j=i-1;j>=left;j--) {
				arr[j+1]=arr[j];
			}
			arr[left] = tmp;
		}
	}
//移位版本
//	public static void binaryInsert(int arr[]) {
//		int i,j,tmp;
//		for(i=1;i<=arr.length-1;i++) {
//			j=i;tmp=arr[j];
//			while(j>0&&tmp<arr[j-1]) {
//				arr[j]=arr[j-1];
//				j--;
//			}
//			arr[j]=tmp;
//		}
//	}
	// 交换版本
//	public static void binaryInsert(int arr[]) {
//		int i, j, tmp;
//		for(i=0;i<arr.length;i++) {
//			for(j=arr.length-1;j>0;j--) {
//				if(arr[j]<arr[j-1]) {
//					Sort.swap(arr, j-1, j);
//				}
//			}
//		}
//	}

}
