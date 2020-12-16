package cn.sxt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar3 {
	public static void main(String[]arss) throws ParseException {
		String str="2020-12-30";
		DateFormat df=new SimpleDateFormat("yyyy-mm-dd");
		Date date=df.parse(str);
		//System.out.println(date);
		Calendar c=new GregorianCalendar();
		c.setTime(new Date());
		c.set(Calendar.DATE, 1);
		
		System.out.println("日"+"\t"+"一"+"\t"+"二"+"\t"+"三"+"\t"+"四"+"\t"+"五"+"\t"+"六");
		for(int i=0;i<c.get(Calendar.DAY_OF_WEEK);i++) {
			System.out.print("\t");
		}
		for(int i=0;i<=c.getActualMaximum(Calendar.DATE);i++) {
			System.out.print(c.get(Calendar.DATE)+"\t");
			
			c.add(Calendar.DATE, 1);
			if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) {
				System.out.println();
			}
				
		}
		
	}

}
