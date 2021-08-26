package demo_2021_8_26_;

import java.util.HashMap;

public class maxLenUniqueSubstr {
	public static void main(String[] args) {
		System.out.println(way1("aaabbcdefcd"));
		System.out.println(way2("aaabbcdefcd")+"-<aassa");
	}
	public static int way1(String str) {
		int n=str.length();
		int[]map=new int[256];
		char[] chs = str.toCharArray();
		for(int i=0;i<256;i++) {
			map[i]=-1;
		}
		int pre=-1;
		int ans=0;
		int cur=0;
		for(int i=0;i<chs.length;i++) {
			pre=Math.max(pre, map[chs[i]]);
			cur=i-pre;
			ans=Math.max(ans, cur);
			map[chs[i]]=i;
		}
//		for(int i=0;i<map.length;i++) {
//			System.out.printf(map[i]+" ");
//		}
//		System.out.println();
		return ans;
	
	}
	public static int way2(String str) {
		int n=str.length();
		HashMap<Character,Integer>map=new HashMap<Character, Integer>();
		char[] chs = str.toCharArray();
		int pre=-1;
		int ans=0;
		int cur=0;
		for(int i=0;i<chs.length;i++) {
			pre=Math.max(pre, map.getOrDefault(chs[i], -1));
			System.out.printf(pre+" ");
			cur=i-pre;
			ans=Math.max(ans, cur);
			map.put(chs[i], i);
		}
		return ans;
	
	}

}
