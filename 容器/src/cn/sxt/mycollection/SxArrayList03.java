package cn.sxt.mycollection;
//增加数组扩容功能；
public class SxArrayList03<E> {
	//定义对象：
	private Object[] elementDate;//Object类对象名称为elementDate；
	private int size;//定义大小；
	public static final int DEFALT_CAPACITY=10;//定义大小常量；
	public SxArrayList03() {//构造函数
		elementDate=new Object[DEFALT_CAPACITY];
	}
	public SxArrayList03(int a) {
		elementDate=new Object[a];
	}//定义add添加元素方法：
	public void add(Object obj) {
		//什么时候扩容：
		if(size==elementDate.length) {
			Object[] newArray=new Object[elementDate.length+(elementDate.length>>1)];
			System.arraycopy(elementDate, 0,newArray, 0, elementDate.length);
			elementDate=newArray;
		}
		
		//怎么实现：（数组拷贝）
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
		SxArrayList03 s1=new SxArrayList03();
		for(int i=0;i<55;i++) {
			s1.add("zyk"+i);
		}
		System.out.println(s1);
		
	}

}
