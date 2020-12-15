package cn.sxt.test;

public class TestStringBuilder3 {
	public static void main(String[]args) {
//		String str1="";
//		long num1=Runtime.getRuntime().freeMemory();
//		long time1=System.currentTimeMillis();
//		for(int i=0;i<5000;i++) {
//			str1 =str1+i;
//		}
//		
//		long num2=Runtime.getRuntime().freeMemory();
//		long time2=System.currentTimeMillis();
//		System.out.println("String占用内存："+(num1-num2));
//		System.out.println("String占用时间："+(time2-time1)+"mm");
//		System.out.println(str1);
		
		StringBuilder sb=new StringBuilder("");
		long num3=Runtime.getRuntime().freeMemory();
		long time3=System.currentTimeMillis();
		for(int i=0;i<5000;i++) {
			sb.append(i);	
		}
		long num4=Runtime.getRuntime().freeMemory();
		long time4=System.currentTimeMillis();
		//System.out.println("Stringbuider占用内存："+(num3-num2));
		System.out.println("Stringbuilder占用时间："+(time4-time3)+"mm");
		System.out.println(sb);
	}

}
