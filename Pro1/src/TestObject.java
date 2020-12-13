

public class TestObject {
	public static void main(String[]a) {
		TestObject to=new TestObject();
		System.out.println(to);
		Person2 p=new Person2("zyk",24);
		System.out.println(p.toString());
	}
	public String toString() {
		return "totottototo";
	}
}
class Person2{

	String name;
	int age;
	@Override
	public String toString() {
		return name+"ƒÍ¡‰"+age;
	}
	public Person2(String name,int age) {
		this.name=name;
		this.age=age;
	}

}
