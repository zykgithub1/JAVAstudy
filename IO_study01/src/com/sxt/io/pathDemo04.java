package com.sxt.io;

import java.io.File;

public class pathDemo04 {
	public static void main(String[] args) {
		File src=new File("F:/elipse/eclipse安装程序/eclipse code/IO_study01/src/com/sxt/io/1.jpg");
		System.out.println(src.exists());
		System.out.println(src.isFile());
		System.out.println(src.isDirectory());
		System.out.println("----------------------------------------------------");
		src=new File("1.jpg");
		System.out.println(src.exists());
		System.out.println(src.isFile());
		System.out.println(src.isDirectory());
		System.out.println("----------------------------------------------------");
		src=new File("F:/elipse/eclipse安装程序/eclipse code/IO_study01/src/com/sxt");
		System.out.println(src.exists());
		System.out.println(src.isFile());
		System.out.println(src.isDirectory());
		
		
		
		src=new File("xsadas");
		if(src==null||!src.exists()) {
			System.out.println("WENJIAN不存在");
		}else {
			if(src.isFile()) {
				System.out.println("文件操作");
			}else {
				System.out.println("文件架子操作");
			}
		}

	}

}
