package demo_2021_9_27_leetcode;

public class trie {
	static class Node{
        char val;
        Node[]sons;
        boolean isEnd;
        public Node(char ch){
            val=ch;
            sons=new Node[26];
        }
        public Node(){
            sons=new Node[26];
        }
    }
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root=new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur=root;
        char[]chs=word.toCharArray();
        for(char ch:chs){
            if(cur.sons[ch-'a']==null){
                cur.sons[ch-'a']=new Node(ch);
            }
            cur=cur.sons[ch-'a'];
        }
        cur.isEnd=true;

    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return find(word)!=null&&find(word).isEnd==true;

    }

    public Node find(String word){
        Node cur=root;
        char[]chs=word.toCharArray();
        for(char ch:chs){
            if(cur.sons[ch-'a']!=null){
                cur=cur.sons[ch-'a'];
            }else{
                return null;
            }
        }
        return cur;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return find(prefix)!=null&&find(prefix)!=root;
    }

}
