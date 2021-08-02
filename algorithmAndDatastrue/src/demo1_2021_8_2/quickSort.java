package demo1_2021_8_2;

public class quickSort {
	public static void main(String[] args) {
		int []arr= {19,14,10,4,2,15,22,32,11};
		quickSort(arr, 0, arr.length-1);
		recursionToFindMax.showArr(arr);
		
	}
	
	public static void quickSort(int[]arr,int L,int R) {
		if(L<R) {
			dutchFlag.swap(arr, L+(int)(Math.random()*(R-L+1)), R);
			int[]p=partition(arr,L,R);
			quickSort(arr, L, p[0]-1);
			quickSort(arr, p[1]+1, R);
		}
	}

	private static int[] partition(int[] arr, int l, int r) {
		int less=l-1,more=r;
		while(l<more) {
			if(arr[l]<arr[r]) {
				dutchFlag.swap(arr, ++less, l++);
			}else if(arr[l]==arr[r]) {
				l++;
			}else {
				dutchFlag.swap(arr, --more, l);
			}
		}
		dutchFlag.swap(arr, more, r);
		return new int[] {less+1,more};
	}

}
