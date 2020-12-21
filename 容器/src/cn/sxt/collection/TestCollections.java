package cn.sxt.collection;

import java.util.ArrayList;
import java.util.*;

//Collections 辅助类的使用
public class TestCollections {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add("zyk"+i);
		}
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}

}
