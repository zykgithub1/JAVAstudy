package com.sxt.commons;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

public class CIOtest03 {

	public static void main(String[] args) throws IOException {
		String msg=FileUtils.readFileToString(new File("emp.txt"),"UTF-8");
		System.out.println(msg);
	}
		
}
