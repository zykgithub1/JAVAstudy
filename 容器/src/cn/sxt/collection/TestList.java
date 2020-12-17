package cn.sxt.collection;

import java.util.*;

public class TestList {
	public static void main(String[]ars) {
		//test01();
	//test02();
		test03();

		
	}
	public static void test01() {
		Collection<String> c=new ArrayList<>();
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		c.add("这一刻");
		c.add("JAVaNIUBI");
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		c.remove("这一刻");
		System.out.println(c);
	}

	public static void test02() {
		List<String> list01=new ArrayList<String>();
		list01.add("aa");
		list01.add("bb");
		list01.add("cc");
		List<String> list02=new ArrayList<>();
		list02.add("aa");
		//list02.add("dd");
		//list02.add("ee");
		System.out.println("list01"+list01);
		//list01.addAll(list02);
		//list01.removeAll(list02);//removeAll移除交集；
		list01.retainAll(list02);
		System.out.println("list01"+list01);
		System.out.println("list01"+list01.containsAll(list02));
	}
	public static void test03() {
		List<String> list=new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		System.out.println(list);
		list.add(2,"我");
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		list.set(2, "big boss");
		System.out.println(list);
		list.add("E");
		list.add("D");
		list.add("C");
		System.out.println(list);
		System.out.println(list.indexOf("D"));
		System.out.println(list.lastIndexOf("D"));
	}
}

