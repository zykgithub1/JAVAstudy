package IO.work.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 从服务器读取一个数据  修改后写回服务器
 * 只能用bufferReader  用readline 
 * @author lenovo
 *
 */
public class readerServiceData {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("count.txt")));
		String line=br.readLine();
		int num=Integer.valueOf(line);
		if(num>0) {
			num--;
			System.out.printf("剩余次数%d\n",num);
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("count.txt")));
			bw.write(num+"\n");
			bw.close();
		}else {
			System.out.println("没有次数");
		}
		br.close();
		
		
		
	}

}
