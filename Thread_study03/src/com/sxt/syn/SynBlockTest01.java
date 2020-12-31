package com.sxt.syn;
//取钱     线程安全
public class SynBlockTest01 {
	public static void main(String[] args) {
		Account account=new Account(1000,"彩礼");
		SynDrawing you=new SynDrawing(account,80,"可悲的你");
		SynDrawing she=new SynDrawing(account,90,"快乐的她");
		you.start();
		she.start();
		
	}

}

class SynDrawing extends Thread{
	Account account;//取钱的账户
	int drawingMoney;//取钱的金额
	int packetTotal;//口袋的钱
	
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
		//提高性能
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
		System.out.println(this.getName()+"--->账户余额为"+account.money);
		System.out.println(this.getName()+"--->口袋的钱"+packetTotal);
		super.run();
		}
	}
}