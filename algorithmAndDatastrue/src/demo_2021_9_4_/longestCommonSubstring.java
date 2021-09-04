package demo_2021_9_4_;

public class longestCommonSubstring {
	public static void main(String[] args) {
		String s1="ace";
		String s2="dfr";
		System.out.println(getMaxLen(s1, s2));
	}
	public static int getMaxLen(String s1,String s2) {
		return process(s1.toCharArray(),s2.toCharArray(),0,0);
	}

	private static int process(char[] s1, char[] s2, int x, int y) {
		if(x==s1.length) {
			return 0;
		}
		if(y==s2.length) {
			return 0;
		}
		if(s1[x]==s2[y]) {
			return 1+process(s1, s2, x+1, y+1);
		}else {
			return process(s1, s2, x+1, y);
		}
	}
	

}
