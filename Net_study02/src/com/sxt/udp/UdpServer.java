package com.sxt.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//接收端
//1.使用DatagramSocket  指定端口 创建接收端
//2.准备容器 封装成DatagramPacket 包裹
//3.阻塞式接受包裹 receive
//4。分析数据  
//byte[]   getData()
//         getLength()
//5释放资源
public class UdpServer {
	public static void main(String[] args) throws Exception {
		System.out.println("接收方启动中。。。。");
		//1.使用DatagramSocket  指定端口 创建接收端
		DatagramSocket server=new DatagramSocket(6666);
		//2.准备容器 封装成DatagramPacket 包裹
		byte[] container=new byte[1024*60];
		DatagramPacket packet=new DatagramPacket(container, 0,container.length);
		//3.阻塞式接受包裹 receive
		server.receive(packet);
		//4。分析数据  
		//byte[]   getData()
//		         getLength()
		byte[] datas=packet.getData();
		int len=packet.getLength();
		System.out.println(new String(datas,0,len));
		//5释放资源
		server.close();
		
		
	}

}
