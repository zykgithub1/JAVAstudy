package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//字节输出流
public class Copy {
	public static void main(String[] args) {
		Copy co=new Copy();
		co.copy("src/com/sxt/io/Copy.java", "copy2.txt");

	}
	public void copy(String srcPath,String destPath) {
		File src=new  File(srcPath);
		File dest=new File(destPath);
		
		try(InputStream is=new BufferedInputStream(new FileInputStream(src));
				OutputStream os=new BufferedOutputStream(new FileOutputStream(dest));) {
			
			byte[] flush=new byte[1024];
			int len=-1;
			while((len=is.read(flush))!=-1) {
				os.write(flush,0,len);
			}
			os.flush();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
