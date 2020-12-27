package com.sxt.commons;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

public class CIOtest02 {

	public static void main(String[] args) {
		Collection<File> files=FileUtils.listFiles(new File("F:\\elipse\\eclipse安装程序\\eclipse code\\IO_study03"), 
				EmptyFileFilter.NOT_EMPTY, null);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("================================");
		files=FileUtils.listFiles(new File("F:\\elipse\\eclipse安装程序\\eclipse code\\IO_study03"), 
				new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
		for(File file:files) {
			System.out.println(file.getAbsolutePath());
		}
		
	}
}
