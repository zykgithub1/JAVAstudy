package cn.sxt.mycollection;

import javax.management.RuntimeErrorException;

//�����������ݹ��ܣ�
public class SxArrayList02<E> {
	//�������
	private Object[] elementDate;//Object���������ΪelementDate��
	private int size;//�����С��
	public static final int DEFALT_CAPACITY=10;//�����С������
	public SxArrayList02() {//���캯��
		elementDate=new Object[DEFALT_CAPACITY];
	}
	public SxArrayList02(int a) {
		elementDate=new Object[a];
	}//����add���Ԫ�ط�����
	public void add(E element) {
		//ʲôʱ�����ݣ�
		if(size==elementDate.length) {
			Object[] newArray=new Object[elementDate.length+(elementDate.length>>1)];
			System.arraycopy(elementDate, 0,newArray, 0, elementDate.length);
			elementDate=newArray;
		}
		
		//��ôʵ�֣������鿽����
		elementDate[size++]=element;
	}
	public E get(int a) {
		
			
		
		return (E)elementDate[a];
		
	}
	public void checkRange(int a) {
		//�����Ϸ��ж�
				if(a<0||a>size-1) {
					throw new RuntimeException("�������Ϸ�"+a);
				}
		
	}
	public void set(E element,int index) {
		checkRange(index);
		elementDate[index]=element;
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
		SxArrayList02 s1=new SxArrayList02();
		for(int i=0;i<55;i++) {
			s1.add("zyk"+i);
		}
		System.out.println(s1);
		s1.set("weeq", 10);
		System.out.println(s1.get(80));
		
	}

}
