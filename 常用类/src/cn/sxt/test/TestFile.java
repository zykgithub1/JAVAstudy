package cn.sxt.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestFile {
	public static void main(String[]args) throws IOException {
		File f2=new File("ggg.txt");
		f2.createNewFile();
		System.out.println("File�Ƿ����"+f2.exists());
		System.out.println("File�Ƿ���Ŀ¼"+f2.isDirectory());
		System.out.println("File�Ƿ����ļ�"+f2.isFile());
		System.out.println("File����޸�ʱ��"+new Date(f2.lastModified()));
		System.out.println("File�Ĵ�С"+f2.length());
		System.out.println("File��Ŀ¼·��"+f2.getPath());
		
		
		
	}

}
