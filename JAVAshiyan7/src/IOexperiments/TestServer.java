package IOexperiments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss=new ServerSocket(6666);
		Socket server=ss.accept();
		InputStream ips=server.getInputStream();
		OutputStream ops=server.getOutputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(ips));
		BufferedReader key=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		line=br.readLine();
		System.out.println(line);
		line="您的信息已收到\n";
		ops.write(line.getBytes());
	}
}