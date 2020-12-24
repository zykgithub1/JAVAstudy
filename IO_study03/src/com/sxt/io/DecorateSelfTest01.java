package com.sxt.io;
//1.抽象组件：需要装饰的抽象接口，或抽象父类；drink
//2.具体组件：需要装饰的对象；coffee
//3.抽象装饰类，包含了对抽象组件的引用以及装饰者共有的方法 deractor
//4.具体装饰类：被装饰的对象mike suger
public class DecorateSelfTest01 {
	public static void main(String[] args) {
		Drink1 coffee=new Coffee1();
		Drink1 mike=new Mike1(coffee);
		System.out.println(mike.cost()+mike.info());
		Drink1 suger=new Suger1(coffee);
		System.out.println(suger.cost()+suger.info());
		suger=new Suger1(mike);
		System.out.println(suger.cost()+suger.info());
		mike=new Mike1(suger);
		System.out.println(mike.cost()+mike.info());
	}
}
interface Drink1{
	double cost();
	String info();
}
class Coffee1 implements Drink1{
	private String name="原味咖啡";

	@Override
	public double cost() {
		return 10;
	}
	@Override
	public String info() {
		return this.name;
	}
}
abstract class Decorate implements Drink1{
	private Drink1 drink;
	public Decorate(Drink1 drink) {
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
class Mike1 extends Decorate implements Drink1{

	public Mike1(Drink1 drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()+5;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"加了牛奶";
	}
	
}
class Suger1 extends Decorate implements Drink1{

	public Suger1(Drink1 drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()+2;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"加了糖";
	}
	
}
