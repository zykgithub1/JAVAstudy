package com.sxt.io;

import java.io.File;

public class pathDemo02 {
	public static void main(String[] args) {
		String path="F:/elipse/eclipse°²×°³ÌÐò/eclipse code/IO_study01/src/com/sxt/io/1.jpg";
		File src=new File(path);
		System.out.println(src.getParent());
	}

}
