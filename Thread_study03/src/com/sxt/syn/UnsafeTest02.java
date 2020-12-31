package com.sxt.syn;
//取钱     线程不安全
public class UnsafeTest02 {
	public static void main(String[] args) {
		Account account=new Account(100,"彩礼");
		Drawing you=new Drawing(account,80,"可悲的你");
		Drawing she=new Drawing(account,90,"快乐的她");
		you.start();
		she.start();
		
	}

}
class Account{
	int money;
	String name;
	public Account(int money,String name) {
		this.money=money;
		this.name=name;
	}
}
class Drawing extends Thread{
	Account account;//取钱的账户
	int drawingMoney;//取钱的金额
	int packetTotal;//口袋的钱
	
	public Drawing(Account account, int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		if(account.money-drawingMoney<0) {
			return;
		}
		try {
			Thread.sleep(1000);
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