package cn.sxt.exception;
//runtime exception
public class Test01 {
	public static void main(String[]ars) {
		int a=0;
		if(a!=0) {
			System.out.println(a/Math.random());
		}
		String str=null;
		if(str!=null) {
			str.length();
		}
		Animal d=new Dog();
		Dog e=(Dog) d;
		
		
		
	}

}
class Animal{
	
}
class Dog extends Animal{
	
}
class Cat extends Animal{
	
}
