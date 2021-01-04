package com.sxt.loc;

import java.net.*;

//IP定位一个节点。计算机，路由，通讯设备
//1.getLocalHost本机
//2.getByName：根据域名DNS |IP地址 解析IP地址
//3，2个成员方法：1.getHostAddress     2.getHostName
public class IpTest {
	public static void main(String[] args) throws UnknownHostException {
		//使用getLocalHost方法创建netAddress对象 本机
		InetAddress addr=InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getLocalHost());
		//根据域名得到netaddresss对象
		addr=InetAddress.getByName("www.baidu.com");
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
	}

}
