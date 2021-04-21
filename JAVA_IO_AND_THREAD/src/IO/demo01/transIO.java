package IO.demo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class transIO {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader
				(new InputStreamReader
						(new FileInputStream("utf-8.txt"),"utf-8"));
		BufferedWriter bw=new BufferedWriter
				(new OutputStreamWriter
						(new FileOutputStream("gbk.txt")));
		br.close();
		bw.close();
	}

	private static void demo2() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		InputStreamReader isr=new InputStreamReader(new FileInputStream("utf-8.txt"),"utf-8");
		OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("gbk.txt"),"gbk");
		int c;
		while((c=isr.read())!=-1) {
			osw.write(c);
		}
		osw.close();
		isr.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileReader fr=new FileReader("utf-8.txt");
		FileWriter fw=new FileWriter("gbk.txt");
		int c;
		while((c=fr.read())!=-1) {
			fw.write(c);
		}
		fw.close();
		fr.close();
	}

}
