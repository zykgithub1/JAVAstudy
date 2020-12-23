package com.sxt.io;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
//03更新
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//1图片读取到字节数组中，
//2字节数组写到文件中

//步骤：1创建源 2选择流 3操作 4释放
public class IOTest10SelfTest {
	public static void main(String[] args) {
		byte[] dates=fileToByteArray("1.jpg"); 
		byteArrayToFile(dates,"333-baye.jpg");
		System.out.println(dates.length);
	}
	//一，图片读取到字节数组中
	//1，图片到程序 FileInputStream
	//2，程序到字节  byteArrayOutPutStream
	public  static byte[] fileToByteArray(String filePath) {
		File src=new File(filePath);
		InputStream is=null;
		ByteArrayOutputStream baos=null;
		try {
			is=new FileInputStream(src);
			baos=new ByteArrayOutputStream();
			int len=-1;
			byte[] flush=new byte[10];
			while((len=is.read(flush))!=-1) {
				baos.write(flush, 0, len);
			}
			baos.flush();
			return baos.toByteArray();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(is!=null) {
					is.close();
				}		
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//二，字节数组写出到图片
	//1，字节数组到程序ByteArrayInputStream
	//2，程序写出到文件FileOutputStream
	
	public  static void byteArrayToFile(byte[] src,String filePath) {
		File dest=new File(filePath);
		OutputStream os=null;
		InputStream is=null;
		try {
			os=new FileOutputStream(dest);
			is=new ByteArrayInputStream(src);
			byte[] flush=new byte[10];
			int len=-1;
			while((len=is.read(flush))!=-1) {
				os.write(flush, 0, len);
			}
			os.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(os!=null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
		}
	}
	

}
