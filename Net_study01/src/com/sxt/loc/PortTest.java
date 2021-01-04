package com.sxt.loc;

import java.net.*;

//端口
//1.区分软件  2，2个字节  0-65535 udp tcp   3.同一个协议端口不能冲突    4，定义端口越大越好 InetSocketAddress
public class PortTest {
	public static void main(String[] args) {
			InetSocketAddress socketAddress=new InetSocketAddress("127.0.0.1",8080);
			InetSocketAddress socketAddress2=new InetSocketAddress("localhost",9000);
			System.out.println(socketAddress.getHostName());
	}

}
