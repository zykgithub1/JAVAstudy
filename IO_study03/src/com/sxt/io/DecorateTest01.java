package com.sxt.io;

public class DecorateTest01 {
	public static void main(String[] args) {
		Person p=new Person();
		p.say();
		Amplify amp=new Amplify(p);
		amp.say();
	}
}
interface Say{
	void say();
}
class Person implements Say{
	private int voice=10;
	@Override
	public void say() {
		System.out.println("正常人的声音为"+this.getVoice());
	}

	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}
}
class Amplify implements Say{
	private Person p;
	public Amplify(Person p) {
		this.p=p;
	}

	@Override
	public void say() {
		System.out.println("放大后的声音为"+p.getVoice()*10);
		
	}
	
}