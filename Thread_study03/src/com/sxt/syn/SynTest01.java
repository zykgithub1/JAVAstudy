package com.sxt.syn;
//���ݲ���ȫ������ͬ�����ݺ͸���
public class SynTest01 {
	public static void main(String[] args) {
		SafeWeb12306 web=new SafeWeb12306();
		System.out.println(Thread.currentThread().getName());
		new Thread(web,"���").start();
		new Thread(web,"��ũ").start();
		new Thread(web,"���").start();
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
	//������
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