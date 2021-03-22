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
		int k=0;//쳲������ָ���ֵ��Ӧ���±�
		int mid=0;int f[]=fib();
		while(high>f[k]-1) {
			k++;
		}
		//��Ϊf[k]ֵ���ܴ���a�ĳ��ȣ����������Ҫʹ��Array�࣬���������飬ָ��a[]
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
