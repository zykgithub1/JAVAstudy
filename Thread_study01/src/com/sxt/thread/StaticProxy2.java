package com.sxt.thread;

public class StaticProxy2 {
	public static void main(String[] args) {
		new WeddingCompan(new You1()).happyMarry();
	}

}
interface Marry1{
	void happyMarry();
}
class You1 implements Marry{

	@Override
	public void happyMarry() {
		System.out.println("youyouyou soulmate");
	}
}
class WeddingCompan implements Marry{
	private Marry target;
	public WeddingCompan (Marry target) {
		this.target=target;
	}

	@Override
	public void happyMarry() {
		ready();
		this.target.happyMarry();
		after();
		
	}
	private void ready() {
		System.out.println("布置房间和灰常");
	}
	private void after() {
		System.out.println("抢红包");
	}
	
	
}