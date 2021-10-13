package demo_2021_9_27_leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class minPairs {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m=nums1.length;int n=nums2.length;
        int[]pos=new int[m];
        PriorityQueue<Integer>que=new PriorityQueue<>((a,b)->
        nums1[a]+nums2[pos[a]]-nums1[b]-nums2[pos[b]]);
        for(int i=0;i<Math.min(k,m);i++){
            que.offer(i);
        }
        List<List<Integer>> res=new ArrayList<>();
        while(res.size()<k&&!que.isEmpty()){
            int cur=que.poll();
            List<Integer>temp=new ArrayList();
            temp.add(nums1[cur]);
            temp.add(nums2[pos[cur]]);
            res.add(temp);
            if(++pos[cur]<n){
                que.offer(cur);
            }
        }
        return res;
    }

}
