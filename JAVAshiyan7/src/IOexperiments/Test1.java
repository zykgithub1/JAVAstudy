package IOexperiments;

import java.net.*;

public class Test1 {
	
	
	public static void main(String[] args) throws UnknownHostException {

			InetAddress addr=InetAddress.getLocalHost();
			System.out.println(addr.getLocalHost());
			addr=InetAddress.getByName("jw.cqust.edu.cn");
			System.out.println(addr.getHostAddress());

		
	}

}
