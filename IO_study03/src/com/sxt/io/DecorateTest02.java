package com.sxt.io;
//1.�����������Ҫװ�εĳ���ӿڣ�������ࣻdrink
//2.�����������Ҫװ�εĶ���coffee
//3.����װ���࣬�����˶Գ�������������Լ�װ���߹��еķ��� deractor
//4.����װ���ࣺ��װ�εĶ���mike suger
public class DecorateTest02 {
	public static void main(String[] args) {
		Drink coffee=new Coffee();
		Drink suger=new Suger(coffee);
		System.out.println(suger.info()+suger.cost());
		Drink mike=new Mike(coffee);
		System.out.println(mike.info()+mike.cost());
		mike=new Mike(suger);
		System.out.println(mike.info()+mike.cost());
		suger=new Suger(mike);
		System.out.println(suger.info()+suger.cost());
	}
}
interface Drink{
	double cost();
	String info();
}

class Coffee implements Drink{
	private String name="ԭζ����";

	@Override
	public double cost() {
		return 10;
	}

	@Override
	public String info() {
		return this.name;
	}
}
abstract class Deractor implements Drink{
	private Drink drink;
	public Deractor(Drink drink) {
		this.drink=drink;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.drink.cost();
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return this.drink.info();
	}
}
class Mike extends Deractor{
	public Mike(Drink drink) {
		super(drink);
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()+5;
	}
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"����ţ��";
	}
}
class Suger extends Deractor{
	public Suger(Drink drink) {
		super(drink);
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()+2;
	}
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"������";
	}
}
	
