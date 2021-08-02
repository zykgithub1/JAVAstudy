package demo1_2021_8_2;

public class dutchFlag {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 2, 7, 8, 1, 10 };
		process(arr, 5);
		recursionToFindMax.showArr(arr);
	}

	private static void process(int[] arr, int povid) {
		int l = -1, r = arr.length;
		int i = 0;
		while (i < r) {
			if (arr[i] < povid) {
				swap(arr, ++l, i++);
			} else if (arr[i] == povid) {
				i++;
			} else {
				swap(arr, --r, i);
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
