package demo_2021_9_19;

public class twoKeyBoard {
	class Solution {
	    int ans=Integer.MAX_VALUE;
	    public int minSteps(int n) {
	        if(n==1){
	            return 0;
	        }
	        dfs(1,1,n,1);
	        return ans;
	    }

	    public void dfs(int cur,int copy,int n,int times){
	        if(cur==n){
	            ans=Math.min(times,ans);
	            return;
	        }
	        if(cur>n){
	            return;
	        }
	        if(times>ans){
	            return;
	        }
	        dfs(cur+copy,copy,n,times+1);
	        if(cur!=copy){
	            dfs(cur,cur,n,times+1);
	        } 
	    }
	}
}

