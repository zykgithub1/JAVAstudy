package com.sxt.syn;
//ȡǮ     �̰߳�ȫ
public class SynTest02 {
	public static void main(String[] args) {
		Account account=new Account(100,"����");
		SafeDrawing you=new SafeDrawing(account,80,"�ɱ�����");
		SafeDrawing she=new SafeDrawing(account,90,"���ֵ���");
		you.start();
		she.start();
		
	}

}

class SafeDrawing extends Thread{
	Account account;//ȡǮ���˻�
	int drawingMoney;//ȡǮ�Ľ��
	int packetTotal;//�ڴ���Ǯ
	
	public SafeDrawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		test();
	}
	public void test() {
		if(account.money-drawingMoney<0) {
			return;
		}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		account.money-=drawingMoney;
		packetTotal+=drawingMoney;
		System.out.println(this.getName()+"--->�˻����Ϊ"+account.money);
		System.out.println(this.getName()+"--->�ڴ���Ǯ"+packetTotal);
		super.run();
	}
}