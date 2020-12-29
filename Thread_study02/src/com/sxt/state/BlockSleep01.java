package com.sxt.state;
//£¬Ä£ÄâÍøÂçÑÓÊ±
public class BlockSleep01 {
	public static void main(String[] args) {
		
		Web12306 web=new Web12306();
		System.out.println(Thread.currentThread().getName());
		new Thread(web,"Âì»È").start();
		new Thread(web,"ÂëÅ©").start();
		new Thread(web,"Âí·ä").start();
	}

}
class Web12306 implements Runnable{
	private int ticketNums=99;
	

	@Override
	public void run() {
		while(true) {
			if(ticketNums<0) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"---->"+ticketNums--);
		}
		
	}


}