package demo_2021_9_27_leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	static class Node{
        public int key;
        public int value;
        public Node pre;
        public Node next;
        public Node(int k,int v){
            this.value=v;
            this.key=k;
        }
        public Node(){
            
        }
    }
    Map<Integer,Node>map;
    public int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap();
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.pre=head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            moveToHead(map.get(key));
            return map.get(key).value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).value=value;
            moveToHead(map.get(key));
            return;
        }else{
            map.put(key,new Node(key,value));
            insertToHead(map.get(key));
            if(map.size()>capacity){
                Node node=removeLast();
                map.remove(node.key);
            }
        }
    }
    public void insertToHead(Node node){
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
        node.pre=head;
    }
    public void deleteNode(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    public void moveToHead(Node node){
        deleteNode(node);
        insertToHead(node);
    }

    public Node removeLast(){
        Node cur=tail.pre;
        cur.pre.next=tail;
        tail.pre=cur.pre;
        return cur;
    }

}
