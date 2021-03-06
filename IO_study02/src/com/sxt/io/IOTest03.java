package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//步骤：1创建源 2选择流 3操作 4释放
public class IOTest03 {
	public static void main(String[] args) {
		//1,创建源
		File src=new File("abc.txt");
		//2，选择流
		Reader reader=null;
		try {
			reader=new FileReader(src);
			//3(分段）操作
			char[] flush=new char[1024];
			int len;
			while((len=reader.read(flush))!=-1) {
				String str=new String(flush,0,len);
				System.out.println(str);
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
