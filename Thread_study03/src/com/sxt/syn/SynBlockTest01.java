package com.sxt.syn;
//ȡǮ     �̰߳�ȫ
public class SynBlockTest01 {
	public static void main(String[] args) {
		Account account=new Account(1000,"����");
		SynDrawing you=new SynDrawing(account,80,"�ɱ�����");
		SynDrawing she=new SynDrawing(account,90,"���ֵ���");
		you.start();
		she.start();
		
	}

}

class SynDrawing extends Thread{
	Account account;//ȡǮ���˻�
	int drawingMoney;//ȡǮ�Ľ��
	int packetTotal;//�ڴ���Ǯ
	
	public SynDrawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		test();
	}
	public void test() {
		//�������
		if(account.money<=0) {
			return;
		}
		synchronized (account) {
		if(account.money-drawingMoney<0) {
			return;
		}
		try {
			Thread.sleep(200);
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
}