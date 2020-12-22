package com.sxt.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class SelfTestIO {
	public static void main(String[] args) {
		File src=new File("abc.txt");
		InputStream is=null;
	try {
		is=new FileInputStream(src);
		int temp;
		while((temp=is.read())!=-1) {
			System.out.print((char)temp+" ");
		}
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}finally {
		try {
			is.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	}
	

}
