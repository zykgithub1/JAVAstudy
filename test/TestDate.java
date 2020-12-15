package cn.sxt.test;

import java.util.Date;

public class TestDate {
	public static void main(String[]a) {
		Date d=new Date((long)13960);
		System.out.println(d);
		Date d1=new Date();
		System.out.println(d1);
		Date d2=new Date(2020-1900,12,11);
		System.out.println(d2);
		
	}

}
