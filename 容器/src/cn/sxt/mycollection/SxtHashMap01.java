package cn.sxt.mycollection;
//�Զ���һ��HashMap
//����ʵ����put��������keyֵ�ظ���ʱ�򸲸ǣ���ͬ��ʱ����ӣ�

public class SxtHashMap01 {
	Node2[] table;//λͰ����
	int size;
	
	public SxtHashMap01() {
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
			}
		}
		
		
		
		
	}
	public static void main(String[] args) {
		SxtHashMap01 m=new SxtHashMap01();
		m.put(10, "aa");
		m.put(20, "bb");
		m.put(30, "cc");
		m.put(20,"ssssssss");
		m.put(53, "zzzz");
		m.put(69, "yyyy");
		m.put(95, "kkkk");
		System.out.println(m);
	}
	
	
	
	public int myHash(int v,int length) {
		System.out.println("hash in myHash: &  "+(v&(length-1)));
		System.out.println("hash in myHash: %  "+(v%(length-1)));
		return  v&(length-1);
	}

}
