package demo_2021_9_27_leetcode;

import java.util.HashMap;
import java.util.Map;

public class pathSumEqualsTargetSum {
	Map<Integer,Integer>map=new HashMap();
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        map.put(0,1);
        return dfs(root,0,targetSum);
    }

    public int dfs(TreeNode root,int curSum,int targetSum){
        if(root==null){
            return 0;
        }
        curSum+=root.val;
        int ret=map.getOrDefault(curSum-targetSum,0);
        map.put(curSum,map.getOrDefault(curSum,0)+1);
        int left=dfs(root.left,curSum,targetSum);
        int right=dfs(root.right,curSum,targetSum);
        map.put(curSum,map.get(curSum)-1);
        return ret+left+right;
    }

}
