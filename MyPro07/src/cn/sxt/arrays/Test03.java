package cn.sxt.arrays;

public class Test03 {
	public static void main(String[]a) {
		int[] a1=new int[4];
		for(int i=0;i<a1.length;i++) {
			a1[i]=100*i;
		}
		for(int i=0;i<a1.length;i++) {
			System.out.println(a1[i]);
		}
		System.out.println("=============================");
		
		for(int m:a1) {
			System.out.println(m);
		}
		String[] ss= {"aaa","vvv","ccc"};
		for(String aaa:ss) {
			System.out.print(aaa);
			System.out.println(aaa);
		}
		
		
		
	}
	

}
