package com.sxt.thread;
//���뷵��ֵ��

public class LambdaTest04 {

	public static void main(String[] args) {
		new Thread(()->{
			for(int i=0;i<20;i++) {
				System.out.println("һ��ѧϰlanbda");
			}
		}).start();
		new Thread(()->{
			System.out.println("һ�߱�����");
		}).start();
	
	}
	

}
