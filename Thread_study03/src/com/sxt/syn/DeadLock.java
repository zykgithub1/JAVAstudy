package com.sxt.syn;
//����������ͬ������������໥���ͷ���Դ���Ӷ��໥�ȴ���һ�㷢����ͬ���г��ж�����������

public class DeadLock {
	public static void main(String[] args) {
		Markup g1=new Markup(1,"�Ű�֥");
		Markup g2=new Markup(2,"����");
		g1.start();
		g2.start();
	}

}

class Lipstick{
	
}
class Mirror{
	
}
class Markup extends Thread{
	static Lipstick lipstick=new Lipstick();
	static Mirror mirror=new Mirror();
	int choise;
	String girl;
	public Markup(int choise,String girl) {
		super();
		this.choise = choise;
		this.girl=girl;
	}

	@Override
	public void run() {
		//��ױ
		markup();
	}
	//�໥���жԷ��Ķ�����
	private void markup() {
		if(choise==0) {
			synchronized (lipstick) {//��ÿں����
				System.out.println(this.girl+"Ϳ�ں�");
				//һ�����ӵ�о��ӵ���
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (mirror) {
					System.out.println(this.girl+"�վ���");
				}
			}
		}else {			
			synchronized (mirror) {//��ÿں����
			System.out.println(this.girl+"�վ���");
			//2�����Ϳ�ں�
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lipstick) {
				System.out.println(this.girl+"Ϳ�ں�");
			}
		}
			
		}
	}
}