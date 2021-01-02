package com.sxt.cooperation;

import java.lang.reflect.Constructor;

//������������ģ�ͣ�ʵ�ַ�ʽ1���̷ܳ�
//��������
public class CoTest01 {
	public static void main(String[] args) {
		SynContainer1 container=new SynContainer1();
		new Productor1(container).start();
		new Consumer1(container).start();
	}

}
//������
class Productor1 extends Thread{
	SynContainer1 container;	
	public Productor1(SynContainer1 container) {
		this.container = container;
	}

	@Override//��ʼ����
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("������----��"+i+"����ͷ");
			container.push(new Steamedbun1(i));
		}
		
		
	}
}
//������
class Consumer1 extends Thread{
	SynContainer1 container;	
	public Consumer1(SynContainer1 container) {
		this.container = container;
	}
	@Override//��ʼ����
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("���ѵ�---��"+container.pop().id+"����ͷ");
		}
		
	}
}
//������
class SynContainer1{
	Steamedbun1[] buns=new Steamedbun1[10];
	int count=0;
	//�洢����
	public synchronized void push(Steamedbun1 bun) {
		//��ʱ��������  �������ڿռ�ʱ��
		
		//��������
		if(count==buns.length) {
			try {
				this.wait();//�߳�������������֪ͨ����  ������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//���ڿռ����������
		buns[count]=bun;
		count++;
	}
	//��ȡ ����
	public synchronized Steamedbun1 pop(){
		//��ʱ�����ѣ��������Ƿ��������
		//û������ֻ�еȴ�
		if(count==0) {
			try {
				this.wait();//��ʱ�߳��������ȴ�������֪ͨ��������
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}else {
			//�������ݿ�������
		count--;
		this.notifyAll();//���ڿռ��˿��Ի��ѶԷ�������

		}
		Steamedbun1 bun=buns[count];
		return bun;
		
		
	}
	
	
	
}
//���ݣ���ͷ��
class Steamedbun1{
	int id;

	public Steamedbun1(int id) {
		this.id = id;
	}
	
}