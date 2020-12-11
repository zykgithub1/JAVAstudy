package cn.sxt.oo2;

public class TestObject {
	public static void main(String[]a) {
		TestObject to=new TestObject();
		System.out.println(to);
		PersonGgg p=new PersonGgg("zyk",24);
		System.out.println(p);
	}
	public String toString() {
		return "totottototo";
	}

	
}
class PersonGgg{

	String name;
	int age;
	@Override
	public String toString() {
		return name+"ƒÍ¡‰"+age;
	}
	public PersonGgg(String name,int age) {
		this.name=name;
		this.age=age;
	}
}