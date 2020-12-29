package com.sxt.state;

//��ģ��������ʱ
public class BlockSleep02 {
	public static void main(String[] args) {
		Racer racer=new Racer();
		new Thread(racer,"tortoise").start();
		new Thread(racer,"rabbit").start();
	}

}
class Racer implements Runnable{
	private String winner;

	@Override
	public void run() {
		for(int steps=1;steps<=100;steps++) {
			if(Thread.currentThread().getName().equals("rabbit")&&steps%30==0) {
				try {
					Thread.sleep(110);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"---->"+steps);
			//�����Ƿ����
			boolean flag=gameOver(steps);
			if(flag) {
				break;
			}
		}
	}
	private boolean gameOver(int steps) {
		if(winner!=null) {
			return true;
		}else {
			if(steps==100) {
				winner=Thread.currentThread().getName();
				System.out.println("ʤ������-----��"+winner);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Racer racer=new Racer();
		new Thread(racer,"tortoise").start();
		new Thread(racer,"rabbit").start();
	}

}
