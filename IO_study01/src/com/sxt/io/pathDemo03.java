package com.sxt.io;

import java.io.File;

public class pathDemo03 {
	public static void main(String[] args) {
		File src=new File("F:/elipse/eclipse°²×°³ÌÐò/eclipse code/IO_study01/src/com/sxt/io/1.jpg");
		System.out.println(src.getName());
		System.out.println(src.getPath());
		System.out.println(src.getAbsolutePath());
		System.out.println(src.getParent());

	}

}
