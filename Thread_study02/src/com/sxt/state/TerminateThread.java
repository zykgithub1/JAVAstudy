package com.sxt.state;
//终止线程
//1，自己执行完毕
//2，外部干涉====》加入标志位
public class TerminateThread implements Runnable{
	private boolean flag=true;
	private String name;
	
	public TerminateThread(String name) {
		super();
		this.name = name;
	}

	public static void main(String[] args) {
		TerminateThread tt=new TerminateThread("C罗");
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
