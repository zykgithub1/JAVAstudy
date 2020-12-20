package cn.sxt.mycollection;
//�Զ���һ��HashMap
//����ʵ����put��������keyֵ�ظ���ʱ�򸲸ǣ���ͬ��ʱ����ӣ�
//���toString����������鿴
public class SxtHashMap02 {
	Node2[] table;//λͰ����
	int size;
	
	public SxtHashMap02() {
		table =new Node2[16];
	}
	public void put(Object key,Object value) {
		Node2 newNode=new Node2();
		newNode.hash=myHash(key.hashCode(),table.length);
		newNode.key=key;
		newNode.value=value;
		newNode.next=null;
		
		Node2 temp=table[newNode.hash];
		Node2 iterLast=null;
		boolean keyRepeat=false;
		if(temp==null) {
			//�˴������Ԫ��Ϊ�գ�����½ڵ�Ž�ȥ��
			table[newNode.hash]=newNode;
			size++;
		}else {
			//�����Ϊ�գ��ͱ������������ͬ��key��������������������ĺ���
			while(temp!=null) {
				//�ж�key�Ƿ����� ���򸲸ǣ�
				if(temp.key.equals(key)) {
					keyRepeat=true;
					temp.value=value;//ֻ�Ǹ���value���ɣ�����ֵ��hash,key,next�����ֲ��䣻
					break;
				}else {
					//key���ظ���
					iterLast=temp;
				    temp=temp.next;
				}
			}
			if(!keyRepeat) {//û�з���key�ظ��Ͱ�newNode�����������
				iterLast.next=newNode;
				size++;
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("[");
		for(int i=0;i<table.length;i++) {
			Node2 temp=table[i];
			while(temp!=null) {
				sb.append(temp.key+":"+temp.value+",");
			    temp=temp.next;
			}
			
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SxtHashMap02 m=new SxtHashMap02();
		m.put(10, "aa");
		m.put(20, "bb");
		m.put(30, "cc");
		m.put(20,"ssssssss");
		m.put(53, "ggg");
		m.put(69, "hhh");
		m.put(85, "kkkk");
		System.out.println(m);
	}
	
	
	
	public int myHash(int v,int length) {
		System.out.println("hash in myHash: &  "+(v&(length-1)));
		System.out.println("hash in myHash: %  "+(v%(length-1)));
		return  v&(length-1);
	}

}
