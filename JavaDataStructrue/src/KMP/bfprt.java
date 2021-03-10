package KMP;

import java.util.Arrays;


public class bfprt {
	public static void main(String[] args) {
		int[] arr= {19,18,17,16,15,14,13,12,11,10,9,8,7,6,5};
		System.out.println(findKthNum.findKth1(arr, 12));
		System.out.println(minKth3(arr,12));
//		Arrays.sort(arr);
//		for(int i:arr) {
//			System.out.print(i+" ");
//		}
		
	}

	public static int minKth3(int[] array, int k) {
		int[] arr = copyArray(array);
		return bfprt(arr, 0, arr.length - 1, k - 1);
	}

	private static int bfprt(int[] arr, int L, int R, int index) {
		if (L == R) {
			return arr[L];
		}
		int pivol = medianOfMedians(arr, L, R);
		int[] range = partition(arr, L, R, pivol);
		if (index >= range[0] && index <= range[1]) {
			return arr[index];
		} else if (index < range[0]) {
			return bfprt(arr, L, arr[0] - 1, index);
		} else {
			return bfprt(arr, range[1] + 1, R, index);
		}
	}

	private static int[] partition(int[] arr, int l, int r, int pivol) {
		int less = l - 1;
		int more = r + 1;
		int cur = l;
		while (cur < more) {
			if (arr[cur] < pivol) {
				swap(arr, ++less, cur++);
			} else if (arr[cur] > pivol) {
				swap(arr, --more, cur);
			} else {
				cur++;
			}
		}
		return new int[] {less+1,more-1};
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
/*将原数组分为N/5一组的小组，每组内部排序
 * 找到每组的中位数，建立一个中位数数组marr,
 * 返回中位数数组marr里面的中位数
 * */
	private static int medianOfMedians(int[] arr, int l, int r) {
		int size=r-l+1;
		//代表补不补最后不满5个数的小小组
		int offset=size%5==0?0:1;
	    int[] mArr=new int[size/5+offset];
	    for(int team=0;team<mArr.length;team++) {
	    	//每各小组其实元素：
	    	int teamFirst=l+team*5;
	    	mArr[team]=getMedian(arr,teamFirst,Math.min(r, teamFirst+4));
	    }
	    //在mArr通过bfprt找到中位数：
//	    for(int i:mArr) {
//	    	System.out.print(i+" ");
//	    }
//	    System.out.println("len="+mArr.length);
	    return bfprt(mArr,0, mArr.length-1, mArr.length/2);
	}

	private static int getMedian(int[] arr, int L, int R) {
		insertionSort(arr,L,R);
		return arr[(L+R)/2];
	}

	private static void insertionSort(int[] arr, int l, int r) {
		for(int i=l+1;i<=r;i++) {
			for(int j=i-1;j>=l&&arr[j]>arr[j+1];j--) {
				swap(arr, j, j+1);
			}
		}
	}

	public static int[] copyArray(int[] array) {
		int[] arr = new int[array.length];
		System.arraycopy(array, 0, arr, 0, array.length);
		return arr;
	}
}
