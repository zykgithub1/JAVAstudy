package otherIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class sequenceInputStream {
	public static void main(String[] args) throws IOException {
		FileInputStream fis1=new FileInputStream("a.txt");
		FileInputStream fis2=new FileInputStream("b.txt");
		FileInputStream fis3=new FileInputStream("c.txt");
		//创建集合对象把流对象存储起来
		Vector<FileInputStream>v=new Vector<>();
		v.add(fis1);
		v.add(fis2);
		v.add(fis3);
		Enumeration<FileInputStream>en=v.elements();
		SequenceInputStream sis=new SequenceInputStream(en);
		int c;
		FileOutputStream fos=new FileOutputStream("dd.txt");
		while((c=sis.read())!=-1) {
			fos.write(c);
		}
		fos.close();
		sis.close();
	}

	/**
	 * 整合两个流
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void method1() throws FileNotFoundException, IOException {
		FileInputStream fis1=new FileInputStream("a.txt");
		FileInputStream fis2=new FileInputStream("b.txt");
		FileInputStream fis3=new FileInputStream("c.txt");
		SequenceInputStream sis=new SequenceInputStream(fis1,fis2);
		SequenceInputStream sis2=new SequenceInputStream(sis,fis3);
		FileOutputStream fos=new FileOutputStream("d.txt");
		int b;
		while((b=sis2.read())!=-1) {
			fos.write(b);
		}
		sis2.close();
		fos.close();
	}

}
