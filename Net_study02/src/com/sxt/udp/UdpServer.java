package com.sxt.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//���ն�
//1.ʹ��DatagramSocket  ָ���˿� �������ն�
//2.׼������ ��װ��DatagramPacket ����
//3.����ʽ���ܰ��� receive
//4����������  
//byte[]   getData()
//         getLength()
//5�ͷ���Դ
public class UdpServer {
	public static void main(String[] args) throws Exception {
		System.out.println("���շ������С�������");
		//1.ʹ��DatagramSocket  ָ���˿� �������ն�
		DatagramSocket server=new DatagramSocket(6666);
		//2.׼������ ��װ��DatagramPacket ����
		byte[] container=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(container, 0,container.length);
		//3.����ʽ���ܰ��� receive
		server.receive(packet);
		//4����������  
		//byte[]   getData()
//		         getLength()
		byte[] datas=packet.getData();
		int len=packet.getLength();
		System.out.println(new String(datas,0,len));
		//5�ͷ���Դ
		server.close();
		
		
	}

}
