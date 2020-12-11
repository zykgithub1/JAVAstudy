
public class SxtStu {
	int ID;
	String name;
	int age;
	Computer comp;
	void study() {
		System.out.printf("使用电脑学习"+comp.brand);
		
	}
	void paly() {
		System.out.printf("玩游戏\n");
	}
	public static void main(String[]a) {
		SxtStu zyk=new SxtStu();
		
		zyk.name="赠一开";
		zyk.age=24;
		zyk.ID=2015441284;
		Computer c1=new Computer();
		c1.brand="lenovo";
		zyk.comp=c1;
		zyk.paly();
		zyk.study();
		
	}
	
}	
	
	
class Computer{
	String brand;
	}


