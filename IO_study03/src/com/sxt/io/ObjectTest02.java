package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
//写出后读取
//读取的顺序与写出保持一致
//不是所有的对象都可以序列化
//序列化保存到文件
public class ObjectTest02 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//写出序列化
		
		ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.ser")));
		oos.writeUTF("一二三四五");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChar('a');
		oos.writeObject("上山打老虎");
		oos.writeObject(new Date());
		Employee emp=new Employee("zyk",1);
		oos.writeObject(emp);
		oos.flush();
		oos.close();
		//读取：反序列化
		ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.ser")));
		String msg=ois.readUTF();
		int age=ois.readInt();
		boolean flag=ois.readBoolean();
		char ch=ois.readChar();
		System.out.println(ch);
		Object str=ois.readObject();
		Object date=ois.readObject();
		Object employee=ois.readObject();
		if(str instanceof String) {
			String strObj=(String)str;
			System.out.println(strObj);	
		}
		if(date instanceof Date) {
			Date dateObj=(Date)date;
			System.out.println(dateObj);	
		}
		if(employee instanceof Employee) {
			Employee empObj=(Employee)employee;
			System.out.println(empObj.getName()+empObj.getSalary());	
		}
		ois.close();
	}

}
