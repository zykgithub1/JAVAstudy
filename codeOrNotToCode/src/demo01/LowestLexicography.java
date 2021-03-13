package demo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class LowestLexicography {
	public static void main(String[] args) {
//		String[] arr= {"gk","be","cr","fp","nr","gb","yq"};
//		System.out.println(lowestString1(arr));
//		System.out.println(lowestString2(arr));
		int arrLen=10;
		int strLen=5;
		int testTimes=10;
		for(int i=0;i<testTimes;i++) {
			String[] arr1=getRandomStringArray(arrLen,strLen);
			String[] arr2=copyStringArray(arr1);
			if(!lowestString1(arr1).equals(lowestString2(arr2))) {
				System.out.println("Oops!!");
			}
		}
		System.out.println("finish!!");
	}
	
	

	private static String[] copyStringArray(String[] arr1) {
		String[] res=new String[arr1.length];
		for(int i=0;i<arr1.length;i++) {
			res[i]=arr1[i];
		}
		return res;
	}

	private static String getRandomString(int strLen) {
		char[] ans=new char[(int)(Math.random()*strLen)+1];
		for(int i=0;i<ans.length;i++) {
			int value=(int)(Math.random()*20);
			ans[i]=(char)(97+value);
		}
		return String.valueOf(ans);
	}
	
	private static String[] getRandomStringArray(int arrLen, int strLen) {
		String[] ans=new String[(int)(Math.random()*arrLen)+1];
		for(int i=0;i<ans.length;i++) {
			ans[i]=getRandomString(strLen);
		}
		return ans;
	}

	public static String lowestString1(String[] strs) {
		if(strs==null||strs.length==0) {
			return "";
		}
		ArrayList<String> all=new ArrayList<>();
		HashSet<Integer> use=new HashSet<>();
		process(strs,use,"",all);
		String lowest=all.get(0);
		
		for(int i=1;i<all.size();i++) {
			if(all.get(i).compareTo(lowest)<0) {
				lowest=all.get(i);
			}
		}
		return lowest;
	}

	//strs有所有字符串
	//已经使用过的字符串的下标已经在use里不能再使用
	//之前使用过的字符串拼接成path
	//用all收集所有的拼接结果
	private static void process(String[] strs, HashSet<Integer> use, String path, ArrayList<String> all) {
		if(strs.length==use.size()) {
			all.add(path);
		}else {
			for(int i=0;i<strs.length;i++) {
				if(!use.contains(i)) {
					use.add(i);
					process(strs, use, path+strs[i], all);
					use.remove(i);
				}
			}
		}
	}
	
	public static class MyComparator implements Comparator<String>{

		public int compare(String a, String b) {
			return (a+b).compareTo(b+a);
		}
	}
	
	public static String lowestString2(String[] strs) {
		if(strs.length==0||strs==null) {
			return "";
		}
		//外部比较器：
//		Arrays.sort(strs, new Comparator<String>() {
//			public int compare(String a,String b) {
//				return (a+b).compareTo(b+a);
//			}
//		});
		//lambda表达式法
		Arrays.sort(strs, (String a,String b)->{
			return (a+b).compareTo(b+a);
		});
		String res="";
		for(int i=0;i<strs.length;i++) {
			res+=strs[i];
		}
		return res;
	}

}
