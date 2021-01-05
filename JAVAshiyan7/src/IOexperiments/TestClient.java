package IOexperiments;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TestClient {
	public static void main(String[] args) throws Exception {
		Socket client=new Socket("localhost",6666);
		InputStream ips=client.getInputStream();
		OutputStream ops=client.getOutputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(ips));
		BufferedReader key=new BufferedReader(new InputStreamReader(System.in));
		String line=key.readLine()+"\n";
		ops.write(line.getBytes());
		System.out.println(line);
		
		
	}

}
