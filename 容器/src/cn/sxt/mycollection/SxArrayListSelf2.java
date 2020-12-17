package cn.sxt.mycollection;
//�����������ݰ汾��***********************
public class SxArrayListSelf2<E> {
	//�������
	private Object[] elementDate;//Object���������ΪelementDate��
	private int size;//�����С��
	public static final int DEFALT_CAPACITY=10;//�����С������
	public SxArrayListSelf2() {//���캯��
		elementDate=new Object[DEFALT_CAPACITY];
	}
	public SxArrayListSelf2(int a) {
		elementDate=new Object[a];
	}//����add���Ԫ�ط�����
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
