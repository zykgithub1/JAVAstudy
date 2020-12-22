package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//步骤：1创建源 2选择流 3操作 4释放
public class IOTest02 {
	public static void main(String[] args) {
		//1,创建源
		File src=new  File("abc.txt");
		//2，选择流
		try {
			InputStream is=new FileInputStream(src);
			//3操作
			int date1=is.read();
			int date2=is.read();
			int date3=is.read();
			int date4=is.read();//返回-1
			System.out.println((char)date1);
			System.out.println((char)date2);
			System.out.println((char)date3);
			System.out.println(date4);
			//4释放资源
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
