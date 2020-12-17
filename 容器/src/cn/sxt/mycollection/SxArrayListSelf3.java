package cn.sxt.mycollection;

import javax.management.RuntimeErrorException;

//�����������ݰ汾��***********************
//��������߽�ļ��+++++++++++++++++++++++++++
//����remove���ܣ�

public class SxArrayListSelf3<E> {
	//�������
	private Object[] elementDate;//Object���������ΪelementDate��
	private int size;//�����С��
	public static final int DEFALT_CAPACITY=10;//�����С������
	public SxArrayListSelf3() {//���캯��
		elementDate=new Object[DEFALT_CAPACITY];
	}
	public SxArrayListSelf3(int a) {
		if(a<0) {
			throw new RuntimeException("���������������С");
		}
		else if(a==0) {
			elementDate=new Object[DEFALT_CAPACITY];
		}else {
			elementDate=new Object[a];
		}
		
	}//����add���Ԫ�ط�����
	public void add(Object element) {
		if(size==elementDate.length) {
			//Object[] newArray=new Object[(int)(elementDate.length*1.5)];
			Object[] newArray=new Object[elementDate.length+(elementDate.length>>1)];
			System.arraycopy(elementDate, 0, newArray, 0, elementDate.length);
			elementDate=newArray;//��������ĵ�ַ���������飻
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
			throw new RuntimeException("����Խ�粻�Ϸ�"+index);
		}
	}
	
	public void remove(E element) {
		for(int i=0;i<size;i++) {
			if(element.equals(get(i))) {//�����еıȽϲ�������equals������==
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
		
		s1.set("��һ����˧", 0);
		System.out.println(s1);
		System.out.println(s1.size);
		s1.remove("��һ����˧");
		System.out.println(s1);
		
		
	}

}
