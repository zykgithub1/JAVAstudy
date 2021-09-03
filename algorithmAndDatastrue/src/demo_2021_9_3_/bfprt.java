package demo_2021_9_3_;

public class bfprt {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 7, 7, 8, 9 };
		int[] pa = partition(arr, 0, arr.length - 1, 6);
		System.out.println(pa[0] + " " + pa[1]);
		int[] arr2 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		int[] arr3 = { 6, 5, 8, 3, 2, 0, 10, 7, 4 };
		int c = getMedian(arr2, 0, arr2.length - 1);
		System.out.println(c);
		for (int in : arr2) {
			System.out.printf(in + " ");
		}
		System.out.println();
//		insertSort(arr3);
		for (int in : arr3) {
			System.out.printf(in + " ");
		}
		System.out.println("\n---------------------------------------");
		for (int i = 0; i <= arr3.length - 1; i++) {
			System.out.printf(findKth(arr3, 0, arr3.length - 1, i) + " ");
		}
		insertSort(arr3);
		System.out.println();
		for (int i : arr3) {
			System.out.printf(i + " ");
		}

	}

	public static int findKth(int arr[], int begin, int end, int i) {
		if (begin == end) {
			return arr[begin];
		}
		int pivod = medianOfMedians(arr, begin, end);
		int[] pivodRange = partition(arr, begin, end, pivod);
		if (i >= pivodRange[0] && i <= pivodRange[1]) {
			return arr[i];
		} else if (i < pivodRange[0]) {
			return findKth(arr, begin, pivodRange[0] - 1, i);
		} else {
			return findKth(arr, pivodRange[1] + 1, end, i);
		}
	}

	private static int medianOfMedians(int[] arr, int begin, int end) {
		int nums = end - begin + 1;
		int offset = nums % 5 == 0 ? 0 : 1;
		int[] mArr = new int[nums / 5 + offset];
		for (int i = 0; i < mArr.length; i++) {
			int be = begin + i * 5;
			int en = be + 4;
			mArr[i] = getMedian(arr, be, Math.min(end, en));
		}
		return findKth(mArr, 0, mArr.length - 1, mArr.length / 2);
	}

	private static int getMedian(int[] arr, int be, int en) {
		for (int i = be + 1; i <= en; i++) {
			int temp = arr[i];
			for (int j = i; j > be && arr[j - 1] > temp; j--) {
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
		int sum = be + en;
		int mid = sum / 2 + sum % 2;
		return arr[mid];

	}

	public static int[] insertSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			for (int j = i; j > 0 && temp < arr[j - 1]; j--) {
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		}
		return arr;
	}

	public static int[] partition(int[] arr, int begin, int end, int key) {
		int l = begin - 1;
		int r = end + 1;
		int index = begin;
		while (index < r) {
			if (arr[index] < key) {
				swap(arr, ++l, index++);
			} else if (arr[index] > key) {
				swap(arr, --r, index);
			} else {
				index++;
			}
//			System.out.println("r->"+r);
		}

		return new int[] { l + 1, r - 1 };
	}

	private static void swap(int[] arr, int i, int j) {
		int tem = arr[i];
		arr[i] = arr[j];
		arr[j] = tem;
	}
}
