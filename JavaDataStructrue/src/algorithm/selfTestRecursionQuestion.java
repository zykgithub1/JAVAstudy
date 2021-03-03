package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class selfTestRecursionQuestion {
	public static void main(String[] args) {
		//test1Reverse();
		//test2FindAllSubs();
		//test3FindDiffierentSub();
		//test4FindPermutations();
		//test5FindPermutations();
	}
	public static void test5FindPermutations() {
		String str="aabc";
		char[] chs=str.toCharArray();
		List<String> res=new ArrayList<>();
		process1(chs,0,res);
		for(String cur:res) {
			System.out.println(cur);
		}
	}
	
	private static void process1(char[] chs, int i, List<String> res) {
		if(i==chs.length) {
			res.add(String.valueOf(chs));
			return;
		}
		boolean[] visited=new boolean[26];
		for(int j=i;j<chs.length;j++) {
			if(!visited[chs[j]-'a']) {
				visited[chs[j]-'a']=true;
				FindAllPermutations.swap(chs, i, j);
				process1(chs, i+1, res);
				FindAllPermutations.swap(chs, i, j);
			}
		}
	}
	public static void test3FindDiffierentSub() {
		String str="aabc";
		char[] chs=str.toCharArray();
		String path="";
		List<String> res=new ArrayList<>();
		HashSet<String> set=new HashSet<>();
		FindAllDiffirentSub(chs,0,set,path);
		for(String cur:set) {
			System.out.println(cur);
		}
	}
	public static void test4FindPermutations() {
		String str="aabc";
		char[] chs=str.toCharArray();
		List<String> res=new ArrayList<>();
		process(chs,0,res);
		for(String cur:res) {
			System.out.println(cur);
		}
	}
	private static void process(char[] chs, int i, List<String> res) {
		if(i==chs.length) {
			res.add(String.valueOf(chs));
			return;
		}
		for(int j=i;j<chs.length;j++) {
			FindAllPermutations.swap(chs, i, j);
			process(chs, i+1, res);
			FindAllPermutations.swap(chs, i, j);
			
		}
	}

	private static void FindAllDiffirentSub(char[] chs, int i, HashSet<String> set, String path) {
		if(i==chs.length) {
			set.add(path);
			return;
		}
		String no=path;
		FindAllDiffirentSub(chs, i+1, set, no);
		String yes=path+String.valueOf(chs[i]);
		FindAllDiffirentSub(chs, i+1, set, yes);
		
	}

	public static void test2FindAllSubs() {
		String str="aabc";
		char[] chs=str.toCharArray();
		String path="";
		List<String> res=new ArrayList<>();
		FindAllSub(chs,0,res,path);
		for(String cur:res) {
			System.out.println(cur);
		}
		
	}
	
	private static void FindAllSub(char[] chs, int i, List<String> res, String path) {
		if(i==chs.length) {
			res.add(path);
			return ;
		}
		String no=path;
		FindAllSub(chs, i+1, res, no);
		String yes=path+String.valueOf(chs[i]);
		FindAllSub(chs, i+1, res, yes);
	}


	public static void test1Reverse() {
		Stack<Integer> stack=new Stack<>();
		for(int i=1;i<=4;i++) {
			stack.push(i);
		}
		for(int cur:stack) {
			System.out.print(cur);
		}
		System.out.println();
		reverse(stack);
		for(int cur:stack) {
			System.out.print(cur);
		}
		System.out.println();
	}
	
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int i=func(stack);
		reverse(stack);
		stack.push(i);
	}

	private static int func(Stack<Integer> stack) {
		int result=stack.pop();
		if(stack.isEmpty()) {
			return result;
		}
		else {
			int last=func(stack);
			stack.push(result);
			return last;
		}
	}
	
	
	

}
