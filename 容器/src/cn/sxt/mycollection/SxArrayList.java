package cn.sxt.mycollection;

public class SxArrayList {
	//�������
	private Object[] elementDate;//Object���������ΪelementDate��
	private int size;//�����С��
	public static final int DEFALT_CAPACITY=10;//�����С������
	public SxArrayList() {//���캯��
		elementDate=new Object[DEFALT_CAPACITY];
	}
	public SxArrayList(int a) {
		elementDate=new Object[a];
	}//����add���Ԫ�ط�����
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
