package com.sxt.commons;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class CIOtest01 {

	public static void main(String[] args) {
		long len=FileUtils.sizeOf(new File("src\\com\\sxt\\commons\\CIOtest01.java"));
		System.out.println(len);
		len=FileUtils.sizeOf(new File("F:\\elipse\\eclipse°²×°³ÌÐò\\eclipse code\\IO_study04"));
		System.out.println(len);
	}
}
