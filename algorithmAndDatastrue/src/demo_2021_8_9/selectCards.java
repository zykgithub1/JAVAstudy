package demo_2021_8_9;

public class selectCards {
	public static void main(String[] args) {
		int[]arr= {5,100,7,2};
		System.out.println(win1(arr));
		
	}
	
	public static int win1(int[]arr) {
		return Math.max(f(arr,0,arr.length-1), s(arr,0,arr.length-1));
	}
	
	public static int f(int[]arr,int L,int R) {
		if(L==R) {
			return arr[L];
		}
		return Math.max(arr[L]+s(arr,L+1,R), arr[R]+s(arr,L,R-1));
	}

	private static int s(int[] arr, int l, int r) {
		if(l==r) {
			return 0;
		}
		return Math.min(f(arr,l+1,r), f(arr,l,r-1));
	}

}
