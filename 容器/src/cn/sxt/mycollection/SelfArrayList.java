package cn.sxt.mycollection;

public class SelfArrayList {
	private Object[] element;
	private int size;
	private final int CAPACITY=10;
	
	public SelfArrayList() {
		element=new Object[CAPACITY];
	}
	public SelfArrayList(int a) {
		element=new Object[a];
	}
	public void add(Object obj) {
		element[size++]=obj;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(int i=0;i<size;i++) {
			sb.append(element[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	
	
	public static void main(String[]args) {
		SelfArrayList s1=new SelfArrayList();
		s1.add("aa");
		s1.add("bbcc");
		System.out.println(s1);
	}

}
