package com.sxt.syn;
//数据不安全，有相同的数据和负数
public class SynTest01 {
	public static void main(String[] args) {
		SafeWeb12306 web=new SafeWeb12306();
		System.out.println(Thread.currentThread().getName());
		new Thread(web,"蚂蝗").start();
		new Thread(web,"码农").start();
		new Thread(web,"马蜂").start();
	}

}
class SafeWeb12306 implements Runnable{
	private int ticketNums=1000;
	private boolean flag=true;

	@Override
	public void run() {
		while(flag) {
			test();
		}
	}
	//锁方法
	public synchronized void test() {
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