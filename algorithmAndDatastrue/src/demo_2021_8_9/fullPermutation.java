package demo_2021_8_9;

import java.util.ArrayList;
import java.util.List;

public class fullPermutation {
	public static void main(String[] args) {
		List<String> findAll = findAll("abc");
		System.out.println(findAll);
	}

	public static List<String> findAll(String words) {
		char[] chs = words.toCharArray();
		List<String> ans = new ArrayList();
		boolean[] use = new boolean[chs.length];
		dfs(chs, 0, ans);
		return ans;
	}

	private static void dfs(char[] chs, int i, List<String> ans) {
		if(i==chs.length) {
			ans.add(String.valueOf(chs));
			return;
		}
		for(int j=i;j<chs.length;j++) {
			swap(chs,i,j);
			dfs(chs, i+1, ans);
			swap(chs,i,j);
		}
	}

	private static void swap(char[] chs, int i, int j) {
		char temp=chs[i];
		chs[i]=chs[j];
		chs[j]=temp;
		
	}


	

	

}
