package cn.sxt.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestaGeneric {
	public static void main(String[]args) {
		MyCollection<String> mc=new MyCollection<String>();
		mc.set("ÔøÒ»¿­", 0);
		mc.set("ÔøÒ»¿­", 1);
		String a=mc.get(1);
		String b=(String)mc.get(0);
		System.out.println(a.equals(b));
		List list=new ArrayList();
		Map map=new HashMap();
		
		
	}

	
	
}
class MyCollection<E>{
	Object[] objs=new Object[5];
	public void set(E e,int index) {
		objs[index]=e;
	}
	public E get(int index) {
		return (E)objs[index];
	}
}