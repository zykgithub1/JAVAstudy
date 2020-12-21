package com.sxt.io;

import java.io.File;
import java.io.IOException;

public class pathDemo05 {
	public static void main(String[] args) throws IOException {
		File src=new File("F:/elipse/eclipse°²×°³ÌÐò/eclipse code/IO_study01/src/com/sxt/io/2.txt");
		boolean flag=src.createNewFile();
		System.out.println(src.length());
		System.out.println(flag);
		flag=src.delete();
		System.out.println(flag);
	}
}
