package com.sxt.syn;

import java.util.ArrayList;
import java.util.List;

public class HappyCinema02 {
	public static void main(String[] args) {
		//����λ��
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
		new Thread(new HappyCustomer(c,seats1),"�ϸ�").start();
		new Thread(new HappyCustomer(c,seats2),"����").start();
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
			System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+"----λ��Ϊ"+seats);
		}else {
			System.out.println("��Ʊʧ��"+Thread.currentThread().getName()+"-��λ�ò���");
		}
		}
		
	}
}



class SxtCinema{
	List<Integer> available;//���õ�λ��
	String name;
	public SxtCinema(List<Integer> available,String name) {
		this.available=available;
		this.name=name;
	}
	public boolean bookTickets(List<Integer> seats) {
		System.out.println("��ӭ����"+this.name+"����λ��Ϊ��"+available);
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