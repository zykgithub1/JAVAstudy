package com.sxt.thread;

public class StaticProxy {

	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();
	
}
}
interface Marry{
	void happyMarry();
}
class You implements Marry{

	@Override
	public void happyMarry() {
		System.out.println("you and me");
	}
}
class WeddingCompany implements Marry{
	private Marry target;
	public WeddingCompany(Marry target) {
		this.target=target;
	}

	@Override
	public void happyMarry() {
		ready();
		this.target.happyMarry();
		after();
		
	}
	private void ready() {
		System.out.println("²¼ÖÃ·¿¼ä");
	}

     private void after() {
		System.out.println("ÄÖÄÖ");
	}
	
}