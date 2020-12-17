package cn.sxt.mycollection;
/*1,定义对象
 * 2，构造函数
 * 3重写tostring
 * 3，add方法（扩容版本）
 * 4，get方法
 * 5,set
 * 6,remove方法和定义
 */
public class ZykSelfArryaList {
	private Object[] elementDate;
	private int size;
	static private final int  DEAD_CAPACITY=10;
	public ZykSelfArryaList(int a) {
		if(a<0) {
			throw new RuntimeException("请输入合法大小");
		}
		else if(a==0) {
			elementDate=new Object[DEAD_CAPACITY];
		}else {
			elementDate=new Object[a];
		}
		
	}
	public void remove(Object obj) {
		for(int i=0;i<size;i++) {
			if(obj.equals(get(i))) {
				remove(i);
			}
		}
	}
	//a,b,c,d,e,f
	//a,c,d,e,f
	public void remove(int index) {
		checkRange(index);
		System.arraycopy(elementDate, index+1, elementDate, index, elementDate.length-1-index);
		elementDate[--size]=null;
	}
	
	public Object get(int index) {
		checkRange(index);
		return elementDate[index];
	}
	
	public void add(Object obj) {
		if(size==elementDate.length) {
			Object[] newArray=new Object[(int)(elementDate.length*1.5)];
			System.arraycopy(elementDate, 0, newArray, 0, elementDate.length);
			elementDate=newArray;
		}
		elementDate[size++]=obj;
	}
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append('[');
		for(int i=0;i<size;i++) {
			sb.append(elementDate[i]+",");
		}
		sb.setCharAt(sb.length()-1, ']');;
		return sb.toString();
	}
	
	public void set(int index,Object obj) {
		checkRange(index);
		elementDate[index]=obj;
	}
	public void checkRange(int index) {
		if(index<0||index>size-1) {
			throw new RuntimeException("索引越界不合法："+index);
		}
	}
	
	public static void main(String[]args) {
		ZykSelfArryaList s1=new ZykSelfArryaList(20);
		for(int i=0;i<54;i++)
		{
			s1.add("Zzz"+i);
		}
		s1.set(0, "这一刻真的happy");
		s1.remove(1);
		System.out.println(s1);
		System.out.println(s1.get(66));
	}
	

}
