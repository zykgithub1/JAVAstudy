package com.sxt.cooperation;

public class Cotest01again {
	public static void main(String[] args) {
		SynContainer11 container=new SynContainer11();
		new Productor11(container).start();
		new Consumer111(container).start();
	}

}
class Productor11 extends Thread{
	SynContainer11 container;
	public Productor11(SynContainer11 container) {
		this.container = container;
	}

	@Override//��ʼ������
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("����--��"+i+"����ͷ");
			container.push(new Steamedbun111(i));
		}
		
	}
}
class Consumer111 extends Thread{
	SynContainer11 container;
	public Consumer111(SynContainer11 container) {
		this.container = container;
	}
	@Override//��ʼ����
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println("����--��"+container.pop().id+"����ͷ");
			container.push(new Steamedbun111(i));
		}
		
	}
}
//������
class SynContainer11{
	Steamedbun111[] buns=new Steamedbun111[10];
	int count=0;
	//����
	public synchronized void push(Steamedbun111 bun) {
		
		buns[count]=bun;
		count++;
	}
	//���� ��ȡ
	public Steamedbun111 pop() {
		count--;
		Steamedbun111 bun=buns[count];
		return bun;
	}
}
class Steamedbun111{
	int id;

	public Steamedbun111(int id) {
		this.id = id;
	}
	
}