package cn.sxt.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test02 {
	public static void main(String[]arhs) {
		readMyFile();
	}
	public static void readMyFile() {
		FileReader reader=null;
		try {
			reader=new FileReader("e:\\a.txt");
			System.out.println("Step1");
			char c1=(char)reader.read();
			
			System.out.println(c1);

		}catch(FileNotFoundException e) {
			System.out.println("Step2");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Ste3");
			try {
				if(reader!=null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	

}
