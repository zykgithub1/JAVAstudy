package com.sxt.loc;

import java.net.*;

//IP��λһ���ڵ㡣�������·�ɣ�ͨѶ�豸
//1.getLocalHost����
//2.getByName����������DNS |IP��ַ ����IP��ַ
//3��2����Ա������1.getHostAddress     2.getHostName
public class IpTest {
	public static void main(String[] args) throws UnknownHostException {
		//ʹ��getLocalHost��������netAddress���� ����
		InetAddress addr=InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getLocalHost());
		//���������õ�netaddresss����
		addr=InetAddress.getByName("www.baidu.com");
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
	}

}
