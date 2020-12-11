package cn.sxt.oo2;

public class TestExtends {
	public static void main(String[]a) {
		Student stu=new Student();
		stu.height=175;
		stu.name="ÔùÒ»¿ª";
		stu.rest();
		
		Student stu2=new Student("zyk",25,"ÖÇ¿Æ");
		System.out.println(stu2.name);
		System.out.println(stu instanceof Student);
		System.out.println(stu instanceof Person);
		System.out.println(new Person() instanceof Student);
	}
	

}
class Person{
	String name;
	int height;
	public void rest() {
		System.out.println("have a rest");
	}
}
class Student extends Person{
	
	String major;
	public void study() {
		System.out.println("read a bookkkkkkkk,study java");
	}
	public Student(String name,int height,String major) {
		this.name=name;
		this.height=height;
		this.major=major;
	}
	public Student() {
		
	}
	
}