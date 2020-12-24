package com.sxt.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

//转换流：InputStreamReader ,, OutputStreamWriter
//1以字符流的形式操作字节流（纯文本）
//2指定字符集
public class CovertTest02 {
	public static void main(String[] args) {
		//操作网络流
		try(BufferedReader reader=new BufferedReader
				(new InputStreamReader
						(new URL("http://www.baidu.com").openStream(),"UTF-8"));
				BufferedWriter writer=new BufferedWriter
						(new OutputStreamWriter
								(new FileOutputStream("baidu.html"),"UTF-8"));){
			String msg;
			while((msg=reader.readLine())!=null) {
				writer.write(msg);
				writer.newLine();
			}
			writer.flush();
			
			
		}catch(IOException e) {
			System.out.println("操作异常");
		}
		

	}
	public static void test1() {
		//操作网络流
		try(InputStream is=new URL("http://www.baidu.com").openStream();){
			int temp;
			while((temp=is.read())!=-1) {
				System.out.print((char)temp);
			}
			
		}catch(IOException e) {
			System.out.println("操作异常");
		}
		
	}
	public static void test2() {
		//操作网络流
		try(InputStreamReader is=new InputStreamReader(new URL("http://www.baidu.com").openStream(),"utf-8");){
			int temp;
			while((temp=is.read())!=-1) {
				System.out.print((char)temp);
			}
			
		}catch(IOException e) {
			System.out.println("操作异常");
		}
		
	}

}
