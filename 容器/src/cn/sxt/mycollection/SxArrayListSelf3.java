package cn.sxt.mycollection;

import javax.management.RuntimeErrorException;

//增加数组扩容版本：***********************
//增加数组边界的检查+++++++++++++++++++++++++++
//增加remove功能；

public class SxArrayListSelf3<E> {
	//定义对象：
	private Object[] elementDate;//Object类对象名称为elementDate；
	private int size;//定义大小；
	public static final int DEFALT_CAPACITY=10;//定义大小常量；
	public SxArrayListSelf3() {//构造函数
		elementDate=new Object[DEFALT_CAPACITY];
	}
	public SxArrayListSelf3(int a) {
		if(a<0) {
			throw new RuntimeException("请输入正数数组大小");
		}
		else if(a==0) {
			elementDate=new Object[DEFALT_CAPACITY];
		}else {
			elementDate=new Object[a];
		}
		
	}//定义add添加元素方法：
	public void add(Object element) {
		if(size==elementDate.length) {
			//Object[] newArray=new Object[(int)(elementDate.length*1.5)];
			Object[] newArray=new Object[elementDate.length+(elementDate.length>>1)];
			System.arraycopy(elementDate, 0, newArray, 0, elementDate.length);
			elementDate=newArray;//把新数组的地址传给旧数组；
		}
		elementDate[size++]=element;
	}
	public Object get(int index) {
		checkRange(index);
		return elementDate[index];
	}
	public void set(Object obj,int index) {
		checkRange(index);
		
		elementDate[index]=obj;
	}
	public void checkRange(int index) {
		if(index<0||index>size-1) {
			throw new RuntimeException("索引越界不合法"+index);
		}
	}
	
	public void remove(E element) {
		for(int i=0;i<size;i++) {
			if(element.equals(get(i))) {//容器中的比较操作都是equals而不是==
				remove(i);
			}
			
		}
	}
	
	
	
	public void remove(int index) {
		//a b c d e f
		//a b d e f 
		int numMove=elementDate.length-index-1;
		if(numMove>0) {
			System.arraycopy(elementDate, index+1, elementDate, index, numMove);
		}
		elementDate[--size]=null;
		
		
	}
	
	public int size(){
		return size;
	}
	public boolean isEmpty() {
		//return size==0?true:false;
		if(size==0) {
			return true;
		}else {
			return false;
		}
			
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
		SxArrayListSelf3 s1=new SxArrayListSelf3(20);
		
		for(int i=0;i<51;i++) {
			s1.add("Zzz"+i);
		}
		
		s1.set("增一开最帅", 0);
		System.out.println(s1);
		System.out.println(s1.size);
		s1.remove("增一开最帅");
		System.out.println(s1);
		
		
	}

}
