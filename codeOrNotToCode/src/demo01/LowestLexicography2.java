package demo01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LowestLexicography2 {
	public static void main(String[] args) {
		String[] arr= {"zyk","cnm","apf","ntl","bta","cre"};
		String ans=bruteWay(arr);
		System.out.println(ans);
		System.out.println(easyWay(arr));
		int arrLen=5;
		int strLen=5;
		int times=100;
		
		
		for(int i=0;i<times;i++) {
			String[] res=generateRandomArray(arrLen, strLen);
			System.out.println(Arrays.toString(res));
			String[] res2=res.clone();
			System.out.println(Arrays.toString(res2));
		}
		for(int i=0;i<times;i++) {
			String[] strs=generateRandomArray(arrLen,strLen);
			String[] strs2=StringArraysCopy(strs);
			if(!bruteWay(strs).equals(easyWay(strs2))) {
				System.out.println("Opos!!");
			}
		}
		System.out.println("final!");
	}
	private static String[] StringArraysCopy(String[] strs) {
		String[] res=new String[strs.length];
		for(int i=0;i<strs.length;i++) {
			res[i]=strs[i];
		}
		return res;
	}

	private static String[] generateRandomArray(int arrLen, int strLen) {
		String[] res=new String[(int)(Math.random()*arrLen)+1];
		for(int i=0;i<res.length;i++) {
			res[i]=generateRandomStr(strLen);
		}
		return res;
	}
	
	public static String generateRandomStr(int arrLen) {
		char[] res=new char[(int)(Math.random()*arrLen)+1];
		for(int i=0;i<res.length;i++) {
			int value=(int)(Math.random()*26);
			res[i]=(char)(97+value);
		}
		return String.valueOf(res);
	}

	public static String bruteWay(String[] strs) {
		if(strs.length==0||strs==null) {
			return "";
		}
		ArrayList<String> all=new ArrayList();
		HashSet<Integer> use=new HashSet<>();
		process(strs,all,use,"");
		String lowest=all.get(0);
		for(int i=1;i<all.size();i++) {
			if(all.get(i).compareTo(lowest)<0) {
				lowest=all.get(i);
			}
		}
		return lowest;
	}

	private static void process(String[] strs, ArrayList<String> all, HashSet<Integer> use, String path) {
		if(use.size()==strs.length) {
			all.add(path);
		}else {
			for(int i=0;i<strs.length;i++) {
				if(!use.contains(i)) {
					use.add(i);
					process(strs, all, use, path+strs[i]);
					use.remove(i);
				}
			}
		}
	}
	public static class myComparetor  implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return (o1+o2).compareTo(o2+o1);
		}
		
	}
	public static String easyWay(String[] strs) {
		if(strs.length==0||strs==null) {
			return "";
		}
		String res="";
//		Arrays.sort(strs, (String a,String b)->{
//			return (a+b).compareTo(b+a);
//		});
		Arrays.sort(strs,new myComparetor());
		for(int i=0;i<strs.length;i++) {
			res+=strs[i];
		}
		return res;
	}
}
