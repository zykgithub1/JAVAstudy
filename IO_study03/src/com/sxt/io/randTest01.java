package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

//随机读写和写入流    RandomAccessFile
public class randTest01 {
	public static void main(String[] args) throws IOException {
		File src=new File("src/com/sxt/io/DecorateSelfTest01.java");
		long len=src.length();
		int blockSize=1024;
		int size=(int)(Math.ceil(len*1.0/blockSize));
		System.out.println(size);
		int beginPos=0;
		int actualSize=(int)(blockSize>len?len:blockSize);
		for(int i=0;i<size;i++) {
			beginPos=i*blockSize;
			if(i==size-1) {
				actualSize=(int) len;
			}else {
				actualSize=blockSize;
				len-=actualSize;
			}
			System.out.println(i+"--->"+beginPos+"------->"+actualSize);
			split(i,beginPos,actualSize);
		}
	}
	//指定起始位置，读取剩余所有内容
	public static void test1() throws IOException {
		RandomAccessFile raf=new RandomAccessFile(new File("src/com/sxt/io/DecorateSelfTest01.java"), "");
		raf.seek(0);
		byte[] flush=new byte[1024];
		int len=-1;
		while((len=raf.read(flush))!=-1) {
			System.out.println(new String(flush,0,len));
		}
		raf.close();
	}
	//分块思想，有起始，有实际大小
	public static void test2(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile(new File("src/com/sxt/io/DecorateSelfTest01.java"), "r");
		//起始位置：
		int beginPos=2;
		int actualSize=1026;
		raf.seek(beginPos);
		byte[] flush=new byte[1024];
		int len=-1;
		while((len=raf.read(flush))!=-1) {
			if(actualSize>len) {
				System.out.println(new String(flush,0,len));
				actualSize-=len;
			}else {
				System.out.println(new String(flush,0,actualSize));
				break;
			}
		}
		raf.close();
	}//指定第i块的起始位置和起始长度，
	public static void split(int i,int beginPos,int actualSize) throws IOException {
		RandomAccessFile raf=new RandomAccessFile(new File("src/com/sxt/io/DecorateSelfTest01.java"), "r");
		//起始位置：
		
		raf.seek(beginPos);
		byte[] flush=new byte[1024];
		int len=-1;
		while((len=raf.read(flush))!=-1) {
			if(actualSize>len) {
				System.out.println(new String(flush,0,len));
				actualSize-=len;
			}else {
				System.out.println(new String(flush,0,actualSize));
				break;
			}
		}
		raf.close();
	}

}
