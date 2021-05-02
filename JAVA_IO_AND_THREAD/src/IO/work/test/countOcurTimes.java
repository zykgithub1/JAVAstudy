package IO.work.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class countOcurTimes {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("utf-8.txt"));
		TreeMap<Character,Integer>map=new TreeMap();
		int len;
		while((len=br.read())!=-1) {
			if(!map.containsKey((char)len)) {
				map.put((char)len, 1);
			}else {
				map.put((char)len, map.get((char)len)+1);
			}
		}
		br.close();
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("times.txt")));
		for(Character key:map.keySet()) {
			if(key=='\t') {
				bw.write("\\t"+"="+map.get(key));
			}
			else if(key=='\n') {
				bw.write("\\n"+"="+map.get(key));
			}else if(key=='\r') {
				bw.write("\\r"+"="+map.get(key));
			}
			else {
				bw.write(key+"="+map.get(key));
			}
			bw.newLine();
		}
		bw.close();
	}

}
