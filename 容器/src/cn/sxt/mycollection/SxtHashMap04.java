package cn.sxt.mycollection;
//�Զ���һ��HashMap
//����ʵ����put��������keyֵ�ظ���ʱ�򸲸ǣ���ͬ��ʱ����ӣ�
//���toString����������鿴
//����get���� ����key��map���в���
public class SxtHashMap04<K,V> {
	Node3[] table;//λͰ����
	int size;
	
	public SxtHashMap04() {
		table =new Node3[16];
	}
	public void put(K key,V value) {
		Node3 newNode=new Node3();
		newNode.hash=myHash(key.hashCode(),table.length);
		newNode.key=key;
		newNode.value=value;
		newNode.next=null;
		
		Node3 temp=table[newNode.hash];
		Node3 iterLast=null;
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
			Node3 temp=table[i];
			while(temp!=null) {
				sb.append(temp.key+":"+temp.value+",");
			    temp=temp.next;
			}
			
		}
		sb.setCharAt(sb.length()-1, ']');
		return sb.toString();
	}
	
	public Object get(K key) {
		int hash=myHash(key.hashCode(),table.length);
		Node3 temp=table[hash];
		V value=null;
		while(temp!=null) {
			if(temp.key.equals(key)) {
				value=(V)temp.value;
				break;
			}else {
				temp=temp.next;
			}
		}
		return value;
	}
	
	
	public static void main(String[] args) {
		SxtHashMap04<Integer,String> m=new SxtHashMap04<>();
		m.put(10, "aa");
		m.put(20, "bb");
		m.put(30, "cc");
		m.put(20,"ssssssss");
		m.put(53, "ggg");
		m.put(69, "hhh");
		m.put(85, "kkkk");
		
		System.out.println(m.get(9));
	}
	
	
	
	public int myHash(int v,int length) {
		System.out.println("hash in myHash: &  "+(v&(length-1)));
		System.out.println("hash in myHash: %  "+(v%(length-1)));
		return  v&(length-1);
	}

}
