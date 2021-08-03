package demo_2021_8_3;

public class heap {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 2, 7, 8, 1, 10, 5, 5, 11, 19, 5 };
		heapSort(arr);
		demo_2021_8_2.recursionToFindMax.showArr(arr);

	}

	public static void heapSort(int arr[]) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			heapInsert(arr, i);
		}
		int heapSize = len;
		swap(arr, 0, --heapSize);
		while (heapSize > 0) {
			heapify(arr, 0, heapSize);
			swap(arr, 0, --heapSize);
		}
	}

	// num at index
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	// usually headpify at index 0,heapSize is range of heap
	public static void heapify(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		while (left < heapSize) {
			int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
			largest = arr[index] < arr[largest] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, index, largest);
			index = largest;
			left = index * 2 + 1;
		}
	}

	public static void heapifyByself(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		while (left < heapSize) {
			int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
