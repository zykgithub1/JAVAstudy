package demo_2021_9_27_leetcode;

import java.util.HashMap;
import java.util.Map;


public class pathSumBT {
	Map<Integer,Integer>map=new HashMap();
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0,1);
        return dfs(root,0,targetSum);
    }
    public int dfs(TreeNode root,int cur,int targetSum){
        if(root==null){
            return 0;
        }
        cur+=root.val;
        int ans=map.getOrDefault(cur-targetSum,0);
        map.put(cur,map.getOrDefault(cur,0)+1);
        ans+=dfs(root.left,cur,targetSum);
        ans+=dfs(root.right,cur,targetSum);
        map.put(cur,map.get(cur)-1);
        return ans;
    }

}
