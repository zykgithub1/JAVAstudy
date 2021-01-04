package com.sxt.loc;

import java.net.MalformedURLException;
import java.net.URL;

//URL：统一资源定位器，互联网三大基石之一（html,http)区分资源
/*1协议
 * 2域名，计算机
 * 3，端口：默认80
 * 4，请求资源
 * 
 * 
 * */
public class URLTest01 {
	public static void main(String[] args) throws MalformedURLException {
		URL url=new URL("http://www.baidu.com:80/index.html?uname=shsxt&age=18#a");
		//获取4个值
		System.out.println("协议"+url.getProtocol());
		System.out.println("域名或IP"+url.getHost());
		System.out.println("端口"+url.getPort());
		System.out.println("请求资源"+url.getFile());
		System.out.println("请求资源2"+url.getPath());
		//参数：
		System.out.println("参数"+url.getQuery());
		//锚点
		System.out.println("锚点"+url.getRef());
		
	}

}
