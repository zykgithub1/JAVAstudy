package demo1_2021_8_2;

public class smallSumQuestion {
	public static void main(String[] args) {
		int[] arr = { 7, 6, 5, 4, 3, 2, 1 };
		System.out.println(mergeSort(arr, 0, arr.length - 1));
		recursionToFindMax.showArr(arr);
	}

	public static int mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return 0;
		}
		int mid = l + r >> 1;
		return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
	}

	private static int merge(int[] arr, int l, int mid, int r) {
		int[] help = new int[r - l + 1];
		int i = 0;
		int ans = 0;
		int p1 = l, p2 = mid + 1;
		while (p1 <= mid && p2 <= r) {
			if (arr[p1] < arr[p2]) {
				help[i++] = arr[p1];
				ans += arr[p1++] * (r - p2 + 1);
			} else {
				help[i++] = arr[p2++];
			}
//			ans+=arr[p1]<arr[p2]?arr[p1]*(r-p2+1):0;
//			help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
		}
		while (p1 <= mid)
			help[i++] = arr[p1++];
		while (p2 <= r)
			help[i++] = arr[p2++];
//		recursionToFindMax.showArr(help);
		for (i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}
		return ans;
	}

}
