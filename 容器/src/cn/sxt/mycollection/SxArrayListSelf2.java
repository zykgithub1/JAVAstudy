package cn.sxt.mycollection;
//增加数组扩容版本：***********************
public class SxArrayListSelf2<E> {
	//定义对象：
	private Object[] elementDate;//Object类对象名称为elementDate；
	private int size;//定义大小；
	public static final int DEFALT_CAPACITY=10;//定义大小常量；
	public SxArrayListSelf2() {//构造函数
		elementDate=new Object[DEFALT_CAPACITY];
	}
	public SxArrayListSelf2(int a) {
		elementDate=new Object[a];
	}//定义add添加元素方法：
	public void add(E element) {
		if(size==elementDate.length) {
			//Object[] newArray=new Object[(int)(elementDate.length*1.5)];
			Object[] newArray=new Object[elementDate.length+(elementDate.length>>1)];
			System.arraycopy(elementDate, 0, newArray, 0, elementDate.length);
			elementDate=newArray;
		}
		elementDate[size++]=element;
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
		SxArrayListSelf2 s1=new SxArrayListSelf2(20);
		
		for(int i=0;i<50;i++) {
			s1.add("Zzz"+i);
		}
		System.out.println(s1);
		
	}

}
