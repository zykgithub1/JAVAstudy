package demo_2021_9_13;

import java.util.HashMap;
import java.util.Map;

public class leetcode {
    public static void main(String[] args) {
        Solution so=new Solution();
        System.out.println(so.numberOfBoomerangs(new int[][]{{}}));
    }
}
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans=0;
        for(int[]point:points){
            Map<Integer,Integer> map=new HashMap();
            for(int[] p:points){
                int dis=(point[0]-p[0])*(point[0]-p[0])+(point[1]-p[1])*(point[1]-p[1]);
                map.put(dis,map.getOrDefault(dis,0)+1);
            }
            for(Map.Entry<Integer,Integer>entry:map.entrySet()){
                int m=entry.getValue();
                ans+=m*(m-1);
            }
        }
        return ans;

    }
}
