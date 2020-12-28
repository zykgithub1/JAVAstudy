package com.sxt.thread;
//创建线程方式一：
//集成Thread 重写run
//
public class StartThread extends Thread{
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("一边学习");
		}
	}
	public static void main(String[] args) {
		StartThread st=new StartThread();
		st.start();
		for(int i=0;i<20;i++) {
			System.out.println("一边听歌");
		}
		
	}

}
