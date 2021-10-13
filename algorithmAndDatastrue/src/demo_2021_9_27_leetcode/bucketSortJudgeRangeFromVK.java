package demo_2021_9_27_leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class bucketSortJudgeRangeFromVK {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long>set=new TreeSet();
        int n=nums.length;
        for(int i=0;i<n;i++){
            Long ceil=set.ceiling((long)nums[i]-(long)t);
            if(ceil!=null&&ceil<=(long)nums[i]+(long)t){
                return true;
            }
            set.add((long)nums[i]);
            if(i>=k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }
	long w=0;
    Map<Long,Long>map=new HashMap();
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        w=(long)t+1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i-k-1>=0&&map.containsKey(getID(nums[i-k-1]))){
                map.remove(getID(nums[i-k-1]));
            }
            if(map.containsKey(getID(nums[i]))){
                return true;
            }
            if(map.containsKey(getID(nums[i])-1)){
                if(Math.abs(map.get(getID(nums[i]) - 1) - (long)nums[i]) <= t){
                    return true;
                }
            }
            if(map.containsKey(getID(nums[i])+1)){
                if(Math.abs(map.get(getID(nums[i]) + 1) - (long)nums[i]) <= t){
                    return true;
                }
            }
            map.put((long)getID(nums[i]),(long)nums[i]);
        }
        return false;

    }

    public long getID(int num){
        if(num>=0){
            return num/w;
        }else{
            return (num)/w-1;
        }
    }

}
