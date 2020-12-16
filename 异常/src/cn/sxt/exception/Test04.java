package cn.sxt.exception;

public class Test04 {
	public static void main(String[]ars) {
		Person p=new Person();
		p.setAge(-15);
	}

}
class Person{
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age<0) {
			try {
				throw new IllegalAgeException("年龄不能为负数");
			} catch (IllegalAgeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.age=age;
	}
	
	
	
}
class IllegalAgeException extends Exception{
	public IllegalAgeException() {
		
	}
	public IllegalAgeException(String msg) {
		super(msg);
	}
}