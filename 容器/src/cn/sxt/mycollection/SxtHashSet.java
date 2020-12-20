package cn.sxt.mycollection;

import java.util.HashMap;

//手工实现HashSet
public class SxtHashSet {
	public static void main(String[] args) {
		SxtHashSet set=new SxtHashSet();
		set.add("aaa");
		set.add("bba");
		set.add("ccc");
		System.out.println(set);
	}
	
	HashMap map;
	private static final Object PRESENT=new Object();
	
	
	
	public SxtHashSet(){
		map=new HashMap(16);
	}
	public void add(Object o) {
		map.put(o, PRESENT);	
	}
	public int size() {
		return map.size();
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("[[");
		for(Object key:map.keySet()) {
			System.out.print(key+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		
		return sb.toString();
	}
	

}
