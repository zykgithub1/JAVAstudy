package algorithm;

public class testBagquestion {
	public static void main(String[] args) {
//		int[] w= {3,4,5,6};
//		int[] v= {4,5,7,8};
//		int bag=10;
//		int result=process1(w,v,0,0,bag);
//		int test=process2(w,v,0,bag);
//		int test1=process3(w,v,0,bag);
//		System.out.println(result+"   "+test+"  "+test1);
		int arr[]= {4,1,100,2};
		int result=findWinner(arr);
		System.out.println(result);
	}
	
	
	public static int findWinner(int[] arr) {
		int L=0;
		int R=arr.length-1;
		return Math.max(first(arr, L, R), second(arr, L, R));
	}
	
	public static int first(int arr[],int L,int R) {
		if(L==R) {
			return arr[L];
		}
		return Math.max(arr[L]+second(arr,L+1,R),arr[R]+second(arr,L,R-1));
	}
	
	private static int second(int[] arr, int L, int R) {
		if(L==R) {
			return 0;
		}
		return Math.min(first(arr, L+1, R),first(arr, L, R-1));
	}


	public static int process3(int[] w, int[] v, int i, int bag) {
		if(bag<0) {
			return 0;
		}
		if(i==w.length) {
			return 0;
		}
		int p1=process3(w, v, i+1, bag);
		int p2=Integer.MIN_VALUE;
		if(bag>=w[i]) {
			p2=v[i]+process3(w, v, i+1, bag-w[i]);
		}
		return Math.max(p1, p2);
	}
	public static int process2(int[] w, int[] v, int index, int rest) {
		if(rest<0) {
			return -1;
		}
		if(index==w.length) {
			return 0;
		}
		int p1=process2(w, v, index+1, rest);
		int p2Next=process2(w, v, index+1, rest-w[index]);
		int p2=-1;
		if(p2Next!=-1) {
			p2=v[index]+p2Next;
		}
		return Math.max(p1, p2);
	}




	public static int process1(int[] w, int[] v, int index, int alreadyW, int bag) {
		if(alreadyW>bag) {
			return -1;
		}
		if(index==w.length) {
			return 0;
		}
		int p1=process1(w, v, index+1, alreadyW, bag);
		int p2Next=process1(w, v, index+1, alreadyW+w[index], bag);
		int p2=-1;
		if(p2Next!=-1) {
			p2=v[index]+p2Next;
		}
		return Math.max(p1, p2);
		
	}

}
