
public class SxtStu {
	int ID;
	String name;
	int age;
	Computer comp;
	void study() {
		System.out.printf("ʹ�õ���ѧϰ"+comp.brand);
		
	}
	void paly() {
		System.out.printf("����Ϸ\n");
	}
	public static void main(String[]a) {
		SxtStu zyk=new SxtStu();
		
		zyk.name="��һ��";
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


