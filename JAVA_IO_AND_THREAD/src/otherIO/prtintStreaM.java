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
		InputStream is = System.in; // ��ȡ��׼�ļ�����������Ĭ��ָ����̣��ı��ָ���ļ�
		PrintStream ps = System.out; // ��ȡ��׼�������Ĭ��ָ�����̨���ı��ָ���ļ�
		int b;

	}

}
