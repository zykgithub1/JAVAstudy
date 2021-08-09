package demo_2021_8_9;

import java.util.ArrayList;
import java.util.List;

public class printAllSubsequence {
	public static void main(String[] args) {
		List<String> findByRecursion = findByRecursion("abc");
		System.out.println(findByRecursion);
	}
	public static  List<String> findByRecursion(String words){
		char[]chs=words.toCharArray();
		List<String>ans=new ArrayList();
		dfs(chs,0,ans,new StringBuilder());
		return ans;
	}

	private static void dfs(char[] chs, int i, List<String> ans, StringBuilder sb) {
		if(i==chs.length) {
			ans.add(sb.toString());
			return;
		}
		sb.append(chs[i]);
		dfs(chs, i+1, ans, sb);
		sb.deleteCharAt(sb.length()-1);
		dfs(chs, i+1, ans, sb);
	}

}
