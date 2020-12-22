package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//字节输出流
public class IOTest04 {
	public static void main(String[] args) {
		File dest=new File("dest.txt");
		OutputStream os=null;
		try {
			os=new FileOutputStream(dest,false);
			String msg="IO is so easy";
			byte[] dates=msg.getBytes();
			os.write(dates,0,dates.length);
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
			}
		}
	}

}
