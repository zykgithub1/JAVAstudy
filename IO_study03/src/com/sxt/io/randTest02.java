package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

//随机读写和写入流    RandomAccessFile
public class randTest02 {
	public static void main(String[] args) throws IOException {
		//进行文本分割，而后用刚才敲的设点起始点分段的打印方法进行打印
		File src=new File("1.jpg");
		long len=src.length();
		int blockSize=1024*100;
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
	public static void split(int i,int beginPos,int actualSize) throws IOException {
		RandomAccessFile raf=new RandomAccessFile(new File("1.jpg"), "r");
		RandomAccessFile raf2=new RandomAccessFile(new File("dest/"+i+"1.jpj"), "rw");
		//起始位置：
		
		raf.seek(beginPos);
		byte[] flush=new byte[1024*10];
		int len=-1;
		while((len=raf.read(flush))!=-1) {
			if(actualSize>len) {
				raf2.write(flush,0,len);
				actualSize-=len;
			}else {
				raf2.write(flush,0,actualSize);;
				break;
			}
		}
		raf2.close();
		raf.close();
	}

}
