package com.sxt.thread;

import java.io.StreamTokenizer;

//创建线程方式二：
//创建Runnable 重写run
//启动：创建实现类对象+Thread对象start
//
public class StartRun implements Runnable{
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("一边学习");
		}
	}
	public static void main(String[] args) {
//		StartRun sr=new StartRun();
//		Thread t=new Thread(sr);
//		t.start();
		//
		new Thread(new StartRun()).start();

		for(int i=0;i<20;i++) {
			System.out.println("一边听歌");
		}
		
	}

}
