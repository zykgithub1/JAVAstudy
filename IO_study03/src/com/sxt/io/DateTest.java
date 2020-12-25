package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DateTest {
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(baos));
		dos.writeUTF("一二三四五");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas=baos.toByteArray();
		DataInputStream dis=new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String msg=dis.readUTF();
		int age=dis.readInt();
		boolean flag=dis.readBoolean();
		char ch=dis.readChar();
		System.out.println(ch);
	}

}
