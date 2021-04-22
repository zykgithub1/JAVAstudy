package IO.demo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class copy {
	public static void main(String[] args) throws IOException {
//		demo1();
//		demo3();
		BufferedReader br=new BufferedReader(new FileReader("abc.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("yyy.txt",true));
		int c;
		while((c=br.read())!=-1) {
			bw.write(c);
			bw.flush();
		}
		br.close();
		bw.close();
		
	}

	private static void demo3() throws FileNotFoundException, IOException {
		FileReader fr=new FileReader("abc.txt");
		FileWriter fw=new FileWriter("yyy.txt");
		char[]arr=new char[10240];
		int len;
		while((len=fr.read(arr))!=-1) {  //将文件拷贝进arr数组中  而后将数组写入文件
			fw.write(arr,0,len);
		}
		fr.close();
		fw.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileReader fr=new FileReader("yyy.txt");
		FileWriter fw=new FileWriter("zzz.txt");
		int c;
		while((c=fr.read())!=-1) {
			fw.write(c);
		}
		fw.close();
		fr.close();
		System.out.println("copy结束");
	}

}
