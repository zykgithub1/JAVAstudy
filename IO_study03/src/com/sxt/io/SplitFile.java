package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

//随机读写和写入流    RandomAccessFile
public class SplitFile {
	//源头
	private File src;
	//目的地（指定文件夹）
	private String destDir;
	//所有分割后的文件存储路径
	private List<String> destPaths;
	//每块大小
	private int blockSize;
	//块数
	private int size;
	
	public SplitFile(String srcPath,String destDir,int blockSize) {
		this.src=new File(srcPath);
		this.destDir=destDir;
		this.blockSize=blockSize;
		this.destPaths=new ArrayList<String>();
		init();
	}
	
	private void init() {
		long len=this.src.length();
		this.size=(int)(Math.ceil(len*1.0/blockSize));
		for(int i=0;i<size;i++) {
			this.destPaths.add(this.destDir+"/"+i+"-"+this.src.getName());
		}
	}
	//计算每块起始大小，并分割
	//
	public void split() throws IOException {
		long len=src.length();
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
			splitDetail(i,beginPos,actualSize);
		}
	}
	

	//指定起始位置，读取剩余所有内容

	private void splitDetail(int i,int beginPos,int actualSize) throws IOException {
		RandomAccessFile raf=new RandomAccessFile(this.src,"r");
		RandomAccessFile raf2=new RandomAccessFile(this.destPaths.get(i),"rw");
		//起始位置：
		
		raf.seek(beginPos);
		byte[] flush=new byte[1024*100];
		int len=-1;
		while((len=raf.read(flush))!=-1) {
			if(actualSize>len) {
				raf2.write(flush,0,len);
				actualSize-=len;
			}else {
				raf2.write(flush,0,actualSize);
				break;
			}
		}
		raf2.close();
		raf.close();
	}
	public void merge(String destPath) throws IOException {
		OutputStream os=new BufferedOutputStream(new FileOutputStream(destPath,true));
		for(int i=0;i<destPaths.size();i++) {
			InputStream is=new BufferedInputStream(new FileInputStream(destPaths.get(i)));
			byte[] flush=new byte[1024];
			int len=-1;
			while((len=is.read(flush))!=-1) {
				os.write(flush,0,len);
			}
			os.flush();
			
			is.close();
		}
		os.close();
	}
	public static void main(String[] args) throws IOException {
		SplitFile sf=new SplitFile("src\\com\\sxt\\io\\SplitFile.java","dest",1024);
		sf.split();
		sf.merge("aaa.java");
	}

}
