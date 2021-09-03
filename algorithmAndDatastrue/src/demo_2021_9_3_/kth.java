package demo_2021_9_3_;

import java.util.PriorityQueue;
import java.util.Stack;

public class kth {
	public static void main(String[] args) {
		int[]arr= {8,3,4,2,1,5};
		Solution so = new Solution();
		int[] s = so.smallestK(arr, 3);
		for(int u:s) {
			System.out.println(u);
		}
	}

}
class Solution {
    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer>que=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for(int i=0;i<arr.length;i++){
            if(que.size()<k){
                que.offer(arr[i]);
            }else{
                if(que.peek()>arr[i]){
                    que.poll();
                    que.add(arr[i]);
                }
            }
        }
        Stack<Integer>s=new Stack();
        while(!que.isEmpty()){
            s.push(que.poll());
        }
        int i=0;
        int[]ans=new int[k];
        while(!s.isEmpty()){
            ans[i++]=s.pop();
        }
        return ans;
    }
}