package cn.sxt.test;

public class TestString {
	public static void main(String[]a) {
		String str="aabbccdddd";
		String str2=str.substring(2,5);
		System.out.println(str2);
		System.out.println(Integer.toHexString(str.hashCode()));
		System.out.println(Integer.toHexString(str2.hashCode()));
		System.out.println(str.equals(str2));
	}

}
