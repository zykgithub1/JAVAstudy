package com.sxt.others;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

//������Ƚ���Timer ��TimerTask��
public class TimerTest01 {
	public static void main(String[] args) {
		Timer timer=new Timer();
		//ִ�а��ţ�
		//timer.schedule(new MyTask(), 1000);ִ��һ������
		//timer.schedule(new MyTask(), 1000,2000);ִ�ж��
		Calendar cal=new GregorianCalendar();
		timer.schedule(new MyTask(), cal.getTime(),1000);
		//System.out.println(cal.getTime());
	}

}
//�����ࣺ���߳�
class MyTask extends TimerTask{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("�ſմ�����Ϣһ��");
		}
		System.out.println("end");
	}
	
}