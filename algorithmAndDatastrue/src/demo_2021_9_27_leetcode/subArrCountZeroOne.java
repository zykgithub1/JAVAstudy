package demo_2021_9_27_leetcode;

import java.util.HashMap;

public class subArrCountZeroOne {
	public int findMaxLength(int[] nums) {
        int ans=0;
        int n=nums.length;
        Map<Integer,Integer>map=new HashMap();
        map.put(0,-1);
        int res=0;
        int sum=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                sum--;
            }else{
                sum++;
            }
            if(map.containsKey(sum)){
                ans=Math.max(ans,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
            
        }
        return ans;
        

    }

}
