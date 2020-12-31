package com.sxt.syn;
//���ݲ���ȫ������ͬ�����ݺ͸���
public class SynBlockTest03 {
	public static void main(String[] args) {
		SynWeb12306 web=new SynWeb12306();
		System.out.println(Thread.currentThread().getName());
		new Thread(web,"���").start();
		new Thread(web,"��ũ").start();
		new Thread(web,"���").start();
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
	//try��С��Χ
	//double checking
	public void test5() {
		if(ticketNums<0) {//����ûƱ��ʱ��
			flag=false;
			return;
		}
		synchronized (this) {
			if(ticketNums<0) {//����ûƱ��ʱ��
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
	//��ͬ����,��Χ�����ܵ�
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
	//������
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