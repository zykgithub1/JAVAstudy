package IO.demo01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fileReader {
	public static void main(String[] args) throws IOException {
		//demo1();
		FileReader fr=new FileReader("abc.txt");
		int c;
		while((c=fr.read())!=-1) {
			System.out.print((char)c);
		}
		fr.close();
	}

	private static void demo1() throws IOException {
		FileReader fr=null;
		try {
			fr=new FileReader("abc.txt");
			int x=fr.read();
			System.out.println((char)x);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
