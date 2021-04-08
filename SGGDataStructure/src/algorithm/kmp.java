package algorithm;

import java.util.Arrays;

public class kmp {
	public static void main(String[] args) {
		String str1="BBC ABCDAB ABCDABCDABDE";
		String str2="ABCDABD";
		int[] next=next(str2);
		char[]set= {'A','A','A','A'};
		int[]next2=getArraySelf(set);
		int[]next3=kmpNext("ABCDABD");
		System.out.println(kmpSearch(str1, str2));
//		System.out.println(Arrays.toString(next));
//		System.out.println(Arrays.toString(next2));
//		System.out.println(Arrays.toString(next3));
		
	}
	
	public static int kmpSearch(String str1,String str2) {
		int[]next=next(str2);
		int i=0,j=0;
		for(;i<str1.length();i++) {
			while(j>0&&str1.charAt(i)!=str2.charAt(j)) {
				j=next[j];
			}
			if(str1.charAt(i)==str2.charAt(j)) {
				j++;
			}
			if(j==str2.length()) {
				return i-j+1;
			}
		}
		return -1;
	}
	public  static int[] next(String str2) {
		char[]str=str2.toCharArray();
		int[]next=new int[str2.length()];
		int i=1;
		int j=-1;
		next[0]=-1;next[1]=0;
		while(i<str.length-1) {
			if(j==-1||str[i]==str[j]) {
				next[++i]=++j;
			}else {
				j=next[j];
			}
		}
		return next;
	}
	
	public static int[] getArraySelf(char[] str) {
		if (str.length == 1) {
			return new int[-1];
		}
		int[] next = new int[str.length];
		next[0] = -1;
		int i = 1;
		int j = -1;
		while (i < str.length - 1) {
			if (j == -1 || str[i] == str[j]) {
				i++;
				j++;
				next[i] = j;
			} else {
				j = next[j];
			}
		}
		return next;
	}
	public static int[] kmpNext(String str) {
		int[]next=new int[str.length()];
		next[0]=0;
		for(int i=1,j=0;i<next.length;i++) {
			while(j>0&&str.charAt(i)!=str.charAt(j)) {
				j=next[j-1];
			}
			if(str.charAt(i)==str.charAt(j)) {
				j++;
			}
			next[i]=j;
		}
		return next;
	}
}
