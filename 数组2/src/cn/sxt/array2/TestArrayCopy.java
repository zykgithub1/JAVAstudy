package cn.sxt.array2;

public class TestArrayCopy {
	public static void main(String[]a) {
		String[] str= {"阿里","京东","淘宝","百度","亚马逊"};
		//testCopy3(str,1);
		str=chaiRu(str,3);
		
	}
	public static void testCopy() {
		String[] s1= {"aa","bb","cc","dd","ee"};
		String[] s2=new String[10];
		System.arraycopy(s1, 2, s2,6,3);
		for(int i=0;i<s2.length;i++) {
			System.out.println(i+"---"+s2[i]);
		}
	}
	public static void testCopy2() {
		String[] s1= {"aa","bb","cc","dd","ee"};
		//String[] s2=new String[10];
		System.arraycopy(s1, 3, s1,3-1,s1.length-3);
		for(int i=0;i<s1.length;i++) {
			System.out.println(i+"---"+s1[i]);
		}
	}
	public static String[] testCopy3(String[] s,int index) {
		//String[] s1= {"aa","bb","cc","dd","ee"};
		//String[] s2=new String[10];
		System.arraycopy(s, index+1,s,index,s.length-index-1);
		s[s.length-1]=null;
		for(int i=0;i<s.length;i++) {
			System.out.println(i+"---"+s[i]);
		}
		return s;
	}
	public static  String[] extendRange(String[] s) {
		//String[] s1= {"aa","bb","cc"};
		String[] s1=new String[s.length+10];
		System.arraycopy(s,0,s1,0,s.length);
		for(String a:s1) {
			System.out.println(a);
		}
		return s1;
	}
	public static String[] chaiRu(String[] s,int index) {
		String[] s1=new String[s.length+10];
		System.arraycopy(s, index-1, s1, index, s.length-1);
		for(String a:s1) {
			System.out.println(a);
		}
		return s1;
		
	}
}

