package cn.sxt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestCalendar2 {
	public static void main(String[]aaa) throws ParseException {
		System.out.println("��������Ϣ����ʽlike2020-12-24");
		Scanner scanner=new Scanner(System.in);
		String str=scanner.nextLine();
		//String str="2020-9-10";
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date date=df.parse(str);
		Calendar c=new GregorianCalendar();
		c.setTime(date);
		//System.out.println(date);
		int day=c.get(Calendar.DATE);
		int MAX=c.getActualMaximum(Calendar.DATE);
		
		
		c.set(Calendar.DATE, 1);
		
		System.out.println("��"+"\t"+"һ"+"\t"+"��"+"\t"+"��"+"\t"+"��"+"\t"+"��"+"\t"+"��"+"\t");
		
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
