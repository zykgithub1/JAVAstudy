package demo_2021_9_27_leetcode;

import java.util.Arrays;

public class shortestWordsCode {
	Node root;
    {
        root=new Node();
    }
    public int minimumLengthEncoding(String[] words) {
       
        Arrays.sort(words,(a,b)->b.length()-a.length());
        int ans=0;
        for(String str:words){
            ans+=insert(str);
        }
        return ans;
    }

    public int insert(String words){
        Node cur=root;
        boolean isNew=false;
        for(int i=words.length()-1;i>=0;i--){
            int index=words.charAt(i)-'a';
            // System.out.print(cur==null);
            if(cur.sons[index]==null){
                isNew=true;
                cur.sons[index]=new Node(words.charAt(i));
            }
            cur=cur.sons[index];
        }
        return isNew?words.length()+1:0;
    }
    static class Node{
        char val;
        Node[]sons;
        public Node(){
            sons=new Node[26];
        }
        public Node(char v){
            val=v;
            sons=new Node[26];
        }
    }

}
