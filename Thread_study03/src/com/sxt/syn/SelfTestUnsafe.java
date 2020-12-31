package com.sxt.syn;

public class SelfTestUnsafe {
	public static void main(String[] args) {
		Account1 account=new Account1(100,"存款");
		Drawing1 you=new Drawing1(account, 99,"happyme");
		Drawing1 she=new Drawing1(account, 88,"sadshe");
		you.start();
		she.start();
	}

}
class Account1{
	int money;
	String name;
	public Account1(int money, String name) {
		super();
		this.money = money;
		this.name = name;
	}
}

class Drawing1 extends Thread{
	Account1 account;
	int drawingMoney;
	int packetMoney;
	
	public Drawing1(Account1 account, int drawingMoney,String name) {
		super(name);
		this.account= account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		account.money-=drawingMoney;
		packetMoney+=drawingMoney;
		System.out.println(this.getName()+"账户余额为----》"+account.money);
		System.out.println(this.getName()+"口袋的钱是----》"+packetMoney);
	}
}