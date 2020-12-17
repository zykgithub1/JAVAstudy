package cn.sxt.mycollection;
//�����������ݹ��ܣ�
public class SxArrayList03<E> {
	//�������
	private Object[] elementDate;//Object���������ΪelementDate��
	private int size;//�����С��
	public static final int DEFALT_CAPACITY=10;//�����С������
	public SxArrayList03() {//���캯��
		elementDate=new Object[DEFALT_CAPACITY];
	}
	public SxArrayList03(int a) {
		elementDate=new Object[a];
	}//����add���Ԫ�ط�����
	public void add(Object obj) {
		//ʲôʱ�����ݣ�
		if(size==elementDate.length) {
			Object[] newArray=new Object[elementDate.length+(elementDate.length>>1)];
			System.arraycopy(elementDate, 0,newArray, 0, elementDate.length);
			elementDate=newArray;
		}
		
		//��ôʵ�֣������鿽����
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
