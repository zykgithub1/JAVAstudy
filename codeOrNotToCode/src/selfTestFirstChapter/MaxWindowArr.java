package selfTestFirstChapter;

import java.util.LinkedList;

public class MaxWindowArr {
	public static void main(String[] args) {
		int[]arr= {4,3,5,4,3,3,6,7};
		int[]ans=process(arr,3);
		for(int i:ans) {
			System.out.print(i+" ");
		}
	}

	public static int[] process(int[] arr, int window) {
		if(arr==null||arr.length==0) {
			return new int[] {};
		}
		int res[]=new int[arr.length-window+1];
		LinkedList<Integer>maxQ=new LinkedList<>();
		int index=0;
		for(int i=0;i<arr.length;i++) {
			//5进来是关键 因为大于arr[1,0]所以1，0弹出  此时maxQ只有2
			while(!maxQ.isEmpty()&&arr[maxQ.peekLast()]<=arr[i]) {
				maxQ.pollLast();
			}
			maxQ.addLast(i);
			//这里顺序不能和下面的if交换  不然会先记录即将弹出的值 导致结果数组错误：
			if(i-window==maxQ.peekFirst()) {
				maxQ.pollFirst();
			}
			if(i>=window-1) {
				res[index++]=arr[maxQ.peekFirst()];
			}
			
		}
		return res;
	}
	

}
