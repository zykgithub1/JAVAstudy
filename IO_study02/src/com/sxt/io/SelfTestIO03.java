package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SelfTestIO03 {
	public static void main(String[] args) {
		File dest=new File("zyk1.txt");
		OutputStream os=null;
		try {
			os=new FileOutputStream(dest,true);
			String msg="zyk again\r\n";
			byte[] dates=msg.getBytes();
			os.write(dates, 0, dates.length);
			os.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(os!=null)
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
