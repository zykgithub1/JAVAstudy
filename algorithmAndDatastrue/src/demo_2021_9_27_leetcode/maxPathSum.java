package demo_2021_9_27_leetcode;

import java.util.ArrayList;
import java.util.List;

public class maxPathSum {
	List<Integer>list=new ArrayList();
    public int maxPathSum(TreeNode root) {
        dfs(root);
        
        int[]arr=new int[list.size()];
        int n=list.size();
        for(int i=0;i<n;i++){
            arr[i]=list.get(i);
        }
        int ans=arr[0];
        int pre=0;
        for(int num:arr){
            pre=Math.max(pre+num,num);
            ans=Math.max(ans,pre);
            
        }
        return ans;
        

    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

}
