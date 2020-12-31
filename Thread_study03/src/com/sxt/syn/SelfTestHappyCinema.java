package com.sxt.syn;

import java.util.ArrayList;
import java.util.List;

public class SelfTestHappyCinema {
	public static void main(String[] args) {
		List<Integer> available=new ArrayList<>();
		available.add(1);
		available.add(2);
		available.add(4);
		available.add(5);
		available.add(6);
		List<Integer> seats1=new ArrayList<>();
		seats1.add(1);
		seats1.add(2);
		List<Integer> seats2=new ArrayList<>();
		seats2.add(4);
		seats2.add(5);
		seats2.add(6);
		ZykCinema zyk=new ZykCinema("zyk", available);
		new Thread(new Custmers(zyk,seats1),"��һ��").start();
		new Thread(new Custmers(zyk,seats2),"������").start();
	}
}
class ZykCinema{
	String name;
	List<Integer> available;
	public ZykCinema(String name, List<Integer> available) {
		super();
		this.name = name;
		this.available = available;
	}
	public boolean booleanTicket(List<Integer> seats) {
		System.out.println("��ӭ����"+this.name+"����λ��Ϊ��"+available);
		List<Integer> copy=new ArrayList<Integer>();
		copy.addAll(available);
		copy.removeAll(seats);
		if(available.size()-copy.size()!=seats.size()) {
			return false;
		}
		available=copy;
		return true;
	}
}
class Custmers implements Runnable{
	ZykCinema cinema;
	List<Integer> seats;
	
	public Custmers(ZykCinema cinema, List<Integer> seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}
	


	@Override
	public void run() {
		synchronized (cinema) {
			boolean flag=this.cinema.booleanTicket(seats);
		if(flag) {
			System.out.println("��Ʊ�ɹ�"+Thread.currentThread().getName()+seats);
		}else {
			System.out.println("��Ʊʧ��"+Thread.currentThread().getName()+"λ�ò���");
		      }
	    }
		
	}
}