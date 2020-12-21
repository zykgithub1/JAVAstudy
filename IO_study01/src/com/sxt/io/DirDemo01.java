package com.sxt.io;

import java.io.File;

public class DirDemo01 {
	public static void main(String[] args) {
		File dir=new File("F:/elipse/eclipse°²×°³ÌÐò/eclipse code/IO_study01/dir/test");
		boolean flag=dir.mkdirs();
		System.out.println(flag);
	}

}
