package cn.sxt.test;

public class TestStringBuilder {
	public static void main(String[]args) {
		StringBuilder sb=new StringBuilder("abcdefg");
		System.out.println(Integer.toHexString(sb.hashCode()));
		System.out.println(sb);
		sb.setCharAt(2, 'M');
		System.out.println(Integer.toHexString(sb.hashCode()));
		System.out.println(sb);
		
	}

}
