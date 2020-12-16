package cn.sxt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class SelfTestCalendar {
	public static void main(String[]args) throws ParseException {
		System.out.println("请输入日期，格式like:2020-11-11");
		Scanner scanner=new Scanner(System.in);
		String str=scanner.nextLine();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date date=df.parse(str);
		Calendar c=new GregorianCalendar();
		c.setTime(date);
		
		int MAX=c.getActualMaximum(Calendar.DATE);
		int day=c.get(Calendar.DAY_OF_MONTH);
		
		
		c.set(Calendar.DAY_OF_MONTH, 1);
		
		
		System.out.println("日"+"\t"+"一"+"\t"+"二"+"\t"+"三"+"\t"+"四"+"\t"+"五"+"\t"+"六");
		for(int i=0;i<c.get(Calendar.DAY_OF_WEEK)-1;i++) {
			System.out.print("\t");
		}
		for(int i=1;i<=MAX;i++) {
				if(day==c.get(Calendar.DATE)) {
					System.out.print(c.get(Calendar.DATE)+"*"+"\t");
				}
				else {
					System.out.print(c.get(Calendar.DATE)+"\t");
				}
			
			if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) {
				System.out.println();
			}
			c.add(Calendar.DATE,1);
			
		}
		
		
	}
		
}


