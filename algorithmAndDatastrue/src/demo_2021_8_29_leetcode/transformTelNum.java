package demo_2021_8_29_leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class transformTelNum {
	public static void main(String[] args) {
		Solution so=new Solution();
		so.letterCombinations(null);
	}
	static class Solution {
	    HashMap<Integer,char[]>map=new HashMap();
	    List<String>ans=new ArrayList();
	    public List<String> letterCombinations(String digits) {
	        map.put(2,"abc".toCharArray());
	        map.put(3,"def".toCharArray());
	        map.put(4,"ghi".toCharArray());
	        map.put(5,"jkl".toCharArray());
	        map.put(6,"mno".toCharArray());
	        map.put(7,"pqrs".toCharArray());
	        map.put(8,"tuv".toCharArray());
	        map.put(9,"wxyz".toCharArray());
	        if(digits.length()==0||digits==null){
	            return ans;
	        }
	        dfs(digits.toCharArray(),0,new StringBuilder());
	        return ans;
	    }
	    public void dfs(char[]chs,int index,StringBuilder sb){
	        if(index==chs.length){
	            ans.add(sb.toString());
	            return;
	        }
	        char[]charArr=map.get(chs[index]-'0');
	        for(char ch:charArr){
	            sb.append(ch);
	            dfs(chs,index+1,sb);
	            sb.deleteCharAt(sb.length()-1);
	        }
	    }
	}
}
