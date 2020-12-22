package com.sxt.io;

import java.io.File;
//自己完成Filecount
public class SelfDirCount {
	private long len;
	private String path;
	private File src;
	private int fileLength;
	private int  dirLength;
	public SelfDirCount(String path) {
		this.path=path;
		this.src=new File(path);
		count(src);
		
	}
	public void count(File src) {
		if(src!=null&&src.exists()) {
			if(src.isFile()) {
				len+=src.length();
				this.fileLength++;
			}else if(src.isDirectory()){
				this.dirLength++;
				for(File s:src.listFiles()) {
					count(s);
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		SelfDirCount dir=new SelfDirCount("F:/elipse/eclipse安装程序/eclipse code/IO_study01");
		System.out.println(dir.getLen()+"======>"+dir.getFileLength()+"=====>"+dir.dirLength);
		SelfDirCount dir2=new SelfDirCount("F:/elipse/eclipse安装程序/eclipse code/IO_study01/src");
		System.out.println(dir2.getLen()+"======>"+dir2.getFileLength()+"=====>"+dir2.dirLength);
	}
	
	public long getLen() {
		return len;
	}
	public void setLen(long len) {
		this.len = len;
	}
	public int getFileLength() {
		return fileLength;
	}
	public void setFileLength(int fileLength) {
		this.fileLength = fileLength;
	}
	public int getDirLength() {
		return dirLength;
	}
	public void setDirLength(int dirLength) {
		this.dirLength = dirLength;
	}
	public SelfDirCount(long len, String path, File src, int fileLength, int dirLength) {
		super();
		this.len = len;
		this.path = path;
		this.src = src;
		this.fileLength = fileLength;
		this.dirLength = dirLength;
	}
	
	
	

}
