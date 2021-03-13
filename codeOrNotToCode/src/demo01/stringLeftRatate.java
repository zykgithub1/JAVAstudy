package demo01;

public class stringLeftRatate {
	public static void main(String[] args) {
		String s="abcdefg";
		System.out.println(s.substring(2, s.length())+s.substring(0, 2));
		System.out.println(20%15);
		System.out.println(reverseLeftWords2(s, 2));
		String ss=String.valueOf(s.toCharArray(), 0, s.length());
		System.out.println(ss);
//		String ans=reverseLeftWords(s, 2);
//		System.out.println(ans);
		
		
	}
	
	
	public static String reverseLeftWords(String s, int n) {
		StringBuffer sb=new StringBuffer();
		for(int i=n;i<s.length();i++) {
			sb.append(s.toCharArray()[i]);
		}
		for(int i=0;i<n;i++) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	public static String reverseLeftWords2(String s, int n) {
		String res="";
		for(int i=n;i<n+s.length();i++) {
			res+=s.charAt(i%s.length());
		}
		return res;
		
	}

}
