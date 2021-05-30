package PTA2021_5_30;

import java.util.*;
public class why{
	static int []arr;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int q = sc.nextInt();
		arr = new int [n];
		for(int i = 0;i < n;i ++) {
			arr[i] = sc.nextInt();
		}
		for(int i = 0;i < q;i ++) {
			int num = sc.nextInt();
			int idx = Arrays.binarySearch(arr, num);
			if(idx < 0) {
				System.out.println(-1 + " " + -1);
			}else {
				int l = idx,r = idx;
				while(l - 1 >= 0 && arr[l-1] == num) l --;
				while(r + 1 < n && arr[r+1] == num) r ++;
				System.out.println(l + " " + r);
			}
		}
	}
}