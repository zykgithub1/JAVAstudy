package com.sxt.thread;

import java.io.StreamTokenizer;

//�����̷߳�ʽ����
//����Runnable ��дrun
//����������ʵ�������+Thread����start
//
public class StartRun implements Runnable{
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("һ��ѧϰ");
		}
	}
	public static void main(String[] args) {
//		StartRun sr=new StartRun();
//		Thread t=new Thread(sr);
//		t.start();
		//
		new Thread(new StartRun()).start();

		for(int i=0;i<20;i++) {
			System.out.println("һ������");
		}
		
	}

}
