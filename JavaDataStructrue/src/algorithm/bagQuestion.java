package algorithm;

public class bagQuestion {
	public static void main(String[] args) {
		int w[]= {3,3,3,11};
		int v[]= {2,3,8,12};
		int result=process2(w, v, 0,10);
		System.out.println(result);
	}
	
//	public static int process1(int[] w,int[] v,int index,int alreadyW,int bag) {
//		if(alreadyW>bag) { //������
//			return -1;
//		}
//		if(index==w.length) {//û���� ������װ
//			return 0;
//		}
//		int p1=process1(w, v, index+1, alreadyW, bag);//��Ҫ��ǰ��Ʒ
//		int p2Next=process1(w, v, index+1, alreadyW+w[index], bag);//Ҫ��ǰ��Ʒ
//		int p2=-1;//�ж�Ҫ����һ�������𣬲����ؾ�װ��
//		if(p2Next!=-1) {
//			p2=v[index]+p2Next;
//		}
//		return Math.max(p1, p2);
//	}
	//ֻȡһ��
	public static int process1(int[] w,int[] v,int index,int alreadyW,int bag) {
		if(alreadyW>bag) {
			return -1;
		}
		if(index==w.length) {
			return 0;
		}
		int p1=process1(w, v, index+1, alreadyW, bag);
		int p2Next=process1(w, v, index+1, alreadyW+w[index], bag);
		int p2=-1;
		if(p2Next!=-1) {
			p2=v[index]+p2Next;
		}
		return Math.max(p1, p2);
	}
	public static int process2(int[] w,int[] v,int index,int rest) {
		if(rest<=0) {
			return 0;
		}
		if(index==w.length) {
			return 0;
		}
		int p1=process2(w, v, index+1, rest);
		int p2=Integer.MIN_VALUE;
		if(rest>=w[index]) {
			p2=v[index]+process2(w, v, index+1, rest-w[index]);
		}
		return Math.max(p1, p2);
	}
}
