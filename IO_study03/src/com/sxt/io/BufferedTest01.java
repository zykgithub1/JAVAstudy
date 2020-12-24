package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//步骤：1创建源 2选择流 3操作 4释放
public class BufferedTest01 {
	public static void main(String[] args) {
		//1,创建源
		File src=new File("abc.txt");
		//2，选择流
		InputStream is=null;
		try {
			is=new BufferedInputStream(new FileInputStream(src));
			//3操作
			byte[] flush=new byte[1024];
			int len=-1;
			while((len=is.read(flush))!=-1) {
				String str=new String(flush,0,len);
			}
			
			//4释放资源
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=is)//is有用到 才关闭 避免空指针
				is.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
