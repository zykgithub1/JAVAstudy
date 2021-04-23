package otherIO;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class byteArrayOutputStream {
	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("e.txt");
		FileWriter fw=new FileWriter("a.txt");
		int len;
		while((len=fr.read())!=-1) {
			fw.write(len);
		}
		fw.close();
		fr.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		FileInputStream fis=new FileInputStream("e.txt");
		int len;
		while((len=fis.read())!=-1) {
			bos.write(len);
		}
		byte[]arr=bos.toByteArray();
		fis.close();
		System.out.println(Arrays.toString(arr));
		System.out.println(new String(arr));
	}

}
