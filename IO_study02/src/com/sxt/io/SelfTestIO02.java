package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class SelfTestIO02 {
	public static void main(String[] args) {
		File src=new File("abc.txt");
		InputStream is=null;
		try {
			is=new FileInputStream(src);
			byte[] flush=new byte[1024];
			int len;
			while((len=is.read(flush))!=-1) {
				String str=new String(flush,0,len);
				System.out.println(str);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(is!=null)
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
