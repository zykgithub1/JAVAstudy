package demo08_NumsAndMatrix;

import java.util.HashMap;

/**
 * 数组可以有正，负数，0
 * @author lenovo
 *
 */
public class unRangArrFindLongestLength2 {
	public static void main(String[] args) {
		int arr[]= {1,-1,1,1,-1,1,-1,0};
		int ans=getMaxLength2(arr,0);
		System.out.println(ans);
	}

	public static int getMaxLength2(int[] arr, int k) {
		int len=0;int sum=0;
		HashMap<Integer,Integer>map=new HashMap();
		int count=0;
		map.put(0, -1);
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) {
				count++;
			}else if(arr[i]<0){
				count--;
			}
			sum+=arr[i];
			if(map.containsKey(sum-k)) {
				if(count==0) {
					len=Math.max(len, i-map.get(sum-k));
				}
			}
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return len;
		
	}

	public static int getMaxLength(int[] arr, int k) {
		int len=0;int sum=0;
		HashMap<Integer,Integer>map=new HashMap<>();
		map.put(0, -1);
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			if(!map.containsKey(sum)) {
				map.put(sum,i);
			}
			if(map.containsKey(sum-k)) {
				len=Math.max(i-map.get(sum-k), len);
			}
		}
		return len;
		
	}

}
