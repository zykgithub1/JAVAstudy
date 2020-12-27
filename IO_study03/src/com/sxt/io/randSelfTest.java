package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class randSelfTest {
	public static void main(String[] args) throws IOException {
		
		File src=new File("src/com/sxt/io/DecorateSelfTest01.java");
		long len=src.length();
		int blockSize=1024;
		int size=(int)Math.ceil(len*1.0/blockSize);
		int beginPos=5;
		System.out.println(len);
		int actualSize=(int)(blockSize>len?len:blockSize);
		byte[] flush=new byte[1024];
		for(int i=0;i<size;i++) {
			beginPos=i*blockSize;
			if(i==size-1) {
				actualSize=(int)len;
			}else {
				actualSize=blockSize;
				len-=blockSize;
			}
			System.out.println(i+"------>"+beginPos+"--->"+actualSize);
			split(i,beginPos,actualSize);
		}
	}
	public static void test1() throws IOException {
		RandomAccessFile raf=new RandomAccessFile(new File("src/com/sxt/io/DecorateSelfTest01.java"), "r");
		raf.seek(1888);
		byte[] flush=new byte[1024];
		int len=-1;
		while((len=raf.read(flush))!=-1) {
			System.out.println(new String(flush,0,len));
		}
		raf.close();
		
	}
	public static void test2() throws IOException {
		RandomAccessFile raf=new RandomAccessFile(new File("src/com/sxt/io/DecorateSelfTest01.java"), "r");
		int beginPos=7+1077;
		int actualSize=1077;
		raf.seek(beginPos);
		byte[] flush=new byte[1024];
		int len=-1;
		while((len=raf.read(flush))!=-1) {
			if(actualSize>len) {
				System.out.println(new String(flush,0,len));
				actualSize-=len;
			}else {
				System.out.println(new String(flush,0,actualSize));
			}
			
		}
		raf.close();
		
	}
	public static void split(int i,int beginPos,int actualSize) throws IOException {
		RandomAccessFile raf=new RandomAccessFile(new File("src/com/sxt/io/DecorateSelfTest01.java"), "r");
		
		
		raf.seek(beginPos);
		byte[] flush=new byte[1024];
		int len=-1;
		while((len=raf.read(flush))!=-1) {
			if(actualSize>len) {
				System.out.println(new String(flush,0,len));
				actualSize-=len;
			}else {
				System.out.println(new String(flush,0,actualSize));
			}
			
		}
		raf.close();
		
	}

}
