package com.sxt.thread;
//加入返回值：

public class LambdaTest04 {

	public static void main(String[] args) {
		new Thread(()->{
			for(int i=0;i<20;i++) {
				System.out.println("一边学习lanbda");
			}
		}).start();
		new Thread(()->{
			System.out.println("一边崩溃中");
		}).start();
	
	}
	

}
