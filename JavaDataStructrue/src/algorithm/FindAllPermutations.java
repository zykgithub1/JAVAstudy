package algorithm;

import java.util.ArrayList;
//’“»´≈≈ 

public class FindAllPermutations {
	static int count=0;
	public static void main(String[] args) {
		ArrayList<String> list=permutation("zzyk");
		System.out.println(list.toString());
		System.out.println(count);
	}
	
	public static ArrayList<String> permutation(String str){
		ArrayList<String> res=new ArrayList<>();
		if(str==null||str.length()==0) {
			return res;
		}
		char[] chs=str.toCharArray();
		process1(chs,0,res);
		return res;
		
	}

	private static void process(char[] str, int i, ArrayList<String> ans) {
		if(i==str.length) {
			count++;
			ans.add(String.valueOf(str));
		}
		for(int j=i;j<str.length;j++) {
			
			swap(str,i,j);
			process(str, i+1, ans);
			swap(str, i, j);
		}
	}
	//ºÙ÷¶ ∞Ê±æ
	private static void process1(char[] str, int i, ArrayList<String> ans) {
		if(i==str.length) {
			ans.add(String.valueOf(str));
			count++;
			return;
		}
		boolean[] visited=new boolean[26];
		for(int j=i;j<str.length;j++) {
			if(!visited[str[j]-'a']) {
				visited[str[j]-'a']=true;
				swap(str, i, j);
				process1(str, i+1, ans);
				swap(str, i, j);
			}
		}
	}

	public static void swap(char[] str, int i, int j) {
		if(i>=0&&j>=0&&i<=str.length&&j<=str.length) {
			char tmp=str[i];
			str[i]=str[j];
			str[j]=tmp;
		}
	}

}
