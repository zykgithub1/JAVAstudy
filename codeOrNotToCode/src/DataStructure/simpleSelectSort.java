package DataStructure;

public class simpleSelectSort {
	public static void selectSort(int arr[]) {
		int j;
		for (int i = 0; i < arr.length; i++) {
			int k = i;
			for (j = i + 1; j < arr.length; j++) {
				if (arr[k] > arr[j]) {
					k = j;
				}
			}
			insertSort.swap(arr, i, k);
		}
	}

	public static void bubbleSort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					insertSort.swap(arr, j + 1, j);
				}
			}
		}
	}

	public static void bubbleSort2(int arr[]) {
		int exchange = arr.length ;
		int bound;
		while (exchange != 0) {
			bound = exchange;
			exchange = 0;
			for (int i = 0; i < bound - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					insertSort.swap(arr, i + 1, i);
					exchange = i + 1;
				}
			}
		}
	}

}
