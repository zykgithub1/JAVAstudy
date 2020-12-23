package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

//文件字符输出流
public class IOTest06 {
	public static void main(String[] args) {
		File dest=new File("dest.txt");
		Writer writer=null;
		try {
			writer=new FileWriter(dest);
			String msg="IO is so easy\r\n天翻地覆慨而康2222211";
			//方法一：
//			char[] dates=msg.toCharArray();
//			writer.write(dates,0,dates.length);
			//方法二：
//			writer.write(msg);
			//方法三：
			writer.append(msg);//或者append “字符串”
			writer.flush();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (writer != null) {
					writer.close();
				} 
			} catch (Exception e) {
			}
		}
	}

}
