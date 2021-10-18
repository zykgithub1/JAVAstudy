package demo_2021_9_27_leetcode;

public class countSort {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int upper = 0;
		int n1 = arr1.length;
		int n2 = arr2.length;
		for (int i : arr1) {
			upper = Math.max(i, upper);
		}
		int[] frequent = new int[upper + 1];
		for (int i = 0; i < n1; i++) {
			frequent[arr1[i]]++;
		}
		int index = 0;
		for (int i = 0; i < n2; i++) {
			while (frequent[arr2[i]]-- > 0) {
				arr1[index++] = arr2[i];
				// frequent[arr2[i]]--;
			}
		}
		for (int i = 0; i <= upper; i++) {
			while (frequent[i]-- > 0) {
				arr1[index++] = i;
				// frequent[i]--;
			}
		}
		return arr1;

	}

}
