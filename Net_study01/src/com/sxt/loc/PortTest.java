package com.sxt.loc;

import java.net.*;

//�˿�
//1.�������  2��2���ֽ�  0-65535 udp tcp   3.ͬһ��Э��˿ڲ��ܳ�ͻ    4������˿�Խ��Խ�� InetSocketAddress
public class PortTest {
	public static void main(String[] args) {
			InetSocketAddress socketAddress=new InetSocketAddress("127.0.0.1",8080);
			InetSocketAddress socketAddress2=new InetSocketAddress("localhost",9000);
			System.out.println(socketAddress.getHostName());
	}

}
