package cn.sxt.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {
	public static void main(String[]args) throws IOException {
		File f2=new File("ggg.txt");
		f2.createNewFile();
		System.out.println("File是否存在"+f2.exists());
		System.out.println("File是否是目录"+f2.isDirectory());
		System.out.println("File是否是文件"+f2.isFile());
		System.out.println("File最后修改时间"+new Date(f2.lastModified()));
		System.out.println("File的大小"+f2.length());
		System.out.println("File的目录路径"+f2.getPath());
		
		
		
	}

}
