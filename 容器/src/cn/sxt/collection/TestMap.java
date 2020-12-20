package cn.sxt.collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[]args) {
		HashMap<Integer,String> m1=new HashMap<>();
		m1.put(1, "one");
		m1.put(2, "two");
		m1.put(31, "three");
		m1.put(27, "111111111111111");
		
		System.out.println(m1);
		
		Map<Integer,String> m2=new HashMap<>();
		m2.put(4, "ËÄ");
		m2.put(5, "Îå");
		m1.putAll(m2);
		System.out.println(m1.size());
		System.out.println(m1);
		
	}

}
