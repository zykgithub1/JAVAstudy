package com.sxt.thread;

//���̣߳���һ�Σ���ʹ��
import java.io.StreamTokenizer;

//�����̷߳�ʽ����
//����Runnable ��дrun
//����������ʵ�������+Thread����start
//
public class LambdaThread{
	//��̬�ڲ���
	static class Test implements Runnable{
		public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("һ��ggg");
		}
	}
	}
	
	public static void main(String[] args) {
		new Thread(new Test()).start();
		//�ֲ��ڲ���
		class Test2 implements Runnable{
			public void run() {
			for(int i=0;i<20;i++) {
				System.out.println("һ��cccc");
			    }
		    }
	    }
		new Thread(new Test2()).start();
		//�����ڲ��ࣺ�������������߽ӿ�ʵ��
		new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<20;i++) {
					System.out.println("һ��ddd");
				    }
			    }
		}).start();
		//jdk8 �� lambda
		new Thread(()-> {
				for(int i=0;i<20;i++) {
					System.out.println("һ��cg");
				    }
			    }
		).start();
		
	}

}
