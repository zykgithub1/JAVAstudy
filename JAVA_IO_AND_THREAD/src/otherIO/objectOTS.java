package otherIO;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;

public class objectOTS {
	public static void main(String[] args) throws IOException, IOException {
		Person p1=new Person("张三", 21);
		Person p2=new Person("李四", 31);
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("f.txt"));
//		FileOutputStream fos=new FileOutputStream("g.txt");
//		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("g.txt"),"utf-8"));
		oos.writeObject(p1);
		oos.writeObject(p2);
		oos.close();
	}

}
class Person implements Serializable{
	public String name;
	public int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	};
	
}
