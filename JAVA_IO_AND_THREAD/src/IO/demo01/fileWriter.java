package IO.demo01;

import java.io.FileWriter;
import java.io.IOException;

public class fileWriter {

	public static void main(String[] args) throws IOException {
		FileWriter fw=new FileWriter("yyy.txt",true);
		fw.write("大家好我来复习了");
		fw.write(97);
		fw.close();
	}

}
