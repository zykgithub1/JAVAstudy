package cn.sxt.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCanlendear {
	public static void main(String[]aaa) {
		Calendar calendar=new GregorianCalendar(2999,11,10,22,11,40);
		int day=calendar.get(Calendar.DAY_OF_MONTH);
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH);
		int weekday=calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(year);
		System.out.println(month);
		System.out.println(weekday);
		System.out.println(day);
		Calendar c1=new GregorianCalendar();
		c1.set(Calendar.YEAR,8888);
		System.out.println(c1);
		Calendar c3=new GregorianCalendar();
		c3.add(Calendar.YEAR,100);
		System.out.println(c3);
		Date d4=c3.getTime();
		Calendar c4=new GregorianCalendar();
		c4.setTime(new Date());
		System.out.println("12212"+c4);
	
	}
	public static void printCalendar(Calendar c) {
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH)+1;
		int date=c.get(Calendar.DAY_OF_MONTH);
		int weekday=c.get(Calendar.DAY_OF_WEEK)-1;
		String dayweek2=weekday==0?"日":weekday+"";
		int hour=c.get(Calendar.HOUR);
		int minute=c.get(Calendar.MINUTE);
		int second=c.get(Calendar.SECOND);
		System.out.println(year+"年"+month+"月"+date+"日"+hour+"时"+minute+"分"+second+"秒");
	}

}
