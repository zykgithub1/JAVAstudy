package algorithm;

public class test {
	public static void main(String[] args) {
		String s1="30";
		String s2="3";
		String s3="4";
		System.out.println(s1.compareTo(s2));
		System.out.println(s2.compareTo(s1));
		System.out.println(s3.compareTo(s2));
		System.out.println((s2+s1).compareTo(s1+s2));
		System.out.println((s1+s2).compareTo(s2+s1));
		System.out.println(s1.length());
	}

}
