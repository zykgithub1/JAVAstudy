package otherIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class prtintStreaM {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("a.txt"));
		System.setOut(new PrintStream("b.txt"));
		InputStream is = System.in; // 获取标准的键盘输入流，默认指向键盘，改变后指向文件
		PrintStream ps = System.out; // 获取标准输出流，默认指向控制台，改变后指向文件
		int b;

	}

}
