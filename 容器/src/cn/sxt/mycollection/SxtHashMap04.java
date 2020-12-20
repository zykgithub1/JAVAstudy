package cn.sxt.mycollection;
//自定义一个HashMap
//并且实现了put方法，在key值重复的时候覆盖，不同的时候添加；
//添加toString方法；方便查看
//增加get方法 根据key对map进行查找
public class SxtHashMap04<K,V> {
	Node3[] table;//位桶数组
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
			//此处数组的元素为空，则把新节点放进去；
			table[newNode.hash]=newNode;
			size++;
		}else {
			//如果不为空，就遍历，如果有相同的key，就替代，否则加在链表的后面
			while(temp!=null) {
				//判断key是否重新 ，则覆盖，
				if(temp.key.equals(key)) {
					keyRepeat=true;
					temp.value=value;//只是覆盖value即可，其他值（hash,key,next）保持不变；
					break;
				}else {
					//key不重复：
					iterLast=temp;
				    temp=temp.next;
				}
			}
			if(!keyRepeat) {//没有发生key重复就把newNode加在链表最后
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
