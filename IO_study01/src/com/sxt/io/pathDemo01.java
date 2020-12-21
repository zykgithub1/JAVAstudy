package com.sxt.io;

import java.io.File;

public class pathDemo01 {
	public static void main(String[] args) {
		String path="F:/elipse/eclipse安装程序/eclipse code/IO_study01/src/com/sxt/io/1.jpg";
		File src=new File(path);
		src=new File("F:/elipse/eclipse安装程序/eclipse code/IO_study01/src/com/sxt/io/1.jpg");
		System.out.println(src.length());
	}

}
