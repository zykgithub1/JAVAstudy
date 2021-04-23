package otherIO;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAcess {
	public static void main(String[] args) throws IOException {
		//RandomAccessFile raf=new RandomAccessFile("a.txt", "rw");
		FileWriter fw=new FileWriter("ZYK.txt");
		fw.write("zyk 가가가가");
		fw.write(49);
		fw.close();
	}

}
