package IO.demo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 带缓冲区的流中的特殊方法 
 * readLine
 * newLine
 * @author lenovo
 *
 */
public class buffered {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("abc.txt"));
		BufferedWriter bw=new BufferedWriter(new FileWriter("zzz.txt"));
		String line;
		while((line=br.readLine())!=null) {
			bw.write(line+"\n");
			//bw.newLine();
		}
		bw.close();
		br.close();
	}

	private static void f01() throws FileNotFoundException, IOException {
		BufferedReader br=new BufferedReader(new FileReader("abc.txt"));
		String line =br.readLine();
		while((line =br.readLine())!=null) {
			System.out.println(line);
		}
		br.close();
	}

}
