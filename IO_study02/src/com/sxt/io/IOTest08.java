package com.sxt.io;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
//03更新
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
//字节数组输出流
//byteArrayOutPutStream 是outputStream的多态
//和新建baos对象的tobyteArray方法连用
//直接存入内存所以不需要目标文件


//步骤：1创建源 2选择流 3操作 4释放
public class IOTest08 {
	public static void main(String[] args) {
		//1,创建源:字节数组
		byte[] dest=null;
		//2，选择流
		ByteArrayOutputStream baos=null;
		try {
			baos=new ByteArrayOutputStream();
			//3(分段）操作
			String msg="show me the code";
			byte[] dates=msg.getBytes();
			baos.write(dates, 0, dates.length);
			baos.flush();
			dest=baos.toByteArray();
			System.out.println(dest.length+"----->"+new String(dest,0,dest.length));
			//4释放资源可以不用处理
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=baos)//is有用到 才关闭 避免空指针
				baos.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
