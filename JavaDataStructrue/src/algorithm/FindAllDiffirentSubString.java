package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllDiffirentSubString {
	public static void main(String[] args) {
		String str="aab";
		List<String> list=diffirentSubs(str);
		for(String to:list) {
			System.out.println();
		}
	}
	
	
	public static List<String> diffirentSubs(String s){
		char[] str=s.toCharArray();
		String path="";
		List<String> ans=new ArrayList<>();
		HashSet<String> set=new HashSet<>();
		process(str,0,set,path);
		for(String cur:set) {
			ans.add(cur);
		}
		return ans;
	}


	private static void process(char[] str, int index,HashSet<String> set, String path) {
		if(index==str.length) {
			set.add(path);
			return;
		}
		String no=path;
		process(str, index+1, set, no);
		String yes=path+String.valueOf(str[index]);
		System.out.println(yes);
		process(str, index+1, set, yes);
		
	}
	
	

}
