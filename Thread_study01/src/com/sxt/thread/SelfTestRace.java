package com.sxt.thread;

public class SelfTestRace implements Runnable{
	private String winner;

	@Override
	public void run() {
		for(int steps=1;steps<=100;steps++) {
			System.out.println(Thread.currentThread().getName()+"--->"+steps+"zzzz");
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
				System.out.println("Ê¤ÀûÕßÊÇ-------->"+winner);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		SelfTestRace str=new SelfTestRace();
		new Thread(str,"tortoise").start();
		new Thread(str,"rabbit").start();
	}

}
