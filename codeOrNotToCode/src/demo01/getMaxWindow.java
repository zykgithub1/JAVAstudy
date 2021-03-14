package demo01;

import java.util.LinkedList;
import java.util.List;
//滑动窗口问题：需要一个双端队列：LinkedList！！！！
public class getMaxWindow {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 4, 3, 3, 6, 7 };
		int[] res = getMaxWindowself(arr, 3);
		for (Integer i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] res1 = getMaxWindow(arr, 3);
		for (Integer i : res) {
			System.out.print(i + " ");
		}
	}

	private static int[] getMaxWindowself(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		int[] res = new int[arr.length - w + 1];
		LinkedList<Integer> maxList = new LinkedList<>();
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!maxList.isEmpty() && arr[maxList.peekLast()] <= arr[i]) {
				maxList.pollLast();
			}
			maxList.addLast(i);
			if(maxList.peekFirst()==i-w) {
				maxList.pollFirst();
			}
			if(i>=w-1) {
				res[index++]=arr[maxList.peekFirst()];
			}
		}
		return res;
	}

	private static int[] getMaxWindow(int[] arr, int w) {
		if (arr.length < w || arr == null || w < 1) {
			return null;
		}
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		LinkedList<Integer> qmaxList = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			while (!qmaxList.isEmpty() && arr[qmaxList.peekLast()] <= arr[i]) {
				qmaxList.pollLast();
			}
			qmaxList.add(i);
			if (qmaxList.peekFirst() == i - w) {
				qmaxList.pollFirst();
			}
			if (i >= w - 1) {
				res[index++] = arr[qmaxList.peekFirst()];
			}
		}
		return res;
	}

}
