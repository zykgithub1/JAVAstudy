package com.sxt.syn;

public class SelfTestCinema {
	public static void main(String[] args) {
		Cinemaa c=new Cinemaa(20,"happyCinema");
		new Thread(new Customers(2,c),"zyk").start();
		new Thread(new Customers(1,c),"dww").start();
	}

}
class Cinemaa{
	int available;
	String name;
	public Cinemaa(int available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	public boolean bookTickets(int seats) {
		System.out.println("可用位置为"+available);
		if(seats>available) {
			return false;
		}
		available-=seats;
		return true;
	}
}
class Customers implements Runnable{
	int seats;
	Cinemaa cinema;
	

	public Customers(int seats, Cinemaa cinemaa) {
		super();
		this.seats = seats;
		this.cinema = cinemaa;
	}



	@Override
	public void run() {
		synchronized (cinema) {
			boolean flag=cinema.bookTickets(seats);
		if(flag) {
			System.out.println("出票成功"+Thread.currentThread().getName()+"-》位置为"+seats);
		}else {
			System.out.println("出票失败"+Thread.currentThread().getName()+"-》位置不够");
		}
		}
		
		
	}
	
}