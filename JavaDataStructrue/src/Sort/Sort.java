package Sort;
import java.util.Arrays;
import java.util.Random;

public class Sort {
	public static void main(String[] args) {
		int arr1[] = { 1,3,5,7,9 };
		 int arr2[]= {2,6,8};
		 int arr3[]= {1,4,7,8,3,6,9};
		 ShellSort shell=new ShellSort();
		 disPlay(arr3);
		 ShellSort.sort(arr3,0,6);
		
		 disPlay(arr3);

		//int arr[] = getRandomArr();
		//int arr[] = { 5, 3, 6, 8, 1, 7, 9, 4, 2, 10 };
		// selectSort(arr);
		// DataCheak dc = new DataCheak();
		// int arr[]=dc.getRandomArr();
 		//disPlay(arr);
 		//insertSort(arr);
 		//disPlay(arr);
		// dc.check();
		// selectSortDouble(arr);
		//disPlay(arr);
		check();
	}

//	public static void insertSort(int arr[]) {
//		int i,j,tmp;
//		for(i=1;i<=arr.length;i++) {
//			for(j=arr.length-1;j>0;j--) {
//				if(arr[j]<arr[j-1]) {
//					swap(arr, j, j-1);
//				}
//			}
//		}
//	}
//insertSort tmp版本
	public static void insertSort(int arr[]) {
		int i,j,tmp;
		for(i=1;i<arr.length;i++) {
			tmp=arr[i];j=i;
//			for(j=i;j>0&&tmp<arr[j-1];j--) {
//				arr[j]=arr[j-1];
//			}
//			arr[j]=tmp;
			while(j>0&&tmp<arr[j-1]) {
				arr[j]=arr[j-1];
				j--;
			}
			arr[j]=tmp;
		}

	}
	
	public static int[] getRandomArr() {
		Random r = new Random();
		int[] arr = new int[1000];
		for (int i = 0; i < 1000; i++) {
			arr[i] = r.nextInt(1000);
		}
		return arr;
	}

	public static void BubbleSort(int arr[]) {
		int bound;
		int change = arr.length - 1;
		while (change != 0) {
			bound = change;
			change = 0;
			for (int i = 0; i < bound; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
					change = i;
				}
			}
		}
	}

	public static void selectSort(int arr[]) {
		int minPos;
		for (int i = 0; i < arr.length; i++) {
			minPos = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minPos]) {
					minPos = j;
				}
			}
			swap(arr, i, minPos);
		}
	}

	public static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void disPlay(int arr[]) {
		int i;
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

	public static void selectSortDouble(int arr[]) {
		int start = 0, end = arr.length - 1;
		while (start < end) {
			int min = start;
			int max = end;
			for (int i = start; i <= end; i++) {
				if (arr[i] < arr[min]) {
					min = i;
				}
				if (arr[i] > arr[max]) {
					max = i;
				}
			}
			swap(arr, min, start);
			if (max == start) {
				max = min;
			}
			swap(arr, max, end);
			start++;
			end--;
		}
	}
	
	
	public static void check() {
		ShellSort shell=new ShellSort();
		int arr[] = getRandomArr();
		disPlay(arr);
		int arr2[] = new int[arr.length];
		int temp[]=new int[arr.length];
		System.arraycopy(arr, 0, arr2, 0, arr.length);
		disPlay(arr2);
		boolean same=true;
		Arrays.sort(arr);
		disPlay(arr);
		//QuickSort.quickSort(arr2,0,arr2.length-1);
		BinaryInsert.binaryInsert(arr2);
		disPlay(arr2);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=arr2[i])
				same=false;
		}
		System.out.println(same==true?"算法正确":"错误");
	}

}
