package cn.sxt.mycollection;
//自定义一个HashMap
//并且实现了put方法，在key值重复的时候覆盖，不同的时候添加；
//添加toString方法；方便查看
public class SxtHashMap02 {
	Node2[] table;//位桶数组
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
