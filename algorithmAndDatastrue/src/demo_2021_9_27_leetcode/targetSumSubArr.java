package demo_2021_9_27_leetcode;

import java.util.HashMap;
import java.util.Map;

public class targetSumSubArr {
	public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int preSum=0;
        Map<Integer,Integer>map=new HashMap();
        int res=0;
        map.put(0,1);
        for(int i:nums){
            preSum+=i;
            res+=map.getOrDefault(preSum-k,0);
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return res;
        
    }

}
