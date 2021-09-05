package demo_2021_9_5_;

public class ratateString {
	public static boolean isScramble1(String s1,String s2) {
		if((s1==null&&s2!=null)||(s1!=null&&s2==null)) {
			return false;
		}
		if(s1==null&&s2==null) {
			return true;
		}
		if(s1.equals(s2))return true;
		char[]chs1=s1.toCharArray();
		char[]chs2=s2.toCharArray();
		if(!sameTypeSameCharacter(chs1,chs2))return false;
		int N=s1.length();
		return process(chs1,chs2,0,0,N);
	}

	private static boolean process(char[] chs1, char[] chs2, int s1, int s2, int n) {
		if(n==1) {
			return chs1[s1]==chs2[s2];
		}
		for(int leftPart=1;leftPart<n;leftPart++) {
			if(process(chs1, chs2, s1, s2, leftPart)&&
			process(chs1, chs2, s1+leftPart, s2+leftPart, n-leftPart)||
			process(chs1, chs2, s1, s2+n-leftPart, leftPart)&&
			process(chs1, chs2, s1+leftPart, s2, n-leftPart)			
					) {
				return true;
			}
		}
		return false;
	}

	private static boolean sameTypeSameCharacter(char[] chs1, char[] chs2) {
		if(chs1.length!=chs2.length)return false;
		int[]map=new int[256];
		for(int i=0;i<chs1.length;i++) {
			map[chs1[i]-'0']++;
		}
		for(int i=0;i<chs2.length;i++) {
			map[chs2[i]-'0']--;
		}
		for(int i=0;i<256;i++) {
			if(map[i]!=0)return false;
		}
		return true;
	}
}
