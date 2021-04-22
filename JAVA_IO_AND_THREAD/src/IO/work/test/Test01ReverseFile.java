package IO.work.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 将文本文档反转，第一行和倒数第一行交换，第二行和倒数第二行交换
 * 创建集合对象  再倒着写出
 * @author lenovo
 * 注意事项：
 *  流对象应该什么时候用什么时候开
 */
public class Test01ReverseFile {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new FileReader("zzz.txt"));
		List<String>list=new ArrayList();
		int count=0;
		String line;
		while((line=br.readLine())!=null) {
			count++;
			list.add(line);
		}
		br.close();
//		for(String str:list) {
//			System.out.println(str);
//		}
		BufferedWriter bw=new BufferedWriter(new FileWriter("aaa.txt"));
		for(int i=count-1;i!=0;i--) {
			bw.write(list.get(i));
			bw.newLine();
		}
		bw.close();
		
	}
}
