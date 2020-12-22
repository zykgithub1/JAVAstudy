package com.sxt.io;

import java.io.File;


public class DirCount {
	private long len;
	private String path;
	private File src;
	private int fileSize;
	private int dirSize;
	public DirCount(String path){
		this.path=path;
		this.src=new File(path);
		count(this.src);
		
	}
	
	
	public static void main(String[] args) {
		DirCount dir=new DirCount("F:/elipse/eclipse安装程序/eclipse code/IO_study01");
		System.out.println(dir.getLen()+"===========>"+dir.getFileSize()+"============>"+dir.getDirSize());
		DirCount dir2=new DirCount("F:/elipse/eclipse安装程序/eclipse code/IO_study01/src");
		System.out.println(dir2.getLen()+"===========>"+dir2.getFileSize()+"============>"+dir2.getDirSize());
	}
	private void count(File src) {
		if(src!=null&&src.exists()) {
			if(src.isFile()) {
				len+=src.length();
				this.fileSize++;
			}else {
				this.dirSize++;
				for(File s:src.listFiles()) {
					count(s);
					
				}
			}
			
		}
	}


	public long getLen() {
		return len;
	}


	public int getFileSize() {
		return fileSize;
	}


	


	public int getDirSize() {
		return dirSize;
	}


	


	
	
	
	
	
}
