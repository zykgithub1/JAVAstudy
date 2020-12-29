package com.sxt.state;
//��ֹ�߳�
//1���Լ�ִ�����
//2���ⲿ����====�������־λ
public class TerminateThread implements Runnable{
	private boolean flag=true;
	private String name;
	
	public TerminateThread(String name) {
		super();
		this.name = name;
	}

	public static void main(String[] args) {
		TerminateThread tt=new TerminateThread("C��");
		new Thread(tt).start();
		for(int i=0;i<=99;i++) {
			if(i==88) {
				tt.terminate();
				System.out.println("tt game over");
			}
			System.out.println("main-->"+i);
		}
	}

	@Override
	public void run() {
		int i=0;
		while(flag) {
			System.out.println(name+"----->"+i++);
		}
	}
	public void terminate() {
		this.flag=false;
	}

}
