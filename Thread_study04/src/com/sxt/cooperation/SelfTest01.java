package com.sxt.cooperation;

public class SelfTest01 {
	public static void main(String[] args) {
		Tv1 tv=new Tv1();
		new Player1(tv).start();
		new Watcher1(tv).start();
	}
}
class Player1 extends Thread{
	Tv1 tv;
	public Player1(Tv1 tv) {
		this.tv = tv;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			if(i%2==0) {
				this.tv.play("奇葩说");
			}else {
				this.tv.play("太污了，河口立白");
			}
		}
	}	
}
class Watcher1 extends Thread{
	Tv1 tv;
	public Watcher1(Tv1 tv) {
		this.tv = tv;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			this.tv.watch();
		}
	}	
}
class Tv1{
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
		System.out.println("表演了:"+voice);
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
		System.out.println("听到了:"+voice);
		this.notifyAll();
		this.flag=!this.flag;
		
	}
	
}