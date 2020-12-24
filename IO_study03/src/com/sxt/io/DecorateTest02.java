package com.sxt.io;
//1.抽象组件：需要装饰的抽象接口，或抽象父类；drink
//2.具体组件：需要装饰的对象；coffee
//3.抽象装饰类，包含了对抽象组件的引用以及装饰者共有的方法 deractor
//4.具体装饰类：被装饰的对象mike suger
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
		return super.info()+"加了牛奶";
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
		return super.info()+"加了糖";
	}
}
	
