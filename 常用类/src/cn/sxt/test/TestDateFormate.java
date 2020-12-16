package cn.sxt.test;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormate {
	public static void main(String[]aaa) throws ParseException {
		DateFormat df=new SimpleDateFormat("yyyy年MM月dd日hh-mm-ss");
		String str=df.format(new Date());
		System.out.println(str);
		
		
		DateFormat df2=new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
		Date date=df2.parse("1983年05月10日 10时45分23秒");
		System.out.println(date);
		//Date date2=new Date();
		//System.out.println(date2);
		DateFormat df3=new SimpleDateFormat("m");
		String str3=df3.format(new Date());
	
		//System.out.print(str3);
		
	}

}
