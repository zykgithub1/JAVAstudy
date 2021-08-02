package demo1_2021_8_2;

public class recursionToFindMax {
	public static void main(String[] args) {
		int[] arr = { 3, 2, 5, 6, 7, 4 };
		int[] arr1 = { 19, 45, 11, 9, 3, 2, 1, 7, 4 };
		int max = findMax(arr, 0, arr.length - 1);
//		System.out.printf("max=%d\n", max);
		mergeSort(arr1, 0, arr1.length - 1);
		showArr(arr1);

	}

	public static void showArr(int[] arr) {
		for (int ar : arr) {
			System.out.print(ar + " ");
		}
		System.out.println();
	}

	private static int findMax(int[] arr, int i, int j) {
		if (i == j) {
			return arr[i];
		}
		// int mid=i+((j-i)>>1);
		int mid = i + j >> 1;
//		System.out.printf("i=%d,j=%d,mid=%d\n", i, j, mid);
		int left = findMax(arr, i, mid);
		int right = findMax(arr, mid + 1, j);
		return Math.max(left, right);
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int len = temp.length;
		int i = 0;
		int p1 = left, p2 = mid + 1;
		while (p1 <= mid && p2 <= right) {
//			if(arr[p1]<=arr[p2]) {
//				temp[i++]=arr[p1++];
//			}else {
//				temp[i++]=arr[p2++];
//			}
			temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= mid)
			temp[i++] = arr[p1++];
		while (p2 <= right)
			temp[i++] = arr[p2++];
		for (i = 0; i < len; i++) {
			arr[left + i] = temp[i];
		}
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = left + right >> 1;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}
}
