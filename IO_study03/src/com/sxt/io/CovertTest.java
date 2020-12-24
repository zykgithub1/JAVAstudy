package com.sxt.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//转换流：InputStreamReader ,, OutputStreamWriter
//1以字符流的形式操作字节流（纯文本）
//2指定字符集
public class CovertTest {
	public static void main(String[] args) {
		//操作System.in和System.out
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));){
			String msg="";
			while(!msg.equals("exit")) {
				msg=reader.readLine();
				writer.write(msg);
				writer.newLine();
				writer.flush();
			}
			
		}catch(IOException e) {
			System.out.println("操作异常");
		}
		
	}
	

}
