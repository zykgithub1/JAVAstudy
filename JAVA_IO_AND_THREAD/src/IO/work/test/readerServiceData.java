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
 * �ӷ�������ȡһ������  �޸ĺ�д�ط�����
 * ֻ����bufferReader  ��readline 
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
			System.out.printf("ʣ�����%d\n",num);
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("count.txt")));
			bw.write(num+"\n");
			bw.close();
		}else {
			System.out.println("û�д���");
		}
		br.close();
		
		
		
	}

}
