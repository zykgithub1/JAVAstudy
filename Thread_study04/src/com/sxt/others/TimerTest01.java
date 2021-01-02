package com.sxt.others;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

//任务调度借助Timer 和TimerTask类
public class TimerTest01 {
	public static void main(String[] args) {
		Timer timer=new Timer();
		//执行安排：
		//timer.schedule(new MyTask(), 1000);执行一次任务
		//timer.schedule(new MyTask(), 1000,2000);执行多次
		Calendar cal=new GregorianCalendar();
		timer.schedule(new MyTask(), cal.getTime(),1000);
		//System.out.println(cal.getTime());
	}

}
//任务类：多线程
class MyTask extends TimerTask{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("放空大脑休息一会");
		}
		System.out.println("end");
	}
	
}