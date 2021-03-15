package demo01;

import java.util.Stack;

public class maxSubRecSize {
	public static void main(String[] args) {
		int[][] arr = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 } };
		int[][]arr2= {{0,0,0,0,0,1},
		{0,0,1,0,0,1},
		{0,1,1,1,0,1},
		{1,1,1,1,1,1},
		{1,1,1,1,1,1},
		{1,1,1,1,1,1}
		};
		int max = getMaxSubRec(arr);
		System.out.println(max+"\t"+getMaxSubRec(arr2));
	}

	public static void show(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static int getMaxSubRec(int[][] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int maxArea = 0;
		int[] height = new int[arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < height.length; j++) {
				height[j] = arr[i][j] == 0 ? 0 : height[j] + 1;
			}
			maxArea = Math.max(maxArea, maxRecFromBottom(height));
		}
		//show(height);
		return maxArea;
	}

	private static int maxRecFromBottom(int[] height) {
		if (height.length == 0 || height == null) {
			return 0;
		}
		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[stack.peek()] >= height[i]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (i - k - 1) * height[j];
				//System.out.println(curArea);
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int curArea = (height.length - k - 1) * height[j];
			//System.out.println(curArea);
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}

}
