package com.sxt.cooperation;

public class SelfTest03 {
	public static void main(String[] args) {
		Tv2 tv=new Tv2();
		new Player2(tv).start();
		new Watcher2(tv).start();
	}

}
class Player2 extends Thread{
	Tv2 tv;
	
	public Player2(Tv2 tv) {
		this.tv = tv;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			if(i%2==0) {
				this.tv.play("奇葩说");
			}else {
				this.tv.play("最强大脑");
			}
		}

	}
}
class Watcher2 extends Thread{
	Tv2 tv;
	
	public Watcher2(Tv2 tv) {
		this.tv = tv;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			this.tv.watch();
		}

	}
}
class Tv2{
	String voice;
	boolean flag=true;
	
	public synchronized void play(String voice) {
		if(!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("表演了"+voice);
		this.voice=voice;
		this.notifyAll();
		this.flag=!this.flag;
	}
	public synchronized void watch() {
		if(flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("听到了"+voice);
		this.notifyAll();
		this.flag=!this.flag;
	}
}