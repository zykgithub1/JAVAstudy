package demo_2021_8_29_leetcode;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
	static class Solution {
	    List<String>ans=new ArrayList();
	    public List<String> generateParenthesis(int n) {
	        dfs(n,0,0,new StringBuilder());
	        return ans;
	    }
	    public void dfs(int n,int lc,int rc,StringBuilder sb){
	        if(lc==n&&rc==n){
	            ans.add(sb.toString());
	            return;
	        }
	        if(lc<n){
	            dfs(n,lc+1,rc,sb.append('('));
	            sb.deleteCharAt(sb.length()-1);
	        }
	        if(rc<n&&lc>rc){
	            dfs(n,lc,rc+1,sb.append(')'));
	            sb.deleteCharAt(sb.length()-1);
	        }
	    }
	}
}
