package com.sxt.io;
import java.io.ByteArrayInputStream;
//03更新
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
//字符数组输入流
//步骤：1创建源 2选择流 3操作 4释放
public class IOTest07 {
	public static void main(String[] args) {
		//1,创建源:字节数组
		byte[] src="talk is cheap show me the code".getBytes();
		//2，选择流
		InputStream is=null;
		try {
			is=new ByteArrayInputStream(src);
			//3(分段）操作
			byte[] flush=new byte[5];
			int len;
			while((len=is.read(flush))!=-1) {
				String str=new String(flush,0,len);
				System.out.println(str);
			}
			//4释放资源可以不用处理
			
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
