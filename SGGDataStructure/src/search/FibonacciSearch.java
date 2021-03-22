package search;

import java.util.Arrays;

public class FibonacciSearch {
	public static int masSize=20;

	public static void main(String[] args) {
		int[]arr= {1,8,10,89,1000,1234};
		System.out.println(fibSearch(arr, 1234));
	}
	
	
	public static int[]fib(){
		int[] res=new int[masSize];
		res[0]=1;res[1]=1;
		for(int i=3;i<masSize;i++) {
			res[i]=res[i-1]+res[i-2];
		}
		return res;
	}
	//mid=low+F(k-1)-1
	public static int fibSearch(int[]arr,int key) {
		int low=0;
		int high=arr.length-1;
		int k=0;//斐波那契分割数值对应的下标
		int mid=0;int f[]=fib();
		while(high>f[k]-1) {
			k++;
		}
		//因为f[k]值可能大于a的长度，因此我们需要使用Array类，构造新数组，指向a[]
		int[] temp=Arrays.copyOf(arr, f[k]);
		for(int i=high+1;i<temp.length;i++) {
			temp[i]=arr[high];
		}
		while(low<=high) {
			mid=low+f[k-1]-1;
			if(temp[mid]<key) {
				low=mid+1;
				k-=2;
			}else if(temp[mid]>key) {
				high=mid-1;
				k--;
			}else {
				if(mid<=high) {
					return mid;
				}else {
					return high;
				}
			}
		}
		return -1;
	}
}
