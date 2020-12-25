package com.sxt.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//加入BufferedReader和 Writer 并且使用了新方法read/write.Line();
public class CopyTxt {
	public static void main(String[] args) {
		CopyTxt co=new CopyTxt();
		co.copy("F:/elipse/eclipse安装程序/eclipse code/IO_study03/src/com/sxt/io/CopyTxt.java", "COCOCopyTxt.txt");

	}
	public void copy(String srcPath,String destPath) {
		File src=new  File(srcPath);
		File dest=new File(destPath);
		
		try(BufferedReader br=new BufferedReader(new FileReader(src));
				BufferedWriter bw=new BufferedWriter(new FileWriter(dest));) {
			
			String line=null;
			
			while((line=br.readLine())!=null) {
				bw.write(line);
				bw.newLine();
			}
			bw.flush();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
