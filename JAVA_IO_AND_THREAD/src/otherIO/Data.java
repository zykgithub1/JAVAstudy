package otherIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Data {
	public static void main(String[] args) throws IOException {
		demo3();
		DataInputStream dis=new DataInputStream(new FileInputStream("h.txt"));
		int x=dis.readInt();
		int y=dis.readInt();
		System.out.println(x);
		System.out.println(y);
		
		dis.close();
		
		
		
	}

	private static void demo3() throws FileNotFoundException, IOException {
		DataOutputStream dos=new DataOutputStream(new FileOutputStream("h.txt"));
		int len;
		dos.writeInt(997);
		dos.writeInt(998);
		dos.writeInt(999);
		dos.close();
	}

	private static void demo2() throws FileNotFoundException, IOException {
		FileInputStream fis=new FileInputStream("h.txt");
		int len;
		while((len=fis.read())!=-1) {
			System.out.println(len);
		}
		fis.close();
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileOutputStream fos=new FileOutputStream("h.txt");
		fos.write(997);
		fos.write(998);
		fos.write(999);
		fos.close();
	}

}
