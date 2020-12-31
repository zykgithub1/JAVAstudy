package com.sxt.syn;
//数据不安全，有相同的数据和负数
public class SynBlockTest03 {
	public static void main(String[] args) {
		SynWeb12306 web=new SynWeb12306();
		System.out.println(Thread.currentThread().getName());
		new Thread(web,"蚂蝗").start();
		new Thread(web,"码农").start();
		new Thread(web,"马蜂").start();
	}
}
class SynWeb12306 implements Runnable{
	private int ticketNums=10;
	private boolean flag=true;

	@Override
	public void run() {
		while(flag) {
			test1();
		}
	}
	public void test3() {
		synchronized (this) {
			if(ticketNums<0) {
				flag=false;
				return;
			}
		}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"---->"+ticketNums--);
	}
	//try缩小范围
	//double checking
	public void test5() {
		if(ticketNums<0) {//考虑没票的时候：
			flag=false;
			return;
		}
		synchronized (this) {
			if(ticketNums<0) {//考虑没票的时候：
				flag=false;
				return;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"---->"+ticketNums--);

		}
	}
	//锁同步块,范围大性能低
	public void test2() {
		synchronized (this) {
			if(ticketNums<0) {
				flag=false;
				return;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"---->"+ticketNums--);

		}
	}
	//锁方法
	public synchronized void test1() {
		if(ticketNums<0) {
			flag=false;
			return;
		}
		try {
			Thread.sleep(00);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"---->"+ticketNums--);
	}
}