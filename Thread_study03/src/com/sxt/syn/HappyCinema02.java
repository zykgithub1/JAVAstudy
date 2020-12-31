package com.sxt.syn;

import java.util.ArrayList;
import java.util.List;

public class HappyCinema02 {
	public static void main(String[] args) {
		//可用位置
		List<Integer> available=new ArrayList<Integer>();
		available.add(1);
		available.add(2);
		available.add(3);
		available.add(6);
		available.add(7);
		List<Integer> seats1=new ArrayList<Integer>();
		seats1.add(1);
		seats1.add(2);
		List<Integer> seats2=new ArrayList<Integer>();
		seats2.add(3);
		seats2.add(6);
		seats2.add(7);
		SxtCinema c=new SxtCinema(available,"happy sxt");
		new Thread(new HappyCustomer(c,seats1),"老高").start();
		new Thread(new HappyCustomer(c,seats2),"老裴").start();
	}

}

class HappyCustomer implements Runnable{
	SxtCinema cinema;
	List<Integer> seats;
	

	public HappyCustomer(SxtCinema cinema, List<Integer> seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}


	@Override
	public void run() {
		synchronized (cinema) {
			boolean flag=cinema.bookTickets(seats);
		if(flag) {
			System.out.println("出票成功"+Thread.currentThread().getName()+"----位置为"+seats);
		}else {
			System.out.println("出票失败"+Thread.currentThread().getName()+"-》位置不够");
		}
		}
		
	}
}



class SxtCinema{
	List<Integer> available;//可用的位置
	String name;
	public SxtCinema(List<Integer> available,String name) {
		this.available=available;
		this.name=name;
	}
	public boolean bookTickets(List<Integer> seats) {
		System.out.println("欢迎观临"+this.name+"可用位置为："+available);
		List<Integer> copy=new ArrayList<>();
		copy.addAll(available);
		copy.removeAll(seats);
		if(available.size()-copy.size()!=seats.size()) {
			return false;
		}
		available=copy;
		return  true;
	}
}