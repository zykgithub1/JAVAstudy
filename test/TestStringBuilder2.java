package cn.sxt.test;

public class TestStringBuilder2 {
	public static void main(String[]a) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<26;i++) {
			sb.append((char)('a'+i));
			
		}
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		sb.setCharAt(3,'��');
		System.out.println(sb);
		sb.insert(0, '��').insert(0,'һ').insert(2, '��');
		System.out.println(sb);
		sb.delete(0,3);
		System.out.println(sb);
	}

}
