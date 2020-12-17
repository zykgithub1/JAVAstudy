package cn.sxt.mycollection;

public class SxArrayList {
	//定义对象：
	private Object[] elementDate;//Object类对象名称为elementDate；
	private int size;//定义大小；
	public static final int DEFALT_CAPACITY=10;//定义大小常量；
	public SxArrayList() {//构造函数
		elementDate=new Object[DEFALT_CAPACITY];
	}
	public SxArrayList(int a) {
		elementDate=new Object[a];
	}//定义add添加元素方法：
	public void add(Object obj) {
		elementDate[size++]=obj;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(int i=0;i<size;i++) {
			sb.append(elementDate[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
		
	}
	public static void main(String[]args) {
		SxArrayList s1=new SxArrayList(20);
		s1.add("aa");
		s1.add("bb");
		System.out.println(s1);
		
	}

}
