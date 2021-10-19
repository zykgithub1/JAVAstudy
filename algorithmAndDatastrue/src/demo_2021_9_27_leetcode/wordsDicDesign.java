package demo_2021_9_27_leetcode;

public class wordsDicDesign {
	static class Node{
        boolean isEnd;
        Node[]sons;
        public Node(){
            sons=new Node[26];
        }
    }
    Node root;

    public wordsDicDesign() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node cur=root;
        char[]chs=word.toCharArray();
        int index=0;
        for(int i=0;i<chs.length;i++){
            index=chs[i]-'a';
            if(cur.sons[index]==null){
                cur.sons[index]=new Node();
            }
            cur=cur.sons[index];
        }
        cur.isEnd=true;
    }
    
    public boolean search(String word) {
        Node cur=root;
        return dfs(cur,word.toCharArray(),0);
    }
    public boolean dfs(Node cur,char[]chs,int index){
        if(cur==null){
            return false;
        }
        if(index==chs.length){
            return cur.isEnd;
        }
        if(chs[index]=='.'){
            for(int i=0;i<26;i++){
                if(cur.sons[i]!=null){
                    if(dfs(cur.sons[i],chs,index+1))
                    return true;
                }
            }
        }else{
            cur=cur.sons[chs[index]-'a'];
            if(dfs(cur,chs,index+1)){
                return true;
            }
        }
        return false;
    }

}
