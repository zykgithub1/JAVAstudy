package com.sxt.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
//bufferedReader  reader.readline方法
//步骤：1创建源 2选择流 3操作 4释放
public class BufferedTest03 {
	public static void main(String[] args) {
		//1,创建源
		File src=new File("abc.txt");
		//2，选择流
		BufferedReader reader=null;
		try {
			reader=new BufferedReader(new FileReader(src));
			//3(分段）操作
			String line=null;
		
			while((line=reader.readLine())!=null) {
				System.out.println(line);
			}
			//4释放资源
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(null!=reader)//is有用到 才关闭 避免空指针
				reader.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
