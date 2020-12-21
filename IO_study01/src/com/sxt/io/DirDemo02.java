package com.sxt.io;

import java.io.File;

public class DirDemo02 {
	public static void main(String[] args) {
		File dir=new File("F:/elipse/eclipse°²×°³ÌÐò/eclipse code/IO_study01");
		String[] subNames=dir.list();
		for(String s:subNames) {
			System.out.println(s);
		}
		System.out.println("-----------------------------------------------------");
		File[] subFiles=dir.listFiles();
		for(File s:subFiles) {
			System.out.println(s);
		}

		File[] roots=dir.listRoots();
		for(File r:roots) {
			System.out.println(r);
		}
		
		
	}
		
		
		
}
