package com.sxt.io;

import java.io.File;


public class DirDemo05 {
	public static void main(String[] args) {
		File src=new File("F:/elipse/eclipse°²×°³ÌÐò/eclipse code/IO_study01");
		count(src);
		System.out.println(len);
	}	
	private static long len=0;
	public static void count(File src) {
		if(null!=src&&src.exists()) {
			if(src.isFile()) {
				len=len+src.length();
			}else {
				for(File s:src.listFiles()) {
					count(s);
				}
			}
		}

	}
}
