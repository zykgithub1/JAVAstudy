package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//字节输出流
public class Copy2SelfTest {
	public static void main(String[] args) {
		Copy2SelfTest co=new Copy2SelfTest();
		co.copy("src/com/sxt/io/Copy.java", "copy3.txt");

	}
	public void copy(String srcPath,String destPath) {
		File src=new File(srcPath);
		File dest=new File(destPath);
		InputStream is=null;
		OutputStream os=null;
		try {
			is=new FileInputStream(src);
			os=new FileOutputStream(dest);
			int len=-1;
			byte[] flush=new byte[1024];
			while((len=is.read(flush))!=-1) {
				os.write(flush, 0, len);
			}
			os.flush();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (os != null) {
					os.close();
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}try {
				if(null!=is)//is有用到 才关闭 避免空指针
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
